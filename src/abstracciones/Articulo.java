/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package abstracciones;

import java.util.ArrayList;

/**
 *
 * @author alejandro ameneyro
 */
public class Articulo {
    private String id;
    private String tituloArt;
    private String autoresArt;
    private String fechaPublicacion;

    public Articulo() {
    }

    public Articulo(String id, String tituloArt, String autoresArt, String fechaPublicacion) {
        this.id = id;
        this.tituloArt = tituloArt;
        this.autoresArt = autoresArt;
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTituloArt() {
        return tituloArt;
    }

    public void setTituloArt(String tituloArt) {
        this.tituloArt = tituloArt;
    }

    public String getAutoresArt() {
        return autoresArt;
    }

    public void setAutoresArt(String autoresArt) {
        this.autoresArt = autoresArt;
    }

    public String getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(String fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }
    
    
}
