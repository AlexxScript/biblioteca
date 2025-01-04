/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.sql.Date;
import utils.Conexion;

/**
 *
 * @author alejandro ameneyro
 */
public class PrestamoDAO {
    
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public PrestamoDAO (){
    }
    
    public String registrarPrestamo(String idE, String idUs){
        LocalDate date = LocalDate.now();
        try {
            
            con = Conexion.conectar();
            String sqlSele = "SELECT id,estado FROM usuario WHERE nombreusuario = ?";
            String sqlActualizarInfraccion = "UPDATE usuario SET estado = 'noactivo' WHERE id = ?";
            String sqlS = "SELECT cantidadreal FROM ejemplar WHERE id = ?";
            String sqlPre = "INSERT INTO prestamos (usuario_id,ejemplar_id,fecha_prestamo,fecha_devolucion,estado) VALUES (?,?,?,?,?)"; 
            String sqlUp = "UPDATE ejemplar SET cantidadreal = cantidadreal - 1 WHERE id = ?";
            
            ps = con.prepareStatement(sqlSele);
            ps.setString(1, idUs);
            rs = ps.executeQuery();
            
            if(rs.next()){
                String idusu = rs.getString("id");
                if(!rs.getString("estado").equals("noactivo")){
                    ps = con.prepareStatement(sqlS);
                    ps.setString(1, idE);
                    rs = ps.executeQuery();
                    if(rs.next()){             
                        if(rs.getInt("cantidadreal")>0){
                           ps = con.prepareStatement(sqlPre);
                           ps.setString(1,idusu);
                           ps.setString(2, idE);
                           ps.setDate(3,Date.valueOf(date));
                           ps.setDate(4, Date.valueOf(date.plusDays(5)));
                           ps.setString(5, "prestado");
                           ps.executeUpdate();

                           ps = con.prepareStatement(sqlUp);
                           ps.setString(1, idE);
                           ps.executeUpdate();

                           ps = con.prepareStatement(sqlActualizarInfraccion);
                           ps.setString(1, idusu);
                           ps.executeUpdate();
                           return "Prestamo registrado";
                        }
                    }
                } else{
                   return "No puede pedir prestado aún";
                }
            }
            return "No se encontro un registro";
        } catch (Exception e) {
            System.out.println(e);
            return e.getMessage();

        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public void regresarPrestamo(String idE, String idPre,String idUs){
        try {
            con = Conexion.conectar();
            String sqlS = "UPDATE prestamos SET estado = 'devuelto' WHERE id = ? ";
            String sqlUp = "UPDATE ejemplar SET cantidadreal = cantidadreal + 1 WHERE id = ?";
            String sqlUs = "UPDATE usuario SET estado = 'activo WHERE id = ?";
            
            ps = con.prepareStatement(sqlS);
            ps.setString(1, idPre);
            ps.executeUpdate();
            
            ps = con.prepareStatement(sqlUp);
            ps.setString(1, idE);
            ps.executeUpdate();
            
            ps = con.prepareStatement(sqlUs);
            ps.setString(1, idUs);
            ps.executeUpdate();
            
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public String verificarEstado(String idUs) {
        LocalDate fechaActual = LocalDate.now();

        try {
            con = Conexion.conectar();
            String sqlFechaDevolucion = "SELECT fecha_devolucion FROM prestamos WHERE usuario_id = ?";
            ps = con.prepareStatement(sqlFechaDevolucion);
            ps.setString(1, idUs);
            rs = ps.executeQuery();

            if (rs.next()) {
                LocalDate fechaDevolucion = rs.getDate("fecha_devolucion").toLocalDate();

                if (fechaActual.isAfter(fechaDevolucion)) {
                    String sqlEstadoUsuario = "SELECT estado FROM usuario WHERE id = ?";
                    ps = con.prepareStatement(sqlEstadoUsuario);
                    ps.setString(1, idUs);
                    rs = ps.executeQuery();

                    if (rs.next()) {
                        String estadoActual = rs.getString("estado");

                        if (estadoActual.equals("activo") && 
                           (fechaActual.isAfter(fechaDevolucion) || fechaActual.isEqual(fechaDevolucion))) {
                            String sqlActualizarInfraccion = "UPDATE usuario SET estado = 'noactivo', infracciones = infracciones + 1 WHERE id = ?";
                            ps = con.prepareStatement(sqlActualizarInfraccion);
                            ps.setString(1, idUs);
                            ps.executeUpdate();
                            return "Tu cuenta estará bloqueada hasta el día "+fechaDevolucion.plusDays(3);
                        }

                        if (estadoActual.equals("noactivo") && 
                            (fechaActual.isBefore(fechaDevolucion.plusDays(3)) || fechaActual.isEqual(fechaDevolucion.plusDays(3)))) {
                            return "Tu cuenta estará bloqueada hasta el día "+fechaDevolucion.plusDays(3);

                        }

                        String sqlReactivarUsuario = "UPDATE usuario SET estado = 'activo' WHERE id = ?";
                        ps = con.prepareStatement(sqlReactivarUsuario);
                        ps.setString(1, idUs);
                        ps.executeUpdate();
                        return "pasar";
                    }
                } else {
                    return "pasar";
                }
            }

            return "pasar";

        } catch (Exception e) {
            e.printStackTrace();
            return "pasar";
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public void bloquear(String idUs){
        try {
            con = Conexion.conectar();
            String sqlUs = "SELECT infracciones FROM usuario WHERE id = ?";
            ps = con.prepareStatement(sqlUs);
            ps.setString(1, idUs);
            rs = ps.executeQuery();
            
            if(rs.next()){
                if(rs.getInt("infracciones")==5){
                    System.out.println("Cuanta inhabilitada");
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
