/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;
import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author alejandro ameneyro
 */
public class Conexion {
    public static Connection conectar() {
        Connection conexion = null;
        String url = "jdbc:mysql://localhost:3306/biblioteca";
        String usuario = "root";
        String contraseña = "password";
        try {
            conexion = DriverManager.getConnection(url, usuario, contraseña);
            System.out.println("Conexión exitosa a la base de datos.");
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        return conexion;
    }
}
