/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senacrs.nomoreincidents.business;

import br.com.senacrs.nomoreincidents.dao.IncidenteDao;
import br.com.senacrs.nomoreincidents.dao.jpa.IncidenteDaoJpa;
import br.com.senacrs.nomoreincidents.model.Incidente;
import java.util.List;

/**
 *
 * @author Marcelo Fritz
 */
public class IncidenteService {
    
    private final IncidenteDao incidenteDao;
    
    public IncidenteService () {
        incidenteDao = new IncidenteDaoJpa();   
    }

    public List<Incidente> listar() {
        return incidenteDao.listar();
    }

    public void salvar(Incidente incidente) throws BusinessException {
        this.validaCamposObrigatorios(incidente);
        incidenteDao.salvar(incidente);
    }

    public void atualizar(Incidente incidente) throws BusinessException {
        if (incidente == null || incidente.getNumeroRef() == null) {
            throw new BusinessException("Incidente não existe!");
        }
        this.validaCamposObrigatorios(incidente);
        incidenteDao.atualizar(incidente);
    }

    public void excluir(Incidente incidente) throws BusinessException {
       if (incidente == null || incidente.getNumeroRef() == null) {
            throw new BusinessException("Incidente nao existe!");
        }
        incidenteDao.excluir(incidente);
    }

    private void validaCamposObrigatorios(Incidente incidente) throws BusinessException {
        if (incidente.getNumeroRef() == null || incidente.getNumeroRef().isEmpty()) {
            throw new BusinessException("Campo número de referência não informado");
        }
        
        if (incidente.getLocalidade() == null || incidente.getLocalidade().isEmpty()) {
            throw new BusinessException("Campo localidade não informado");
        }
        
        if (incidente.getDescricao() == null || incidente.getDescricao().isEmpty()) {
            throw new BusinessException("Descrição do grupo não informada");
        }
//        if (incidente.getUsuario() == null || incidente.getUsuario().isEmpty()) {//adicionado Arraylist no atributo usuario na classe model Incidente
//            throw new BusinessException("Usuario do grupo não informado");
//        }
        if (incidente.getData() == null ) {
            throw new BusinessException("Data não informada");
        }
        
    }
    
}

