/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ManagedBeans;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import models.Incidente;
import models.Usuario;

/**
 *
 * @author Diego Kremer
 */
@Named(value = "incidenteMB")
@ApplicationScoped
public class IncidenteMB implements Serializable {
    
    private Incidente novoIncidente; 
    private Usuario usuarioSelecionado;
    
    private List<Incidente> incidenteDB;
    
    // Construtores
    
    public IncidenteMB() {
        novoIncidente = new Incidente();
        incidenteDB = new ArrayList<>();
    }
    
    
   // Metodos
    
    public String dataAtual () {
        SimpleDateFormat ft = new SimpleDateFormat ("dd/MM/yyyy");
        Date dataAtual = new Date();
        return ft.format(dataAtual);
    }
    
    public String registraIncidente() {
        
        incidenteDB.add(novoIncidente);
        this.novoIncidente = new Incidente();
        
        
        FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage mensagem = new FacesMessage(
                    FacesMessage.SEVERITY_INFO, 
                    "Incidente registrado",
                    "O incidente foi registrado com sucesso.");
            contexto.addMessage(null, mensagem);
            System.out.println("Incidente registrado");
        
            return "incidentes?faces-redirect=true"; 
    }
    
    public int geraNumeroIncidente() {
        int numero = 0;
        int dbSize = incidenteDB.size();
        if (incidenteDB.isEmpty()) {
            return numero = 1;
        } else {
        numero = dbSize + 1;
        return numero;
        }
    }
    
    
//    public Usuario pesquisaUsuario() {
//        UsuarioMB usuarioPesquisado = new UsuarioMB ();
//        for (int i = 0; i < usuarioPesquisado.getUsuariosDB().size(); i++) {
//            if (usuarioPesquisado.getUsuariosDB().get(i).getNome().equals(pesquisaUsuario)) {
//                return usuarioPesquisado.getUsuariosDB().get(i);
//            }
//            
//        }
//        
//        FacesContext contexto = FacesContext.getCurrentInstance();
//            FacesMessage mensagem = new FacesMessage(
//                    FacesMessage.SEVERITY_FATAL, 
//                    "Usuário não encontrado",
//                    "O usuário pesquisado não foi encontrado.");
//            contexto.addMessage(null, mensagem);
//            System.out.println("Usuário não encontrado.");
//        
//        return null;
//    }
    
    
    // Gets e Setters

    public Incidente getNovoIncidente() {
        return novoIncidente;
    }

    public void setNovoIncidente(Incidente novoIncidente) {
        this.novoIncidente = novoIncidente;
    }

    public Usuario getUsuarioSelecionado() {
        return usuarioSelecionado;
    }

    public void setUsuarioSelecionado(Usuario usuarioSelecionado) {
        this.usuarioSelecionado = usuarioSelecionado;
    }
    
    

    public List<Incidente> getIncidenteDB() {
        return incidenteDB;
    }

    public void setIncidenteDB(List<Incidente> incidenteDB) {
        this.incidenteDB = incidenteDB;
    }
    //--------------------------------------------------------------------------
    public String removerIncidente(Incidente novoIncidente){
        incidenteDB.remove(novoIncidente);
        return "incidentes?faces-redirect=true";
    }
    public String editarIncidente(Incidente u){
        novoIncidente = u;
        return("/editarIncidente?faces-redirect=true");
    }
    public String atualizarIncidente()
    {
        return("/incidentes?faces-redirect=true");
    }
   

    
    
    
    
}
