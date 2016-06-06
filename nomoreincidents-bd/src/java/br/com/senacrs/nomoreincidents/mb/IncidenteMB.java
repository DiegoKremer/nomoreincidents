/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.senacrs.nomoreincidents.mb;

import br.com.senacrs.nomoreincidents.business.BusinessException;
import br.com.senacrs.nomoreincidents.business.IncidenteService;
import br.com.senacrs.nomoreincidents.model.Incidente;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Diego Kremer
 */
@ManagedBean
@SessionScoped
public class IncidenteMB {

   private Incidente incidenteSelecionado;

    /**
     * Creates a new instance of GrupoTecnicoMB
     */
    public IncidenteMB() {
    }

    public Incidente getIncidenteSelecionado() {
        return incidenteSelecionado;
    }

    public void setIncidenteSelecionado(Incidente incidenteSelecionado) {
        this.incidenteSelecionado = incidenteSelecionado;
    }
    
    
    
    public List<Incidente> getListaIncidentes() {
        return new IncidenteService().listar();
    }
    
    public String novoIncidente() {
        incidenteSelecionado = new Incidente();
        return ("cadastrarIncidente?faces-redirect=true");
    }
    
    public String adicionarIncidente() {
        try {
            new IncidenteService().salvar(incidenteSelecionado);
        } catch (BusinessException ex) {
            // Erro
        }
        return (this.novoIncidente());
        
    }
    
    public String editarIncidente(Incidente in) {
        incidenteSelecionado = in;
        return ("editarIncidente?faces-redirect=true");
    }
    
    public String atualizarIncidente() {
        try {
            new IncidenteService().atualizar(incidenteSelecionado);
        } catch (BusinessException ex) {
            //Mensagem de erro!
        }
        return ("editarIncidente?faces-redirect=true");
    }
    
    public void removerIncidente(Incidente in) {
        try {
            new IncidenteService().excluir(incidenteSelecionado);
        } catch (BusinessException ex) {
            //Mensagem de erro!
        }
    }
    
}
