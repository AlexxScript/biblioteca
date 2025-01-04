/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package abstracciones;

/**
 *
 * @author alejandro ameneyro
 */
public class Login {
    private String direccion;
    private String telefono;
    private String nomnreUsuario;
    private String perfil;
    private String id_biblioteca;
    private String id_usuario;

    public Login() {
    }

    public Login(String direccion, String telefono, String nomnreUsuario, String perfil,String id_biblioteca,String id_usuario) {
        this.direccion = direccion;
        this.telefono = telefono;
        this.nomnreUsuario = nomnreUsuario;
        this.perfil = perfil;
        this.id_biblioteca = id_biblioteca;
        this.id_usuario = id_usuario;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNomnreUsuario() {
        return nomnreUsuario;
    }

    public void setNomnreUsuario(String nomnreUsuario) {
        this.nomnreUsuario = nomnreUsuario;
    }
    
    public void setPerfil(String perfil){
        this.perfil = perfil;
    }
    
    public String getPerfil(){
        return perfil;
    }
    
    public String getId_biblioteca() {
        return id_biblioteca;
    }

    public void setId_biblioteca(String id_biblioteca) {
        this.id_biblioteca = id_biblioteca;
    }
    
    public String getId_usuario(){
        return id_usuario;
    }
    
    public void setId_usuario(String id_usuario){
        this.id_usuario = id_usuario;
    }
}
