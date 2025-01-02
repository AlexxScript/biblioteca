/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import abstracciones.Articulo;
import abstracciones.Periodico;
import abstracciones.Revista;
import abstracciones.Ubicacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import utils.Conexion;

/**
 *
 * @author alejandro ameneyro
 */
public class RevistaDAO {
    Connection con;
    PreparedStatement ps;
    
    public void cargarDatos(DefaultTableModel modeloRevista,JTable tblRevista, JTable tblLibros4, String idBiblioteca) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = Conexion.conectar();
            String query = "SELECT p.id AS idT, p.nombre, p.distribuidor, p.empresa, p.tipoRevista, " +
                           "e.id AS idE, e.autores, e.fechaLanz AS fecha_lanzamiento, e.idioma, " +
                           "e.cantidad, e.cantidadreal, u.id AS idU, u.pasillo, u.repisa, u.anaquel, u.seccion " +
                           "FROM revista p " +
                           "JOIN ejemplar e ON p.ejemplar_id = e.id " +
                           "JOIN ubicacion u ON e.ubicacion_id = u.id WHERE e.id_biblioteca = ?";

            ps = con.prepareStatement(query);
            ps.setString(1, idBiblioteca);
            rs = ps.executeQuery();
            modeloRevista.setRowCount(0);

            while (rs.next()) {
                Object[] fila = new Object[15];
                fila[0] = rs.getString("nombre");
                fila[1] = rs.getString("distribuidor");
                fila[2] = rs.getString("empresa");
                fila[3] = rs.getString("tipoRevista");
                fila[4] = rs.getString("fecha_lanzamiento");
                fila[5] = rs.getString("idioma");
                fila[6] = rs.getInt("cantidad");
                fila[7] = rs.getInt("cantidadreal");
                fila[8] = rs.getString("pasillo");
                fila[9] = rs.getString("repisa");
                fila[10] = rs.getString("anaquel");
                fila[11] = rs.getString("seccion");
                fila[12] = rs.getString("idE");
                fila[13] = rs.getString("idT");
                fila[14] = rs.getString("idU");

                modeloRevista.addRow(fila);
            }

            tblRevista.setModel(modeloRevista);
            tblLibros4.setModel(modeloRevista);
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

    public Object[] registrarProducto(Ubicacion ubi, Revista peri, ArrayList<Articulo> articulos, String idBiblioteca) {
        if (ubi.getAnaquel().equals("") || ubi.getPasillo().equals("") || ubi.getRepisa().equals("") ||
            ubi.getSeccion().equals("") || peri.getAutores().equals("") || peri.getCantidad() <= 0 ||
            peri.getEmpresa().equals("") || peri.getFechaLanz().equals("") || peri.getIdioma().equals("") ||
            peri.getDistribuidor().equals("") || peri.getTipoRevista().equals("")) {
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
            ps.setString(1, peri.getAutores());
            ps.setDate(2, java.sql.Date.valueOf(peri.getFechaLanz()));
            ps.setString(3, peri.getIdioma());
            ps.setInt(4, peri.getCantidad());
            ps.setInt(5, ubicacionId);
            ps.setInt(6, Integer.parseInt(idBiblioteca));
            ps.setInt(7, peri.getCantidad());
            ps.executeUpdate();
            
            ResultSet rsEjemplar = ps.getGeneratedKeys();
            int ejemplarId = 0;
            if (rsEjemplar.next()) {
                ejemplarId = rsEjemplar.getInt(1);
            }

            String sqlLibro = "INSERT INTO revista (nombre, distribuidor, empresa, tipoRevista, ejemplar_id) VALUES (?, ?, ?, ?, ?)";
            ps = con.prepareStatement(sqlLibro, ps.RETURN_GENERATED_KEYS);
            ps.setString(1, peri.getNombre());
            ps.setString(2, peri.getDistribuidor());
            ps.setString(3, peri.getEmpresa());
            ps.setString(4, peri.getTipoRevista());
            ps.setInt(5, ejemplarId);
            ps.executeUpdate();
            
            ResultSet rsLibro = ps.getGeneratedKeys();
            int libroId = 0;
            if (rsLibro.next()) {
                libroId = rsLibro.getInt(1);
            }
            
            String sqlArt = "INSERT INTO articulo (tituloArt,autores,fechaPublicacion,id_revista) VALUES (?, ?, ?, ?)";
            for(int i = 0; i<articulos.size(); i++){
               ps = con.prepareStatement(sqlArt,ps.RETURN_GENERATED_KEYS);
               ps.setString(1, articulos.get(i).getTituloArt());
               ps.setString(2, articulos.get(i).getAutoresArt());
               ps.setString(3, articulos.get(i).getFechaPublicacion());
               ps.setInt(4, libroId);
               ps.executeUpdate();
            }

            return new Object[] {
                peri.getNombre(), peri.getDistribuidor(), peri.getEmpresa(), peri.getTipoRevista(),
                peri.getFechaLanz(), peri.getIdioma(), peri.getCantidad(), peri.getCantidad(), // cantidad y cantidadTotal
                ubi.getPasillo(), ubi.getRepisa(), ubi.getAnaquel(), ubi.getSeccion(),
                ejemplarId, libroId, ubicacionId
            };
        } catch (SQLException e) {
            System.out.println("Error: " + e);
            return null;
        }
    } 
    
