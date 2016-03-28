/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ManagedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import models.GrupoTecnico;


/**
 *
 * @author Diego Kremer
 */
@Named(value = "gtecnicoMB")
@ApplicationScoped

public class GrupotecnicoMB implements Serializable {
    
    private GrupoTecnico novoGrupo = new GrupoTecnico();    
    private ArrayList<GrupoTecnico> grupoTecnicoDB = new ArrayList<> ();
    private String nome;
    private String email;
    private String telefone;
    //private UsuarioMB[] membros;
    /**
     * Creates a new instance of grupotecnicoMB
     */
    public GrupotecnicoMB() {
       
      
        
    }

    public void reset(){
        novoGrupo.setNome("");
        novoGrupo.setEmail("");
        novoGrupo.setTelefone("");
    } 
    
    public void cadastraGrupo() {
        novoGrupo.setNome(nome);
        novoGrupo.setEmail(email);
        novoGrupo.setTelefone(telefone);
        grupoTecnicoDB.add(novoGrupo);
        novoGrupo = new GrupoTecnico();
        
        
        
        
        FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage mensagem = new FacesMessage(
                    FacesMessage.SEVERITY_INFO, 
                    "Grupo Técnico cadastrado com sucesso",
                    "O cadastro do grupo técnico foi realizado com sucesso.");
            contexto.addMessage(null, mensagem);
            System.out.println("Grupo Técnico cadastrado");
        
    }

    public ArrayList<GrupoTecnico> getGrupoTecnicoDB() {
        return grupoTecnicoDB;
    }

    public void setGrupoTecnicoDB(ArrayList<GrupoTecnico> grupoTecnicoDB) {
        this.grupoTecnicoDB = grupoTecnicoDB;
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

    

    
    
    
}