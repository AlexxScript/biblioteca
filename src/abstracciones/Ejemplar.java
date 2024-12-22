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
    private ArrayList<String> autores;
    private String fechaLanz;
    private String idioma;
    private int cantidad;
    private int ubicacion_id;

    public Ejemplar(String id, ArrayList<String> autores, String fechaLanz, String idioma, int cantidad, int ubicacion_id) {
        this.id = id;
        this.autores = autores;
        this.fechaLanz = fechaLanz;
        this.idioma = idioma;
        this.cantidad = cantidad;
        this.ubicacion_id = ubicacion_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<String> getAutores() {
        return autores;
    }

    public void setAutores(ArrayList<String> autores) {
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
}