    public boolean actualizarProducto(Ubicacion ubi, Revista peri, String idBiblioteca, JTable tblLibros, JTable tblLibros1) {
        if (ubi.getAnaquel().equals("") || ubi.getPasillo().equals("") || ubi.getRepisa().equals("") ||
            ubi.getSeccion().equals("") || peri.getAutores().equals("") || peri.getCantidad() <= 0 ||
            peri.getEmpresa().equals("") || peri.getFechaLanz().equals("") || peri.getIdioma().equals("") ||
            peri.getDistribuidor().equals("") || peri.getTipoRevista().equals("")) {
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
            ps.setString(1, peri.getAutores());
            ps.setDate(2, java.sql.Date.valueOf(peri.getFechaLanz()));
            ps.setString(3, peri.getIdioma());
            ps.setInt(4, peri.getCantidad());
            ps.setInt(5, peri.getCantidadReal());
            ps.setString(6, peri.getId());
            ps.executeUpdate();
            System.out.println(peri.getId());

            // Actualizar Libro
            
            String sqlLibro = "UPDATE revista SET nombre = ?, distribuidor = ?, empresa = ?, tipoRevista = ? WHERE id = ?";
            ps = con.prepareStatement(sqlLibro, ps.RETURN_GENERATED_KEYS);
            ps.setString(1, peri.getNombre());
            ps.setString(2, peri.getDistribuidor());
            ps.setString(3, peri.getEmpresa());
            ps.setString(4, peri.getTipoRevista());
            ps.setString(5, peri.getIdRevista());
            ps.executeUpdate();
            // Recargar datos en las JTable
            DefaultTableModel modeloRevista = (DefaultTableModel) tblLibros.getModel();
            cargarDatos(modeloRevista, tblLibros, tblLibros1, idBiblioteca);

            return true;
        } catch (SQLException e) {
            System.out.println("Error al actualizar el periodico: " + e);
            return false;
        }
    }

    public boolean eliminarProducto(String libroId, JTable tblLibros, JTable tblLibros1, String idBiblioteca) {
        try {
            con = Conexion.conectar();

            String sqlLibro = "DELETE FROM revista WHERE id = ?";
            ps = con.prepareStatement(sqlLibro);
            ps.setString(1, libroId);
            ps.executeUpdate();
            System.out.println("Revista eliminada: " + libroId);

            DefaultTableModel modeloRevista = (DefaultTableModel) tblLibros.getModel();
            cargarDatos(modeloRevista, tblLibros, tblLibros1, idBiblioteca);

            return true;
        } catch (SQLException e) {
            System.out.println("Error al eliminar el Periodico: " + e);
            return false;
        }
    }
}
