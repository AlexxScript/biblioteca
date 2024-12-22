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
public class Biblioteca {
    private String nombre;
    private ArrayList<Usuario> usuarios;
    private ArrayList<Periodico> periodicos;
    private ArrayList<Revista> revistas;
    private ArrayList<VideoCientifico> videos;
    private ArrayList<Libro> libros;
    private ArrayList<ArticuloCientifico> articulosCientificos;

    public Biblioteca(String nombre, ArrayList<Usuario> usuarios, ArrayList<Periodico> periodicos, ArrayList<Revista> revistas, ArrayList<VideoCientifico> videos, ArrayList<Libro> libros, ArrayList<ArticuloCientifico> articulosCientificos) {
        this.nombre = nombre;
        this.usuarios = usuarios;
        this.periodicos = periodicos;
        this.revistas = revistas;
        this.videos = videos;
        this.libros = libros;
        this.articulosCientificos = articulosCientificos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public ArrayList<Periodico> getPeriodicos() {
        return periodicos;
    }

    public void setPeriodicos(ArrayList<Periodico> periodicos) {
        this.periodicos = periodicos;
    }

    public ArrayList<Revista> getRevistas() {
        return revistas;
    }

    public void setRevistas(ArrayList<Revista> revistas) {
        this.revistas = revistas;
    }

    public ArrayList<VideoCientifico> getVideos() {
        return videos;
    }

    public void setVideos(ArrayList<VideoCientifico> videos) {
        this.videos = videos;
    }

    public ArrayList<Libro> getLibros() {
        return libros;
    }

    public void setLibros(ArrayList<Libro> libros) {
        this.libros = libros;
    }

    public ArrayList<ArticuloCientifico> getArticulosCientificos() {
        return articulosCientificos;
    }

    public void setArticulosCientificos(ArrayList<ArticuloCientifico> articulosCientificos) {
        this.articulosCientificos = articulosCientificos;
    }
}
