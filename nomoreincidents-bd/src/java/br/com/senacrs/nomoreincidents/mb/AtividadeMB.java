/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.senacrs.nomoreincidents.mb;

import br.com.senacrs.nomoreincidents.business.AtividadeService;
import br.com.senacrs.nomoreincidents.business.BusinessException;
import br.com.senacrs.nomoreincidents.model.Atividade;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Diego Kremer
 */
@ManagedBean
@SessionScoped
public class AtividadeMB {

    private Atividade atividadeSelecionada;

    /**
     * Creates a new instance of GrupoTecnicoMB
     */
    public AtividadeMB() {
        
    }

    public Atividade getAtividadeSelecionada() {
        return atividadeSelecionada;
    }

    public void setAtividadeSelecionada(Atividade atividadeSelecionada) {
        this.atividadeSelecionada = atividadeSelecionada;
    }
    
    
    
    public List<Atividade> getListaAtividades() {
        return new AtividadeService().listar();
    }
    
    public String novaAtividade() {
        atividadeSelecionada = new Atividade();
        return ("cadastrarAtividade?faces-redirect=true");
    }
    
    public String adicionarAtividade() {
        try {
            new AtividadeService().salvar(atividadeSelecionada);
        } catch (BusinessException ex) {
            // Erro
        }
        return (this.novaAtividade());
        
    }
    
    public String editarAtividade(Atividade at) {
        atividadeSelecionada = at;
        return ("editarAtividade?faces-redirect=true");
    }
    
    public String atualizarAtividade() {
        try {
            new AtividadeService().atualizar(atividadeSelecionada);
        } catch (BusinessException ex) {
            //Mensagem de erro!
        }
        return ("editarAtividade?faces-redirect=true");
    }
    
    public void removerAtividade(Atividade at) {
        try {
            new AtividadeService().excluir(atividadeSelecionada);
        } catch (BusinessException ex) {
            //Mensagem de erro!
        }
    }
    
}
