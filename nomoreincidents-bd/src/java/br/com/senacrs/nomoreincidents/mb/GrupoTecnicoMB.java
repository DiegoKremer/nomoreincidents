/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.senacrs.nomoreincidents.mb;

import br.com.senacrs.nomoreincidents.business.BusinessException;
import br.com.senacrs.nomoreincidents.business.GrupoTecnicoService;
import br.com.senacrs.nomoreincidents.model.GrupoTecnico;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Diego Kremer
 */

@Named(value = "grupotecnicoMB")

@ManagedBean
@SessionScoped
public class GrupoTecnicoMB {
    
    private GrupoTecnico grupoSelecionado;

    /**
     * Creates a new instance of GrupoTecnicoMB
     */
    public GrupoTecnicoMB() {
    }

    public GrupoTecnico getGrupoSelecionado() {
        return grupoSelecionado;
    }

    public void setGrupoSelecionado(GrupoTecnico grupoSelecionado) {
        this.grupoSelecionado = grupoSelecionado;
    }
    
    
    
    public List<GrupoTecnico> getListaGruposTecnicos() {
        return new GrupoTecnicoService().listar();
    }
    
    public String novoGrupoTecnico() {
        grupoSelecionado = new GrupoTecnico();
        return ("cadastrarGrupoTecnico?faces-redirect=true");
    }
    
    public String adicionarGrupoTecnico() {
        try {
            new GrupoTecnicoService().salvar(grupoSelecionado);
        } catch (BusinessException ex) {
            // Erro
        }
        return (this.novoGrupoTecnico());
        
    }
    
    public String editarGrupoTecnico(GrupoTecnico gt) {
        grupoSelecionado = gt;
        return ("editarGrupoTecnico?faces-redirect=true");
    }
    
    public String atualizarGrupoTecnico() {
        try {
            new GrupoTecnicoService().atualizar(grupoSelecionado);
        } catch (BusinessException ex) {
            //Mensagem de erro!
        }
        return ("editarGrupoTecnico?faces-redirect=true");
    }
    
    public void removerGrupoTecnico(GrupoTecnico gt) {
        try {
            new GrupoTecnicoService().excluir(grupoSelecionado);
        } catch (BusinessException ex) {
            //Mensagem de erro!
        }
    }
    
}
