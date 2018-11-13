/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgs.Servlets.controller;

/**
 *
 * @author gick2
 */
public class Usuarios {    
    private String usuario=null;
    private String senha=null;
    private int nivel;
    private String nomeCompleto=null;

    public boolean verificaUsuario() {
        if (this.usuario != null && this.senha != null) {
            if (this.usuario.equals("aaa") && this.senha.equals("1234"))
		return true;
	}
	return false;

    }
    public String getUsuario() {
            return usuario;
    } 
    
    public void setUsuario (String usuario) {
        this.usuario = usuario;
    }
    
    public String getSenha() {
            return senha;
    }     
   
    public void setSenha (String senha) {
        this.senha = senha;
    }
    
    public int getNivel() {
            return nivel;
    }     
   
    public void setNivel (int nivel) {
        this.nivel = nivel;
    }

    
    public String getNomeCompleto() {
            return nomeCompleto;
    }     
   
    public void setNomeCompleto (String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

}


