/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package abstracciones;

/**
 *
 * @author alejandro ameneyro
 */
public class Usuario {
    private String id;
    private String nombre;
    private String perfil;
    private String apellidop;
    private String apellidom;
    private String prestamo;
    private String direccion;
    private String telefono;
    private String nomnreUsuario;
    private String contrasenia;

    public Usuario() {
    }

    public Usuario(String id, String nombre, String perfil, String apellidop, String apellidom, String prestamo, String direccion, String telefono, String nomnreUsuario, String contrasenia) {
        this.id = id;
        this.nombre = nombre;
        this.perfil = perfil;
        this.apellidop = apellidop;
        this.apellidom = apellidom;
        this.prestamo = prestamo;
        this.direccion = direccion;
        this.telefono = telefono;
        this.nomnreUsuario = nomnreUsuario;
        this.contrasenia = contrasenia;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getApellidop() {
        return apellidop;
    }

    public void setApellidop(String apellidop) {
        this.apellidop = apellidop;
    }

    public String getApellidom() {
        return apellidom;
    }

    public void setApellidom(String apellidom) {
        this.apellidom = apellidom;
    }

    public String getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(String prestamo) {
        this.prestamo = prestamo;
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

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
}
