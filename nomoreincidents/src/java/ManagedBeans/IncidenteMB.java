/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ManagedBeans;

import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
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
public class IncidenteMB {
    
    Incidente incidente; 
    
    List<IncidenteMB> incidenteDB;
    
    // Construtores
    
    public IncidenteMB() {
        incidente = new Incidente();
        incidenteDB = new ArrayList<>();
    }
    
    
    // Metodos
    
    public void registraIncidente() {
        
        Incidente novoIncidente = new Incidente();
        
        
        novoIncidente.setNumero(geraNumeroIncidente());
        novoIncidente.setNumeroRef(incidente.getNumeroRef());
        novoIncidente.setLocalidade(incidente.getLocalidade());
        novoIncidente.setUsuario(incidente.getUsuario());
        novoIncidente.setData(incidente.getData());
        novoIncidente.setDescricao(incidente.getDescricao());
        
        incidente.setNumero(geraNumeroIncidente()); 
        incidente.setNumeroRef("");
        incidente.setLocalidade("");
        incidente.setUsuario(null);
        incidente.setData(null);
        incidente.setDescricao("");
        
        
        FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage mensagem = new FacesMessage(
                    FacesMessage.SEVERITY_INFO, 
                    "Incidente registrado",
                    "O incidente foi registrado com sucesso.");
            contexto.addMessage(null, mensagem);
            System.out.println("Incidente registrado");
    
    }
    
    public int geraNumeroIncidente() {
        int numero = 0;
        if (incidenteDB.isEmpty()) {
            return numero = 1;
        } else {
        numero = incidenteDB.get(incidenteDB.size() + 1);
        return numero;
        }
    }
    
    
    public Usuario pesquisaUsuario() {
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

    public Incidente getNovoIncidente() {
        return incidente;
    }

    public void setNovoIncidente(Incidente novoIncidente) {
        this.incidente = novoIncidente;
    }

   

    public List<IncidenteMB> getIncidenteDB() {
        return incidenteDB;
    }

    public void setIncidenteDB(List<IncidenteMB> incidenteDB) {
        this.incidenteDB = incidenteDB;
    }
    

  

    public void setIncidenteDB(ArrayList<IncidenteMB> incidenteDB) {
        this.incidenteDB = incidenteDB;
    }

    
    
    
    
}
