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
public class Ejemplar {
    private String id;
    private String autores;
    private String fechaLanz;
    private String idioma;
    private int cantidad;
    private int cantidadReal;
    private int ubicacion_id;
    private int biblioteca_id;

    public Ejemplar() {
    }

    public Ejemplar(String id, String autores, String fechaLanz, String idioma, int cantidad, int cantidadReal, int ubicacion_id, int biblioteca_id) {
        this.id = id;
        this.autores = autores;
        this.fechaLanz = fechaLanz;
        this.idioma = idioma;
        this.cantidad = cantidad;
        this.ubicacion_id = ubicacion_id;
        this.biblioteca_id = biblioteca_id;
        this.cantidadReal = cantidadReal;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAutores() {
        return autores;
    }

    public void setAutores(String autores) {
        this.autores = autores;
    }

    public String getFechaLanz() {
        return fechaLanz;
    }

    public void setFechaLanz(String fechaLanz) {
        this.fechaLanz = fechaLanz;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getUbicacion_id() {
        return ubicacion_id;
    }

    public void setUbicacion_id(int ubicacion_id) {
        this.ubicacion_id = ubicacion_id;
    }

    public int getBiblioteca_id() {
        return biblioteca_id;
    }

    public void setBiblioteca_id(int biblioteca_id) {
        this.biblioteca_id = biblioteca_id;
    }
    
    public int getCantidadReal() {
        return cantidadReal;
    }

    public void setCantidadReal(int cantidadReal) {
        this.cantidadReal = cantidadReal;
    }
    
}
