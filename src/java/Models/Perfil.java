/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.InputStream;



/**
 *
 * @author Gamcas
 */
public class Perfil {
    
    private String nombre;
    private String apellido;
    private String gustos;
    private String hobbies;
    private String descripcion;
    private String usuario;
    private InputStream foto;

    public InputStream getFoto() {
        return foto;
    }

    public void setFoto(InputStream foto) {
        this.foto = foto;
    }
    

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getUsuario() {
        return usuario;
    }

    
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getGustos() {
        return gustos;
    }

    public String getHobbies() {
        return hobbies;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setGustos(String gustos) {
        this.gustos = gustos;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
    
    
}
