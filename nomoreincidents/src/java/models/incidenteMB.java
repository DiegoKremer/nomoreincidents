/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

import java.util.ArrayList;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Diego Kremer
 */
@Named(value = "incidenteMB")
@ManagedBean
@ApplicationScoped
public class IncidenteMB {
    
    private int numero;
    private String numeroRef;
    private String localidade;
    private UsuarioMB usuario;
    private String pesquisaUsuario;
    private Date data;
    private String descricao;
    
    
    ArrayList<IncidenteMB> incidenteDB = new ArrayList();
    
    // Construtores
    
    public IncidenteMB() {
        
    }
    
    
    // Metodos
    
    public void registraIncidente() {
        
        IncidenteMB novoIncidente = new IncidenteMB();
        
        novoIncidente.setNumero(geraNumeroIncidente());
        novoIncidente.setNumeroRef(numeroRef);
        novoIncidente.setLocalidade(localidade);
        novoIncidente.setUsuario(usuario);
        novoIncidente.setData(data);
        novoIncidente.setDescricao(descricao);
        
        numero = geraNumeroIncidente();
        numeroRef = "";
        localidade = "";
        usuario = null;
        data = null;
        descricao = "";
        
        
        FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage mensagem = new FacesMessage(
                    FacesMessage.SEVERITY_INFO, 
                    "Incidente registrado",
                    "O incidente foi registrado com sucesso.");
            contexto.addMessage(null, mensagem);
            System.out.println("Incidente registrado");
    
    }
    
    public int geraNumeroIncidente() {
        if (incidenteDB.isEmpty()) {
            return numero = 1;
        } else {
        numero = incidenteDB.get(incidenteDB.size()).getNumero() + 1;
        return numero;
        }
    }
    
    
    public UsuarioMB pesquisaUsuario() {
        UsuarioMB usuarioPesquisado = new UsuarioMB ();
        for (int i = 0; i < usuarioPesquisado.getUsuariosDB().size(); i++) {
            if (usuarioPesquisado.getUsuariosDB().get(i).getNome().equals(pesquisaUsuario)) {
                return usuarioPesquisado.getUsuariosDB().get(i);
            }
            
        }
        
        FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage mensagem = new FacesMessage(
                    FacesMessage.SEVERITY_FATAL, 
                    "Usuário não encontrado",
                    "O usuário pesquisado não foi encontrado.");
            contexto.addMessage(null, mensagem);
            System.out.println("Usuário não encontrado.");
        
        return null;
    }
    
    
    // Gets e Setters
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNumeroRef() {
        return numeroRef;
    }

    public void setNumeroRef(String numeroRef) {
        this.numeroRef = numeroRef;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public UsuarioMB getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioMB usuario) {
        this.usuario = usuario;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPesquisaUsuario() {
        return pesquisaUsuario;
    }

    public void setPesquisaUsuario(String pesquisaUsuario) {
        this.pesquisaUsuario = pesquisaUsuario;
    }

    
    
    
    
}
