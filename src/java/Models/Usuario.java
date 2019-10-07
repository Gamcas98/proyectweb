/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author Gamcas
 */
public class Usuario {
    
    private int tipo;
    private String usuario;
    private String pass;


    public Usuario(){
        
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getTipo() {
        return tipo;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getPass() {
        return pass;
    }
    
    
    
}
