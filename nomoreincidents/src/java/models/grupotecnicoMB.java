/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;


/**
 *
 * @author Diego Kremer
 */
@Named(value = "gtecnicoMB")
@ManagedBean
@ApplicationScoped
public class GrupotecnicoMB implements Serializable {
    
    private String nome;
    private String email;
    private String telefone;
    private UsuarioMB[] membros;
    
    ArrayList<GrupotecnicoMB> grupoTecnicoDB = new ArrayList<GrupotecnicoMB> ();
    /**
     * Creates a new instance of grupotecnicoMB
     */
    public GrupotecnicoMB() {
        
        
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
    
    
    public void cadastraGrupo() {
    
        GrupotecnicoMB novoGrupo = new GrupotecnicoMB();
        
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
