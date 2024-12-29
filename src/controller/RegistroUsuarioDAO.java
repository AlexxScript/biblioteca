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
            String qy = "SELECT direccion, telefono, nombreusuario, perfil,id_biblioteca FROM usuario WHERE nombreusuario = ? AND contrasenia = ?";
            con = Conexion.conectar();
            ps = con.prepareStatement(qy);
            ps.setString(1, usuario.getNomnreUsuario());
            ps.setString(2, usuario.getContrasenia());
            rs = ps.executeQuery();
            if(rs.next()){
                lg.setDireccion(rs.getString("direccion"));
                lg.setNomnreUsuario(rs.getString("nombreusuario"));
                lg.setTelefono(rs.getString("telefono"));
                lg.setPerfil(rs.getString("perfil"));
                lg.setId_biblioteca(rs.getString("id_biblioteca"));
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return lg;
    }
    
    public String registrarUsuario(Usuario usuario,Biblioteca bli){
        try{
            con = Conexion.conectar();
            
            if(usuario.getApellidom().equals("") || usuario.getApellidop().equals("") || usuario.getContrasenia().equals("") || usuario.getDireccion().equals("") || usuario.getNomnreUsuario().equals("")){
                return "No se aceptan datos vacios";
            }
            ps = con.prepareStatement("SELECT COUNT(*) FROM usuario WHERE nombre = ? or nombreusuario = ?");
            ps.setString(1,usuario.getNombre());
            ps.setString(2,usuario.getNomnreUsuario());
            System.out.println(usuario.getNombre());
            System.out.println(usuario.getNomnreUsuario());
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
}
