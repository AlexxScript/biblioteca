/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package abstracciones;

/**
 *
 * @author alejandro ameneyro
 */
public class VideoCientifico extends Ejemplar{

    private String idVideo;
    private String nombre;
    private String duracion;

    public VideoCientifico() {
    }

    public VideoCientifico(String id, String autores, String fechaLanz, String idioma, int cantidad, int cantidadReal, int ubicacion_id, int biblioteca_id) {
        super(id, autores, fechaLanz, idioma, cantidad, cantidadReal, ubicacion_id, biblioteca_id);
    }

    public VideoCientifico(String idVideo, String nombre, String duracion) {
        this.idVideo = idVideo;
        this.nombre = nombre;
        this.duracion = duracion;
    }
    
    public String getIdVideo() {
        return idVideo;
    }

    public void setIdVideo(String idVideo) {
        this.idVideo = idVideo;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }
}
