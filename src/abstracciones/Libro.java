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
    private ArrayList<Indice> indice;
    private String tipoLibro;
    private String libroid;

    public Libro(String id, ArrayList<String> autores, String fechaLanz, String idioma, int cantidad, int ubicacion_id, String titulo, String editorial, String pasta, String volumen, ArrayList<Indice> indice, String tipoLibro, String libroid) {
        super(id, autores, fechaLanz, idioma, cantidad, ubicacion_id);
        this.titulo = titulo;
        this.editorial = editorial;
        this.pasta = pasta;
        this.volumen = volumen;
        this.indice = indice;
        this.tipoLibro = tipoLibro;
        this.libroid = libroid;
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

    public ArrayList<Indice> getIndice() {
        return indice;
    }

    public void setIndice(ArrayList<Indice> indice) {
        this.indice = indice;
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
