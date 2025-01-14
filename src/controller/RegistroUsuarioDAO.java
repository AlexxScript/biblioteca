/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import abstracciones.Usuario;
import abstracciones.Biblioteca;
import abstracciones.Login;

import utils.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alejandro ameneyro
 */
public class RegistroUsuarioDAO {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public Login login(Usuario usuario){
        Login lg = new Login();
        try{
            String qy = "SELECT id,direccion, telefono, nombreusuario, perfil,id_biblioteca FROM usuario WHERE nombreusuario = ? AND contrasenia = ?";
            con = Conexion.conectar();
            ps = con.prepareStatement(qy);
            ps.setString(1, usuario.getNomnreUsuario());
            ps.setString(2, usuario.getContrasenia());
            rs = ps.executeQuery();
            if(rs.next()){
                lg.setId_usuario(rs.getString("id"));
                lg.setDireccion(rs.getString("direccion"));
                lg.setNomnreUsuario(rs.getString("nombreusuario"));
                lg.setTelefono(rs.getString("telefono"));
                lg.setPerfil(rs.getString("perfil"));
                lg.setId_biblioteca(rs.getString("id_biblioteca"));
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos", "Error de inicio de sesión", JOptionPane.ERROR_MESSAGE);            
        }
        return lg;
    }
    
    public String registrarUsuario(Usuario usuario,Biblioteca bli){
        try{
            con = Conexion.conectar();
            
            if(usuario.getApellidom().equals("") || usuario.getApellidop().equals("") || usuario.getContrasenia().equals("") || usuario.getDireccion().equals("") || usuario.getNomnreUsuario().equals("")){
                return "No se aceptan datos vacios";
            }
            ps = con.prepareStatement("SELECT COUNT(*) FROM usuario WHERE nombreusuario = ?");
            ps.setString(1,usuario.getNomnreUsuario());
            rs = ps.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) {
                return "Ya existe un registro con los mismos datos.";
            }
            
            ps = con.prepareStatement(
                "SELECT COUNT(*) FROM biblioteca b JOIN usuario u ON b.id = u.id_biblioteca WHERE b.nombre = ?"
            );
            ps.setString(1, bli.getNombre());
            rs = ps.executeQuery();

            boolean esPrimerUsuario = false;
            if (rs.next() && rs.getInt(1) == 0) {
                esPrimerUsuario = true;
            }
            
            int idBiblio = obtenerIdBiblioPorNombre(bli.getNombre());
            
            ps = con.prepareStatement(
                "INSERT INTO usuario (nombre, apellidop, apellidom, contrasenia, direccion, nombreusuario, telefono, prestamo, perfil, id_biblioteca) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"
            );
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getApellidop());
            ps.setString(3, usuario.getApellidom());
            ps.setString(4, usuario.getContrasenia());
            ps.setString(5, usuario.getDireccion());
            ps.setString(6, usuario.getNomnreUsuario());
            ps.setString(7, usuario.getTelefono());
            ps.setString(8, usuario.getPrestamo()); 
            ps.setString(9, esPrimerUsuario ? "admin" : "visitante");
            ps.setInt(10,idBiblio);
            ps.executeUpdate();

            return esPrimerUsuario 
                ? "Usuario registrado correctamente como administrador de la biblioteca." 
                : "Usuario registrado correctamente como visitante.";
        }catch(SQLException e){
            System.err.println("error "+e);
           return "error en el servidor"; 
        } finally {
            cerrarConexion();
        }
    }
    
    private int obtenerIdBiblioPorNombre(String nombreBiblio) throws SQLException {
        ps = con.prepareStatement("SELECT id FROM biblioteca WHERE nombre = ?");
        ps.setString(1, nombreBiblio);
        rs = ps.executeQuery();
        if (rs.next()) {
            return rs.getInt("id");
        }
        throw new SQLException("Usuario no encontrado.");
    }
    
    private void cerrarConexion() {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            System.err.println("Error al cerrar conexión: " + e);
        }
    }
    
    public void listarUsuarios(String idBiblioteca, DefaultTableModel modelo, JTable jtableUs){
        try {
            con = Conexion.conectar();
            String sqlUp = "SELECT id, nombre, perfil, apellidop, apellidom, direccion, telefono, nombreusuario FROM usuario WHERE id_biblioteca = ?";
            ps = con.prepareStatement(sqlUp);
            ps.setString(1, idBiblioteca);
            rs = ps.executeQuery();
            while(rs.next()){
                Object[] fila = new Object[8];
                fila[0] = rs.getString("id");
                fila[1] = rs.getString("nombreusuario");
                fila[2] = rs.getString("nombre");
                fila[3] = rs.getString("apellidop");
                fila[4] = rs.getString("apellidom");
                fila[5] = rs.getString("perfil");
                fila[6] = rs.getString("direccion");
                fila[7] = rs.getString("telefono");
                modelo.addRow(fila);
            }
            jtableUs.setModel(modelo);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public boolean actualizarUs(String idUsu, Usuario usuario, JTable jtableUs) {
        try {
            con = Conexion.conectar();
            String sqlUp = "UPDATE usuario SET nombre = ?, perfil = ?, apellidop = ?, apellidom = ?, direccion = ?, telefono = ?, nombreusuario = ? WHERE id = ?";
            ps = con.prepareStatement(sqlUp);
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getPerfil());
            ps.setString(3, usuario.getApellidop());
            ps.setString(4, usuario.getApellidom());
            ps.setString(5, usuario.getDireccion());
            ps.setString(6, usuario.getTelefono());
            ps.setString(7, usuario.getNomnreUsuario());
            ps.setString(8, usuario.getId());
            ps.executeUpdate();

            // Buscar la fila correspondiente en la tabla
            DefaultTableModel modelo = (DefaultTableModel) jtableUs.getModel();
            for (int i = 0; i < modelo.getRowCount(); i++) {
                if (modelo.getValueAt(i, 0).toString().equals(usuario.getId())) {
                    modelo.setValueAt(usuario.getId(), i, 0);
                    modelo.setValueAt(usuario.getNomnreUsuario(), i, 1);
                    modelo.setValueAt(usuario.getNombre(), i, 2);
                    modelo.setValueAt(usuario.getApellidop(), i, 3);
                    modelo.setValueAt(usuario.getApellidom(), i, 4);
                    modelo.setValueAt(usuario.getPerfil(), i, 5);
                    modelo.setValueAt(usuario.getDireccion(), i, 6);
                    modelo.setValueAt(usuario.getTelefono(), i, 7);
                    break;
                }
            }
            JOptionPane.showMessageDialog(null, "Usuario actualizado");

            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean eliminarUsu(String idUsu, JTable jtableUs) {
        try {
            con = Conexion.conectar();
            String sqlUp = "DELETE FROM usuario WHERE id = ?";
            ps = con.prepareStatement(sqlUp);
            ps.setString(1, idUsu);
            ps.executeUpdate();

            // Buscar y eliminar la fila correspondiente en la tabla
            DefaultTableModel modelo = (DefaultTableModel) jtableUs.getModel();
            for (int i = 0; i < modelo.getRowCount(); i++) {
                if (modelo.getValueAt(i, 0).toString().equals(idUsu)) {
                    modelo.removeRow(i);
                    break;
                }
            }
            JOptionPane.showMessageDialog(null, "Usuario eliminado");
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        } finally {
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

}
