package interfaces;

import abstracciones.Ubicacion;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

/**
 *
 * @author alejandro ameneyro
 */
public interface ControllerDao <T>{
    Object[] registrarProducto(Ubicacion ubi, T producto, String idP);
    boolean actualizarProducto(Ubicacion ubi, T producto, String idP, JTable tblProductos, JTable tblProductos1);
    boolean eliminarProducto(String productoId, JTable tblProductos, JTable tblProductos1);
}
