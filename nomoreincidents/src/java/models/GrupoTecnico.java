/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import ManagedBeans.UsuarioMB;

/**
 *
 * @author marce
 */
public class GrupoTecnico {
    private String nome;
    private String email;
    private String telefone;
    private UsuarioMB[] membros;

    public GrupoTecnico(String nome, String email, String telefone, UsuarioMB[] membros) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.membros = membros;
    }

    public GrupoTecnico(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }
    
    

    public GrupoTecnico() {
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

    public UsuarioMB[] getMembros() {
        return membros;
    }

    public void setMembros(UsuarioMB[] membros) {
        this.membros = membros;
    }
    
    
}
