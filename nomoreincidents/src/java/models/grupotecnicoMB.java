/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;


/**
 *
 * @author Diego Kremer
 */
@Named(value = "gtecnicoMB")
@ApplicationScoped

public class grupotecnicoMB {
    
    private String nome;
    private String email;
    private String telefone;
    private usuarioMB[] membros;
    
    ArrayList<grupotecnicoMB> grupoTecnicoDB = new ArrayList<grupotecnicoMB> ();
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
    
        grupotecnicoMB novoGrupo = new grupotecnicoMB();
        
        novoGrupo.setNome(nome);
        novoGrupo.setEmail(email);
        novoGrupo.setTelefone(telefone);
        novoGrupo.setMembros(membros);
        
        grupoTecnicoDB.add(novoGrupo);
        
        nome = "";
        email = "";
        telefone = "";
        membros = null;
        
        FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage mensagem = new FacesMessage(
                    FacesMessage.SEVERITY_INFO, 
                    "Grupo Técnico cadastrado com sucesso",
                    "O cadastro do grupo técnico foi realizado com sucesso.");
            contexto.addMessage(null, mensagem);
            System.out.println("Grupo Técnico cadastrado");
        
    }
    
    
}
