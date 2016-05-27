/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senacrs.nomoreincidents.business;

import br.com.senacrs.nomoreincidents.dao.AtividadeDao;
import br.com.senacrs.nomoreincidents.dao.jpa.AtividadeDaoJpa;
import br.com.senacrs.nomoreincidents.model.Atividade;
import java.util.List;

/**
 *
 * @author Marcelo Fritz
 */
public class AtividadeService {
    private final AtividadeDao atividadeDao;
    
    public AtividadeService () {
        atividadeDao = new AtividadeDaoJpa();   
    }

    public List<Atividade> listar() {
        return atividadeDao.listar();
    }

    public void salvar(Atividade atividade) throws BusinessException {
        this.validaCamposObrigatorios(atividade);
        atividadeDao.salvar(atividade);
    }

    public void atualizar(Atividade atividade) throws BusinessException {
        if (atividade == null || atividade.getId() == null) {//verificar se pode ser com getId
            throw new BusinessException("Incidente não existe!");
        }
        this.validaCamposObrigatorios(atividade);
        atividadeDao.atualizar(atividade);
    }

    public void excluir(Atividade atividade) throws BusinessException {
       if (atividade == null || atividade.getId() == null) {//verificar se pode ser com getId
            throw new BusinessException("Incidente nao existe!");
        }
        atividadeDao.excluir(atividade);
    }

    private void validaCamposObrigatorios(Atividade atividade) throws BusinessException {
        if (atividade.getAnalista() == null || atividade.getAnalista().isEmpty()) {//Adicionado ArrayList no atributo Usuario na classe Atividade
            throw new BusinessException("Campo analista não informado");
        }
        
        if (atividade.getIncidente() == null || atividade.getIncidente().isEmpty()) {//Adicionado ArrayList no atributo Usuario na classe Atividade
            throw new BusinessException("Campo incidente não informado");
        }
        
        if (atividade.getGrupoTecnico() == null || atividade.getGrupoTecnico().isEmpty()) {//Adicionado ArrayList no atributo Usuario na classe Atividade
            throw new BusinessException("Campo grupo técnico não informado");
        }
        if (atividade.getDescricao() == null || atividade.getDescricao().isEmpty()) {//Só funciona com Arraylist no Usuario na classe Incidente
            throw new BusinessException("Descrição não informada");
        }
        //Criar if para data e Hora ????
    }
}
