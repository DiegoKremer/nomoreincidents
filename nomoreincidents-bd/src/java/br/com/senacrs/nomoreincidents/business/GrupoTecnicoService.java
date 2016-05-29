/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senacrs.nomoreincidents.business;

import br.com.senacrs.nomoreincidents.dao.GrupoTecnicoDao;
import br.com.senacrs.nomoreincidents.dao.jpa.GrupoTecnicoDaoJpa;
import br.com.senacrs.nomoreincidents.model.GrupoTecnico;
import java.util.List;

/**
 *
 * @author Diego Kremer
 */
public class GrupoTecnicoService {
    
    private final GrupoTecnicoDao grupoTecnicoDao;
    
    public GrupoTecnicoService () {
        grupoTecnicoDao = new GrupoTecnicoDaoJpa();   
    }

    public List<GrupoTecnico> listar() {
        return grupoTecnicoDao.listar();
    }

    public void salvar(GrupoTecnico grupo) throws BusinessException {
        this.validaCamposObrigatorios(grupo);
        grupoTecnicoDao.salvar(grupo);
    }

    public void atualizar(GrupoTecnico grupo) throws BusinessException {
        if (grupo == null || grupo.getNome() == null) {
            throw new BusinessException("Grupo não existe!");
        }
        this.validaCamposObrigatorios(grupo);
        grupoTecnicoDao.atualizar(grupo);
    }

    public void excluir(GrupoTecnico grupo) throws BusinessException {
       if (grupo == null || grupo.getNome() == null) {
            throw new BusinessException("Grupo nao existe!");
        }
        grupoTecnicoDao.excluir(grupo);
    }

    private void validaCamposObrigatorios(GrupoTecnico grupo) throws BusinessException {
        if (grupo.getNome() == null || grupo.getNome().isEmpty()) {
            throw new BusinessException("Campo Nome não informado");
        }
        
        if (grupo.getEmail() == null || grupo.getEmail().isEmpty()) {
            throw new BusinessException("Campo Email não informado");
        }
        
//        if (grupo.getMembros() == null || grupo.getMembros().isEmpty()) {
//            throw new BusinessException("Membros do grupo não informado");
//        }
    
    }
    
}
