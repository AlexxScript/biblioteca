/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import abstracciones.ArticuloCientifico;
import abstracciones.Ubicacion;
import abstracciones.VideoCientifico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import utils.Conexion;

/**
 *
 * @author alejandro ameneyro
 */
public class VideoDAO {
    Connection con;
    PreparedStatement ps;

    public VideoDAO() {
    }
    
    public void cargarDatos(DefaultTableModel modeloVideo,JTable tblVideo, JTable tblLibros5, String idBiblioteca) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = Conexion.conectar();
            String query = "SELECT vid.nombre, vid.duracion, vid.id AS idT, " +
                   "e.autores, e.fechaLanz AS fecha_lanzamiento, " +
                   "e.idioma, e.cantidad, e.cantidadreal, u.pasillo, u.repisa, u.anaquel, u.seccion, " +
                   "e.id AS idE, vid.id AS idT, u.id AS idU " +
                   "FROM videocientifico vid " +
                   "JOIN ejemplar e ON vid.id_ejemplar = e.id " +
                   "JOIN ubicacion u ON e.ubicacion_id = u.id WHERE e.id_biblioteca = ?";

            ps = con.prepareStatement(query);
            ps.setString(1, idBiblioteca);
            rs = ps.executeQuery();
            modeloVideo.setRowCount(0);

             while (rs.next()) {
                Object[] fila = new Object[14]; // Hay 14 columnas según tituloVideo

                fila[0] = rs.getString("nombre");                     
                fila[1] = rs.getString("duracion");                  
                fila[2] = rs.getString("autores");                    
                fila[3] = rs.getDate("fecha_lanzamiento");           
                fila[4] = rs.getString("idioma");                    
                fila[5] = rs.getInt("cantidad");                      
                fila[6] = rs.getInt("cantidadreal");                 
                fila[7] = rs.getString("pasillo");                    
                fila[8] = rs.getString("repisa");                     
                fila[9] = rs.getString("anaquel");                    
                fila[10] = rs.getString("seccion");                  
                fila[11] = rs.getInt("idE");                         
                fila[12] = rs.getInt("idT");                          
                fila[13] = rs.getInt("idU");                          

                modeloVideo.addRow(fila);
            }

