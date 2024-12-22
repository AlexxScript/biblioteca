/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package abstracciones;

import java.util.ArrayList;

/**
 *
 * @author alexamn
 */
public class Periodico extends Ejemplar {

    private ArrayList<Articulo> articulos;
    private String nombre;
    private String distribuidor;
    private String empresa;
    private String tiporevista;

    public Periodico(ArrayList<Articulo> articulos, String nombre, String distribuidor, String empresa, String tiporevista, String id, ArrayList<String> autores, String fechaLanz, String idioma, int cantidad, int ubicacion_id) {
        super(id, autores, fechaLanz, idioma, cantidad, ubicacion_id);
        this.articulos = articulos;
        this.nombre = nombre;
        this.distribuidor = distribuidor;
        this.empresa = empresa;
        this.tiporevista = tiporevista;
    }

    public ArrayList<Articulo> getArticulos() {
        return articulos;
    }

    public void setArticulos(ArrayList<Articulo> articulos) {
        this.articulos = articulos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDistribuidor() {
        return distribuidor;
    }

    public void setDistribuidor(String distribuidor) {
        this.distribuidor = distribuidor;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getTiporevista() {
        return tiporevista;
    }

    public void setTiporevista(String tiporevista) {
        this.tiporevista = tiporevista;
    }
    
}
