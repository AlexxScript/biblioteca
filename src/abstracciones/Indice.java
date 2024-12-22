/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package abstracciones;

/**
 *
 * @author alexamn
 */
public class Indice {
    private String tema;
    private String pagina;

    public Indice(String tema, String pagina) {
        this.tema = tema;
        this.pagina = pagina;
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
    
    @Override
    public String toString() {
        return "Indice{" + "tema=" + tema + ", pagina=" + pagina + '}';
    }
}
