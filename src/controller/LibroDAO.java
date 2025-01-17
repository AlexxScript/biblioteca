/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import abstracciones.Libro;
import abstracciones.Ubicacion;

import interfaces.ControllerDao;

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
public class LibroDAO {
    
    Connection con;
    PreparedStatement ps;

    public LibroDAO() {
    }
    
    public void cargarDatos(DefaultTableModel modeloLibro,JTable tblLibros, JTable tblLibros1, String idBiblioteca) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = Conexion.conectar();
            String query = "SELECT l.id AS idT, l.titulo, l.editorial, l.pasta, l.volumen, l.tema, l.pagina, " +
                           "l.tipoLibro, e.id AS idE , e.autores, e.fechaLanz AS fecha_lanzamiento, e.idioma, " +
                           "e.cantidad, e.cantidadreal, u.id AS idU, u.pasillo, u.repisa, u.anaquel, u.seccion " +
                           "FROM libro l " +
                           "JOIN ejemplar e ON l.libro_id = e.id " +
                           "JOIN ubicacion u ON e.ubicacion_id = u.id WHERE e.id_biblioteca = ?";

            ps = con.prepareStatement(query);
            ps.setString(1, idBiblioteca);
            rs = ps.executeQuery();
            modeloLibro.setRowCount(0);

            while (rs.next()) {
                Object[] fila = new Object[17];
                fila[0] = rs.getString("titulo");
                fila[1] = rs.getString("editorial");
                fila[2] = rs.getString("pasta");
                fila[3] = rs.getString("volumen");
                fila[4] = rs.getString("tipoLibro");
                fila[5] = rs.getString("autores");
                fila[6] = rs.getDate("fecha_lanzamiento");
                fila[7] = rs.getString("idioma");
                fila[8] = rs.getInt("cantidad");
                fila[9] = rs.getInt("cantidadreal");
                fila[10] = rs.getString("pasillo");
                fila[11] = rs.getString("repisa");
                fila[12] = rs.getString("anaquel");
                fila[13] = rs.getString("seccion");
                fila[14] = rs.getString("idE");
                fila[15] = rs.getString("idT");
                fila[16] = rs.getString("idU");
                System.out.println(rs.getInt("cantidadreal"));
                modeloLibro.addRow(fila);
            }

            tblLibros.setModel(modeloLibro);
            tblLibros1.setModel(modeloLibro);
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

