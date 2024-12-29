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
public class Revista extends Ejemplar {
    private String nombre;
    private String distribuidor;
    private String empresa;
    private String tipoRevista;
    private String tema;
    private String pagina;

    public Revista(String id, String autores, String fechaLanz, String idioma, int cantidad, int cantidadReal, int ubicacion_id, int biblioteca_id) {
        super(id, autores, fechaLanz, idioma, cantidad, cantidadReal, ubicacion_id, biblioteca_id);
    }

    public Revista() {
    }

    public Revista(String nombre, String distribuidor, String empresa, String tipoRevista, String tema, String pagina) {
        this.nombre = nombre;
        this.distribuidor = distribuidor;
        this.empresa = empresa;
        this.tipoRevista = tipoRevista;
        this.tema = tema;
        this.pagina = pagina;
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

    public String getTipoRevista() {
        return tipoRevista;
    }

    public void setTipoRevista(String tipoRevista) {
        this.tipoRevista = tipoRevista;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getPagina() {
        return pagina;
    }

    public void setPagina(String pagina) {
        this.pagina = pagina;
    }
}
