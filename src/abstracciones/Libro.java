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
public class Libro extends Ejemplar{
    private String titulo;
    private String editorial;
    private String pasta;
    private String volumen;
    private String tipoLibro;
    private String libroid;

    public Libro(String titulo, String editorial, String pasta, String volumen, String tipoLibro, String libroid, String id, String autores, String fechaLanz, String idioma, int cantidad, int cantidadReal, int ubicacion_id, int biblioteca_id) {
        super(id, autores, fechaLanz, idioma, cantidad, cantidadReal, ubicacion_id, biblioteca_id);
        this.titulo = titulo;
        this.editorial = editorial;
        this.pasta = pasta;
        this.volumen = volumen;
        this.tipoLibro = tipoLibro;
        this.libroid = libroid;
    }

    public Libro() {
        
    }
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getPasta() {
        return pasta;
    }

    public void setPasta(String pasta) {
        this.pasta = pasta;
    }

    public String getVolumen() {
        return volumen;
    }

    public void setVolumen(String volumen) {
        this.volumen = volumen;
    }

    public String getTipoLibro() {
        return tipoLibro;
    }

    public void setTipoLibro(String tipoLibro) {
        this.tipoLibro = tipoLibro;
    }

    public String getLibroid() {
        return libroid;
    }

    public void setLibroid(String libroid) {
        this.libroid = libroid;
    }
    
}