    public Object[] registrarProducto(Ubicacion ubi, Libro lib, String idBiblioteca) {
        if (ubi.getAnaquel().equals("") || ubi.getPasillo().equals("") || ubi.getRepisa().equals("") ||
            ubi.getSeccion().equals("") || lib.getAutores().equals("") || lib.getCantidad() <= 0 ||
            lib.getEditorial().equals("") || lib.getFechaLanz().equals("") || lib.getIdioma().equals("") ||
            lib.getPasta().equals("") || lib.getTipoLibro().equals("") || lib.getTitulo().equals("") ||
            lib.getVolumen().equals("")) {
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
            ps.setInt(7, lib.getCantidadReal());
            ps.executeUpdate();
            
            ResultSet rsEjemplar = ps.getGeneratedKeys();
            int ejemplarId = 0;
            if (rsEjemplar.next()) {
                ejemplarId = rsEjemplar.getInt(1);
            }

            String sqlLibro = "INSERT INTO libro (titulo, editorial, pasta, volumen, tipoLibro, libro_id) VALUES (?, ?, ?, ?, ?, ?)";
            ps = con.prepareStatement(sqlLibro,ps.RETURN_GENERATED_KEYS);
            ps.setString(1, lib.getTitulo());
            ps.setString(2, lib.getEditorial());
            ps.setString(3, lib.getPasta());
            ps.setString(4, lib.getVolumen());
            ps.setString(5, lib.getTipoLibro());
            ps.setInt(6, ejemplarId);
            ps.executeUpdate();
            
            ResultSet rsLibro = ps.getGeneratedKeys();
            int libroId = 0;
            if (rsLibro.next()) {
                libroId = rsLibro.getInt(1);
            }

            return new Object[] {
                lib.getTitulo(), lib.getEditorial(), lib.getPasta(), lib.getVolumen(),
                lib.getTipoLibro(), lib.getAutores(), java.sql.Date.valueOf(lib.getFechaLanz()),
                lib.getIdioma(), lib.getCantidad(), lib.getCantidadReal(), 
                ubi.getPasillo(), ubi.getRepisa(), ubi.getAnaquel(), ubi.getSeccion(),ejemplarId,libroId,ubicacionId
            };
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    } 
    
    public boolean actualizarProducto(Ubicacion ubi, Libro lib, String idBiblioteca, JTable tblLibros, JTable tblLibros1) {
        if (ubi.getAnaquel().equals("") || ubi.getPasillo().equals("") || ubi.getRepisa().equals("") ||
            ubi.getSeccion().equals("") || lib.getAutores().equals("") || lib.getCantidad() <= 0 ||
            lib.getEditorial().equals("") || lib.getFechaLanz().equals("") || lib.getIdioma().equals("") ||
            lib.getPasta().equals("") || lib.getTipoLibro().equals("") || lib.getTitulo().equals("") ||
            lib.getVolumen().equals("")) {
            return false;
        }

        try {
            con = Conexion.conectar();

            // Actualizar Ubicación
            String sqlUbicacion = "UPDATE ubicacion SET pasillo = ?, repisa = ?, anaquel = ?, seccion = ? WHERE id = ?";
            ps = con.prepareStatement(sqlUbicacion);
            ps.setString(1, ubi.getPasillo());
            ps.setString(2, ubi.getRepisa());
            ps.setString(3, ubi.getAnaquel());
            ps.setString(4, ubi.getSeccion());
            ps.setString(5, ubi.getId()); 
            ps.executeUpdate();
            System.out.println(ubi.getId());

            // Actualizar Ejemplar
            String sqlEjemplar = "UPDATE ejemplar SET autores = ?, fechaLanz = ?, idioma = ?, cantidad = ?, cantidadreal = ? WHERE id = ?";
            ps = con.prepareStatement(sqlEjemplar);
            ps.setString(1, lib.getAutores());
            ps.setDate(2, java.sql.Date.valueOf(lib.getFechaLanz()));
            ps.setString(3, lib.getIdioma());
            ps.setInt(4, lib.getCantidad());
            ps.setInt(5, lib.getCantidadReal());
            ps.setString(6, lib.getId());
            ps.executeUpdate();
            System.out.println(lib.getId());

            // Actualizar Libro
            String sqlLibro = "UPDATE libro SET titulo = ?, editorial = ?, pasta = ?, volumen = ?, tipoLibro = ? WHERE id = ?";
            ps = con.prepareStatement(sqlLibro);
            ps.setString(1, lib.getTitulo());
            ps.setString(2, lib.getEditorial());
            ps.setString(3, lib.getPasta());
            ps.setString(4, lib.getVolumen());
            ps.setString(5, lib.getTipoLibro());
            ps.setString(6, lib.getLibroid());
            ps.executeUpdate();
            System.out.println(lib.getLibroid());
            // Recargar datos en las JTable
            DefaultTableModel modeloLibro = (DefaultTableModel) tblLibros.getModel();
            cargarDatos(modeloLibro, tblLibros, tblLibros1, idBiblioteca);

            return true;
        } catch (SQLException e) {
            System.out.println("Error al actualizar el libro: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminarProducto(String libroId,String eid,String udi, JTable tblLibros, JTable tblLibros1, String idBiblioteca) {
        try {
            con = Conexion.conectar();

            String sqlLibro = "DELETE FROM libro WHERE id = ?";
            ps = con.prepareStatement(sqlLibro);
            ps.setString(1, libroId);
            ps.executeUpdate();
            
            String sqle = "DELETE FROM ejemplar WHERE id = ?";
            ps = con.prepareStatement(sqle);
            ps.setString(1, eid);
            ps.executeUpdate();
            
            String sqlub = "DELETE FROM ubicacion WHERE id = ?";
            ps = con.prepareStatement(sqlub);
            ps.setString(1, udi);
            ps.executeUpdate();

            DefaultTableModel modeloLibro = (DefaultTableModel) tblLibros.getModel();
            cargarDatos(modeloLibro, tblLibros, tblLibros1,idBiblioteca);

            return true;
        } catch (SQLException e) {
            System.out.println("Error al eliminar el libro: " + e.getMessage());
            return false;
        }
    }
    
    public void actualizarCantidadReal(JTable table, String idE, int nuevaCantidadReal) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        for (int i = 0; i < model.getRowCount(); i++) {
            if (model.getValueAt(i, 14).toString().equals(idE)) { 
                model.setValueAt(nuevaCantidadReal, i, 9);
                break;
            }
        }
    }
}
