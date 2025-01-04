/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import abstracciones.ArticuloCientifico;
import abstracciones.Ubicacion;
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
public class ArticuloIDAO {
    Connection con;
    PreparedStatement ps;

    public ArticuloIDAO() {
    }
    
    public void cargarDatos(DefaultTableModel modeloArtIn,JTable tblArtInves, JTable tblLibros3, String idBiblioteca) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = Conexion.conectar();
            String query = "SELECT ac.nombreart AS nombre_del_art, ac.areaespecialidad, ac.fechaescr AS fecha_escritura, " +
                       "ac.insitutoProveniencia AS instituto_proveniencia, e.autores, e.fechaLanz AS fecha_lanzamiento, " +
                       "e.idioma, e.cantidad, e.cantidadreal, u.pasillo, u.repisa, u.anaquel, u.seccion, " +
                       "e.id AS idE, ac.id AS idT, u.id AS idU " +
                       "FROM articulocientifico ac " +
                       "JOIN ejemplar e ON ac.articulocientifico_id = e.id " +
                       "JOIN ubicacion u ON e.ubicacion_id = u.id WHERE e.id_biblioteca = ?";

            ps = con.prepareStatement(query);
            ps.setString(1, idBiblioteca);
            rs = ps.executeQuery();
            modeloArtIn.setRowCount(0);

            while (rs.next()) {
                Object[] fila = new Object[16]; // Hay 16 columnas según tituloArtIn
                fila[0] = rs.getString("nombre_del_art");
                fila[1] = rs.getString("areaespecialidad");
                fila[2] = rs.getDate("fecha_escritura");
                fila[3] = rs.getString("instituto_proveniencia");
                fila[4] = rs.getString("autores");
                fila[5] = rs.getDate("fecha_lanzamiento");
                fila[6] = rs.getString("idioma");
                fila[7] = rs.getInt("cantidad");
                fila[8] = rs.getInt("cantidadreal"); // Asumiendo que es igual a cantidad
                fila[9] = rs.getString("pasillo");
                fila[10] = rs.getString("repisa");
                fila[11] = rs.getString("anaquel");
                fila[12] = rs.getString("seccion");
                fila[13] = rs.getInt("idE");
                fila[14] = rs.getInt("idT");
                fila[15] = rs.getInt("idU");
                modeloArtIn.addRow(fila);
            }

            // Asignar el modelo a las tablas
            tblArtInves.setModel(modeloArtIn);
            tblLibros3.setModel(modeloArtIn);
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

