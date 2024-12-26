/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vistas;

import abstracciones.Biblioteca;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utils.Conexion;

/**
 *
 * @author alejandro ameneyro
 */
public class BibliotecaDAO {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    public String registrarBiblio(Biblioteca biblio){
        try{
            con = Conexion.conectar();
            
            if(biblio.getNombre().equals("")) return "Registro vacio";
            ps = con.prepareStatement("SELECT COUNT(*) FROM biblioteca WHERE nombre = ?");
            ps.setString(1, biblio.getNombre());
            rs = ps.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) {
                return "Ya existe un registro con el mismo nombre.";
            }
            ps = con.prepareStatement("INSERT INTO biblioteca (nombre) VALUES (?)");
            ps.setString(1,biblio.getNombre());
            ps.executeUpdate();
            return "El registro se creo correctamente, registra un usuario para crear el usuario root";
        }catch(SQLException e){
            System.err.println("error "+e);
           return "error en el servidor"; 
        } 
    }
}
