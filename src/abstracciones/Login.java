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

    public Login() {
    }

    public Login(String direccion, String telefono, String nomnreUsuario, String perfil) {
        this.direccion = direccion;
        this.telefono = telefono;
        this.nomnreUsuario = nomnreUsuario;
        this.perfil = perfil;
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
}