            // Asignar el modelo a las tablas
            tblVideo.setModel(modeloVideo);
            tblLibros5.setModel(modeloVideo);
        } catch (SQLException e) {
            System.err.println("Error al cargar los datos: " + e);
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.err.println("Error al cerrar recursos: " + e);
            }
        }
    }

    public Object[] registrarProducto(Ubicacion ubi, VideoCientifico video ,String idBiblioteca) {
        if (ubi.getAnaquel().isEmpty() || ubi.getPasillo().isEmpty() || ubi.getRepisa().isEmpty() ||
            ubi.getSeccion().isEmpty() || video.getAutores().isEmpty() || video.getCantidad() <= 0 ||
            video.getDuracion().isEmpty() || video.getNombre().isEmpty() || video.getIdioma().isEmpty()) {
            return null;
        }

        try {
            con = Conexion.conectar();
            String sqlUbicacion = "INSERT INTO ubicacion (pasillo, repisa, anaquel, seccion) VALUES (?, ?, ?, ?)";
            ps = con.prepareStatement(sqlUbicacion,ps.RETURN_GENERATED_KEYS);
            ps.setString(1, ubi.getPasillo());
            ps.setString(2, ubi.getRepisa());
            ps.setString(3, ubi.getAnaquel());
            ps.setString(4, ubi.getSeccion());
            ps.executeUpdate();

            ResultSet rsUbicacion = ps.getGeneratedKeys();
            int ubicacionId = 0;
            if (rsUbicacion.next()) {
                ubicacionId = rsUbicacion.getInt(1);
            }

            String sqlEjemplar = "INSERT INTO ejemplar (autores, fechaLanz, idioma, cantidad, ubicacion_id, id_biblioteca,cantidadreal) VALUES (?, ?, ?, ?, ?, ?, ?)";
            ps = con.prepareStatement(sqlEjemplar, ps.RETURN_GENERATED_KEYS);
            ps.setString(1, video.getAutores());
            ps.setDate(2, java.sql.Date.valueOf(video.getFechaLanz()));
            ps.setString(3, video.getIdioma());
            ps.setInt(4, video.getCantidad());
            ps.setInt(5, ubicacionId);
            ps.setInt(6, Integer.parseInt(idBiblioteca));
            ps.setInt(7, video.getCantidad());
            ps.executeUpdate();
            
            ResultSet rsEjemplar = ps.getGeneratedKeys();
            int ejemplarId = 0;
            if (rsEjemplar.next()) {
                ejemplarId = rsEjemplar.getInt(1);
            }

            String sqlLibro = "INSERT INTO videocientifico (nombre, duracion, id_ejemplar) VALUES (?, ?, ?)";
            ps = con.prepareStatement(sqlLibro,ps.RETURN_GENERATED_KEYS);
            ps.setString(1, video.getNombre());
            ps.setString(2, video.getDuracion());
            ps.setInt(3, ejemplarId);
            ps.executeUpdate();
            
            ResultSet rsLibro = ps.getGeneratedKeys();
            int libroId = 0;
            if (rsLibro.next()) {
                libroId = rsLibro.getInt(1);
            }

            return new Object[]{
                video.getNombre(), video.getDuracion(), video.getAutores(), video.getFechaLanz(),
                video.getIdioma(), video.getCantidad(), video.getCantidadReal(),
                ubi.getPasillo(), ubi.getRepisa(), ubi.getAnaquel(), ubi.getSeccion(), libroId, ejemplarId, ubicacionId
            };
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    } 
    
    public boolean actualizarProducto(Ubicacion ubi, VideoCientifico video, String idBiblioteca, JTable tblLibros, JTable tblLibros1) {
        //if (ubi.getAnaquel().isEmpty() || ubi.getPasillo().isEmpty() || ubi.getRepisa().isEmpty() ||
        //    ubi.getSeccion().isEmpty() || video.getAutores().isEmpty() || video.getCantidad() <= 0 ||
        //    video.getDuracion().isEmpty() || video.getNombre().isEmpty() || video.getIdioma().isEmpty()) {
        //    return false;
        //}

        try {
            con = Conexion.conectar();

            String sqlUbicacion = "UPDATE ubicacion SET pasillo = ?, repisa = ?, anaquel = ?, seccion = ? WHERE id = ?";
            ps = con.prepareStatement(sqlUbicacion);
            ps.setString(1, ubi.getPasillo());
            ps.setString(2, ubi.getRepisa());
            ps.setString(3, ubi.getAnaquel());
            ps.setString(4, ubi.getSeccion());
            ps.setString(5, ubi.getId());
            ps.executeUpdate();

            String sqlEjemplar = "UPDATE ejemplar SET autores = ?, fechaLanz = ?, idioma = ?, cantidad = ?, cantidadreal = ? WHERE id = ?";
            ps = con.prepareStatement(sqlEjemplar);
            ps.setString(1, video.getAutores());
            ps.setDate(2, java.sql.Date.valueOf(video.getFechaLanz()));
            ps.setString(3, video.getIdioma());
            ps.setInt(4, video.getCantidad());
            ps.setInt(5, video.getCantidadReal());
            ps.setString(6, video.getId());
            ps.executeUpdate();

            String sqlArticulo = "UPDATE videocientifico SET nombre = ?, duracion = ? WHERE id = ?";
            ps = con.prepareStatement(sqlArticulo);
            ps.setString(1, video.getNombre());
            ps.setString(2, video.getDuracion());
            ps.setString(3, video.getIdVideo());
            ps.executeUpdate();
            
            DefaultTableModel modeloArt = (DefaultTableModel) tblLibros.getModel();
            cargarDatos(modeloArt, tblLibros, tblLibros1,idBiblioteca);
            return true;
        } catch (SQLException e) {
            System.out.println("Error al actualizar el producto: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminarProducto(String libroId, JTable tblLibros, JTable tblLibros1, String idBiblioteca) {
        try {
            con = Conexion.conectar();

            String sqlLibro = "DELETE FROM videocientifico WHERE id = ?";
            ps = con.prepareStatement(sqlLibro);
            ps.setString(1, libroId);
            ps.executeUpdate();
            System.out.println("Video eliminado: " + libroId);

            DefaultTableModel modeloLibro = (DefaultTableModel) tblLibros.getModel();
            cargarDatos(modeloLibro, tblLibros, tblLibros1, idBiblioteca);

            return true;
        } catch (SQLException e) {
            System.out.println("Error al eliminar el libro: " + e.getMessage());
            return false;
        }
    }
    
    public void actualizarCantidadReal(JTable table, String idE, int nuevaCantidadReal) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        for (int i = 0; i < model.getRowCount(); i++) {
            if (model.getValueAt(i, 11).toString().equals(idE)) { 
                model.setValueAt(nuevaCantidadReal, i, 6);
                break;
            }
        }
    }
}