    public Object[] registrarProducto(Ubicacion ubi, ArticuloCientifico lib ,String idBiblioteca) {
        if (ubi.getAnaquel().isEmpty() || ubi.getPasillo().isEmpty() || ubi.getRepisa().isEmpty() ||
            ubi.getSeccion().isEmpty() || lib.getAutores().isEmpty() || lib.getCantidad() <= 0 ||
            lib.getAreaespecialidad().isEmpty() || lib.getFechaescr().isEmpty() || lib.getIdioma().isEmpty() ||
            lib.getInsitutoProvinencia().isEmpty() || lib.getNombreArt().isEmpty()) {
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
            ps.setString(1, lib.getAutores());
            ps.setDate(2, java.sql.Date.valueOf(lib.getFechaLanz()));
            ps.setString(3, lib.getIdioma());
            ps.setInt(4, lib.getCantidad());
            ps.setInt(5, ubicacionId);
            ps.setInt(6, Integer.parseInt(idBiblioteca));
            ps.setInt(7, lib.getCantidad());
            ps.executeUpdate();
            
            ResultSet rsEjemplar = ps.getGeneratedKeys();
            int ejemplarId = 0;
            if (rsEjemplar.next()) {
                ejemplarId = rsEjemplar.getInt(1);
            }

            String sqlLibro = "INSERT INTO articulocientifico (areaespecialidad, fechaescr, insitutoProveniencia, articulocientifico_id,nombreart) VALUES (?, ?, ?, ?, ?)";
            ps = con.prepareStatement(sqlLibro,ps.RETURN_GENERATED_KEYS);
            ps.setString(1, lib.getAreaespecialidad());
            ps.setString(2, lib.getFechaescr());
            ps.setString(3, lib.getInsitutoProvinencia());
            ps.setInt(4, ejemplarId);
            ps.setString(5, lib.getNombreArt());
            ps.executeUpdate();
            
            ResultSet rsLibro = ps.getGeneratedKeys();
            int libroId = 0;
            if (rsLibro.next()) {
                libroId = rsLibro.getInt(1);
            }

            return new Object[] {
                lib.getNombreArt(), lib.getAreaespecialidad(), lib.getFechaescr(), lib.getInsitutoProvinencia(),
                lib.getAutores(), lib.getFechaLanz(), lib.getIdioma(), lib.getCantidad(), lib.getCantidad(),
                ubi.getPasillo(), ubi.getRepisa(), ubi.getAnaquel(), ubi.getSeccion(), libroId, ejemplarId, ubicacionId
            };
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    } 
    
    public boolean actualizarProducto(Ubicacion ubi, ArticuloCientifico art, String idBiblioteca, JTable tblLibros, JTable tblLibros1) {
        if (ubi.getAnaquel().isEmpty() || ubi.getPasillo().isEmpty() || ubi.getRepisa().isEmpty() ||
            ubi.getSeccion().isEmpty() || art.getAutores().isEmpty() || art.getCantidad() <= 0 ||
            art.getAreaespecialidad().isEmpty() || art.getFechaescr().isEmpty() || art.getIdioma().isEmpty() ||
            art.getInsitutoProvinencia().isEmpty() || art.getNombreArt().isEmpty()) {
            return false;
        }

        try {
            con = Conexion.conectar();

            // Actualizar ubicación
            String sqlUbicacion = "UPDATE ubicacion SET pasillo = ?, repisa = ?, anaquel = ?, seccion = ? WHERE id = ?";
            ps = con.prepareStatement(sqlUbicacion);
            ps.setString(1, ubi.getPasillo());
            ps.setString(2, ubi.getRepisa());
            ps.setString(3, ubi.getAnaquel());
            ps.setString(4, ubi.getSeccion());
            ps.setString(5, ubi.getId());
            ps.executeUpdate();

            // Actualizar ejemplar
            //            //String sqlEjemplar = "UPDATE ejemplar SET autores = ?, fechaLanz = ?, idioma = ?, cantidad = ?, cantidadreal = ? WHERE id = ?";
            String sqlEjemplar = "UPDATE ejemplar SET autores = ?, fechaLanz = ?, idioma = ?, cantidad = ?, cantidadreal = ? WHERE id = ?";
            ps = con.prepareStatement(sqlEjemplar);
            ps.setString(1, art.getAutores());
            ps.setDate(2, java.sql.Date.valueOf(art.getFechaLanz()));
            ps.setString(3, art.getIdioma());
            ps.setInt(4, art.getCantidad());
            ps.setInt(5, art.getCantidadReal());
            ps.setString(6, art.getId());
            ps.executeUpdate();

            // Actualizar artículo científico
            String sqlArticulo = "UPDATE articulocientifico SET areaespecialidad = ?, fechaescr = ?, insitutoProveniencia = ?, nombreart = ? WHERE id = ?";
            ps = con.prepareStatement(sqlArticulo);
            ps.setString(1, art.getAreaespecialidad());
            ps.setDate(2, java.sql.Date.valueOf(art.getFechaescr()));
            ps.setString(3, art.getInsitutoProvinencia());
            ps.setString(4, art.getNombreArt());
            ps.setString(5, art.getArticulocientifico_id());
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

            String sqlLibro = "DELETE FROM articulocientifico WHERE id = ?";
            ps = con.prepareStatement(sqlLibro);
            ps.setString(1, libroId);
            ps.executeUpdate();
            System.out.println("Articulo eliminado: " + libroId);

            DefaultTableModel modeloLibro = (DefaultTableModel) tblLibros.getModel();
            cargarDatos(modeloLibro, tblLibros, tblLibros1, idBiblioteca);

            return true;
        } catch (SQLException e) {
            System.out.println("Error al eliminar el libro: " + e.getMessage());
            return false;
        }
    }
}
