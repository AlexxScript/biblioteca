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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
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
    
    public void listarPrestamos(String idBiblio,DefaultTableModel modelo){
        try {
            String query = "SELECT " +
                   "usuario.nombreusuario AS nombreusuario, " +
                   "prestamos.fecha_prestamo AS fechaPrestamo, " +
                   "prestamos.fecha_devolucion AS fechaEntrega, " +
                   "prestamos.estado AS estadoEntrega, " +
                   "usuario.estado AS EstadoUsuario, " +
                   "prestamos.id AS idP, " +
                   "ejemplar.id AS idE, " +
                   "usuario.id AS idUs " +
                   "FROM prestamos " +
                   "JOIN usuario ON prestamos.usuario_id = usuario.id " +
                   "JOIN ejemplar ON prestamos.ejemplar_id = ejemplar.id " +
                   "WHERE (prestamos.estado = 'prestado' OR prestamos.estado = 'vencido') AND ejemplar.id_biblioteca = ?";
            con = Conexion.conectar();
            
            ps = con.prepareStatement(query);
            ps.setString(1, idBiblio);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                Object[] fila = new Object[8];
                fila[0] = rs.getString("nombreusuario");
                fila[1] = rs.getDate("fechaPrestamo");
                fila[2] = rs.getDate("fechaEntrega");
                fila[3] = rs.getString("estadoEntrega");
                fila[4] = rs.getString("EstadoUsuario");
                fila[5] = rs.getInt("idP");
                fila[6] = rs.getInt("idE");
                fila[7] = rs.getInt("idUs");
                modelo.addRow(fila);
            }
            rs.close();
            ps.close();
            con.close();
           
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
    
    public Object[] registrarPrestamo(String idE, String idUs) {
        LocalDate date = LocalDate.now();
        try {
            con = Conexion.conectar();
            String sqlSele = "SELECT id,estado,nombreusuario FROM usuario WHERE nombreusuario = ?";
            String sqlS = "SELECT cantidadreal FROM ejemplar WHERE id = ?";
            String sqlPre = "INSERT INTO prestamos (usuario_id,ejemplar_id,fecha_prestamo,fecha_devolucion,estado) VALUES (?,?,?,?,?)"; 
            String sqlUp = "UPDATE ejemplar SET cantidadreal = cantidadreal - 1 WHERE id = ?";

            ps = con.prepareStatement(sqlSele);
            ps.setString(1, idUs);
            rs = ps.executeQuery();

            if (rs.next()) {
                String idusu = rs.getString("id");
                String estadoUsuario = rs.getString("estado");
                String nombreUsuario = rs.getString("nombreusuario");

                if (!estadoUsuario.equals("noactivo")) {
                    ps = con.prepareStatement(sqlS);
                    ps.setString(1, idE);
                    rs = ps.executeQuery();
                    if (rs.next()) {
                        int cr = rs.getInt("cantidadreal");
                        if (cr > 0) {
                            ps = con.prepareStatement(sqlPre, PreparedStatement.RETURN_GENERATED_KEYS);
                            ps.setString(1, idusu);
                            ps.setString(2, idE);
                            ps.setDate(3, Date.valueOf(date));
                            ps.setDate(4, Date.valueOf(date.plusDays(5)));
                            ps.setString(5, "prestado");
                            ps.executeUpdate();

                            ResultSet rsGeneratedKeys = ps.getGeneratedKeys();
                            if (rsGeneratedKeys.next()) {
                                int idPrestamo = rsGeneratedKeys.getInt(1);

                                ps = con.prepareStatement(sqlUp);
                                ps.setString(1, idE);
                                ps.executeUpdate();

                                return new Object[] {
                                    nombreUsuario,
                                    date,
                                    date.plusDays(5),
                                    "prestado",
                                    estadoUsuario,
                                    idPrestamo,
                                    idE,
                                    idusu,
                                    cr-1
                                };
                            }
                        }
                    }
                } else {
                    return null; 
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
        return null; 
    }

    
    public int regresarPrestamo(String idE, String idPre, String idUs, JTable jTable) {
        try {
            con = Conexion.conectar();

            String sqlS = "UPDATE prestamos SET estado = 'devuelto' WHERE id = ?";
            ps = con.prepareStatement(sqlS);
            ps.setString(1, idPre);
            ps.executeUpdate();

            String sqlUp = "UPDATE ejemplar SET cantidadreal = cantidadreal + 1 WHERE id = ?";
            ps = con.prepareStatement(sqlUp);
            ps.setString(1, idE);
            ps.executeUpdate();
            
            String sqlQ = "SELECT cantidadreal FROM ejemplar WHERE id = ?";
            ps = con.prepareStatement(sqlQ);
            ps.setString(1, idE);
            rs = ps.executeQuery();
               
            if(rs.next()){
                int cr = rs.getInt("cantidadreal");

                String sqlUs = "UPDATE usuario SET estado = 'activo' WHERE id = ?";
                ps = con.prepareStatement(sqlUs);
                ps.setString(1, idUs);
                ps.executeUpdate();

                DefaultTableModel modelo = (DefaultTableModel) jTable.getModel();
                for (int i = 0; i < modelo.getRowCount(); i++) {
                    if (modelo.getValueAt(i, 5).toString().equals(idPre)) { 
                        modelo.removeRow(i); 
                        break;
                    }
                }
                return cr;
            }
            
            return -1;
        } catch (Exception e) {
            System.out.println(e);
            return -1;
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
            String sqlFechaDevolucion = "SELECT id,fecha_devolucion FROM prestamos WHERE usuario_id = ? AND (estado = 'prestado' OR estado = 'vencido') ORDER BY id DESC LIMIT 1";
            ps = con.prepareStatement(sqlFechaDevolucion);
            ps.setString(1, idUs);
            rs = ps.executeQuery();

            if (rs.next()) {
                int idPrestamo = rs.getInt("id");
                LocalDate fechaDevolucion = rs.getDate("fecha_devolucion").toLocalDate();

                if (fechaActual.isAfter(fechaDevolucion)) {
                    String sqlEstadoUsuario = "SELECT estado FROM usuario WHERE id = ?";
                    ps = con.prepareStatement(sqlEstadoUsuario);
                    ps.setString(1, idUs);
                    rs = ps.executeQuery();

                    if (rs.next()) {
                        String estadoActual = rs.getString("estado");
                        
                        String sqlUsb = "SELECT infracciones FROM usuario WHERE id = ?";
                        ps = con.prepareStatement(sqlUsb);
                        ps.setString(1, idUs);
                        rs = ps.executeQuery();

                        if (rs.next() && rs.getInt("infracciones") >= 5) {
                            return "Cuenta bloqueada";
                        }

                        if (estadoActual.equals("activo") && 
                           (fechaActual.isAfter(fechaDevolucion) || fechaActual.isEqual(fechaDevolucion))) {
                            String sqlActualizarInfraccion = "UPDATE usuario SET estado = 'noactivo', infracciones = infracciones + 1 WHERE id = ?";
                            ps = con.prepareStatement(sqlActualizarInfraccion);
                            ps.setString(1, idUs);
                            ps.executeUpdate();
                            
                            String sqlS = "UPDATE prestamos SET estado = 'vencido' WHERE id = ?";
                            ps = con.prepareStatement(sqlS);
                            ps.setInt(1, idPrestamo);
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
                    String sqlUsb = "SELECT infracciones FROM usuario WHERE id = ?";
                    ps = con.prepareStatement(sqlUsb);
                    ps.setString(1, idUs);
                    rs = ps.executeQuery();

                    if (rs.next() && rs.getInt("infracciones") >= 5) {
                        return "Cuenta bloqueada";
                    }
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
            String sqlUsb = "SELECT infracciones FROM usuario WHERE id = ?";
            ps = con.prepareStatement(sqlUsb);
            ps.setString(1, idUs);
            rs = ps.executeQuery();
            
            if(rs.next()){
                if(rs.getInt("infracciones")==5){
                    System.out.println("Cuanta bloqueada");
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
