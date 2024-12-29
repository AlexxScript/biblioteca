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
public class ArticuloCientifico extends Ejemplar{
    private String areaespecialidad;
    private String fechaescr;
    private String insitutoProvinencia;
    private String articulocientifico_id;

    public ArticuloCientifico(String areaespecialidad, String fechaescr, String insitutoProvinencia, String articulocientifico_id) {
        this.areaespecialidad = areaespecialidad;
        this.fechaescr = fechaescr;
        this.insitutoProvinencia = insitutoProvinencia;
        this.articulocientifico_id = articulocientifico_id;
    }

    public ArticuloCientifico(String areaespecialidad, String fechaescr, String insitutoProvinencia, String articulocientifico_id, String id, String autores, String fechaLanz, String idioma, int cantidad, int cantidadReal, int ubicacion_id, int biblioteca_id) {
        super(id, autores, fechaLanz, idioma, cantidad, cantidadReal, ubicacion_id, biblioteca_id);
        this.areaespecialidad = areaespecialidad;
        this.fechaescr = fechaescr;
        this.insitutoProvinencia = insitutoProvinencia;
        this.articulocientifico_id = articulocientifico_id;
    }

    public ArticuloCientifico() {
    }
    
    public String getAreaespecialidad() {
        return areaespecialidad;
    }

    public void setAreaespecialidad(String areaespecialidad) {
        this.areaespecialidad = areaespecialidad;
    }

    public String getFechaescr() {
        return fechaescr;
    }

    public void setFechaescr(String fechaescr) {
        this.fechaescr = fechaescr;
    }

    public String getInsitutoProvinencia() {
        return insitutoProvinencia;
    }

    public void setInsitutoProvinencia(String insitutoProvinencia) {
        this.insitutoProvinencia = insitutoProvinencia;
    }

    public String getArticulocientifico_id() {
        return articulocientifico_id;
    }

    public void setArticulocientifico_id(String articulocientifico_id) {
        this.articulocientifico_id = articulocientifico_id;
    }
}
