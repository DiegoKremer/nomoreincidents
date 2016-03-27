/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import javax.inject.Named;


/**
 *
 * @author Diego Kremer
 */
@Named(value = "gtecnicoMB")
@ManagedBean
@ApplicationScoped
public class grupotecnicoMB {
    
    private String nome;
    private String email;
    private String telefone;
    private usuarioMB[] membros;
    

    /**
     * Creates a new instance of grupotecnicoMB
     */
    public grupotecnicoMB() {
        
        
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public usuarioMB[] getMembros() {
        return membros;
    }

    public void setMembros(usuarioMB[] membros) {
        this.membros = membros;
    }
    
    
    public void cadastraGrupo() {
    
    }
    
    
}
