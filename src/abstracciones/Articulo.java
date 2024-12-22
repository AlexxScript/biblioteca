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
    private ArrayList<String> autoresArt;
    private String fechaPublicacion;
    private String tipoArticulo;
    private String fotografo;
    private String seccion;

    public Articulo(String id, String tituloArt, ArrayList<String> autoresArt, String fechaPublicacion, String tipoArticulo, String fotografo, String seccion) {
        this.id = id;
        this.tituloArt = tituloArt;
        this.autoresArt = autoresArt;
        this.fechaPublicacion = fechaPublicacion;
        this.tipoArticulo = tipoArticulo;
        this.fotografo = fotografo;
        this.seccion = seccion;
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

    public ArrayList<String> getAutoresArt() {
        return autoresArt;
    }

    public void setAutoresArt(ArrayList<String> autoresArt) {
        this.autoresArt = autoresArt;
    }

    public String getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(String fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getTipoArticulo() {
        return tipoArticulo;
    }

    public void setTipoArticulo(String tipoArticulo) {
        this.tipoArticulo = tipoArticulo;
    }

    public String getFotografo() {
        return fotografo;
    }

    public void setFotografo(String fotografo) {
        this.fotografo = fotografo;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }
}
