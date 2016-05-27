/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senacrs.nomoreincidents.dao.jpa;

import br.com.senacrs.nomoreincidents.dao.AtividadeDao;
import br.com.senacrs.nomoreincidents.model.Atividade;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Marcelo Fritz
 */
public class AtividadeDaoJpa extends GenericDaoJpa<Atividade> implements AtividadeDao {
    
    public AtividadeDaoJpa(Class<Atividade> entityClass) {
        super(entityClass);
    }

    public AtividadeDaoJpa() {
        super(Atividade.class);
    }

    @Override
    public List<Atividade> procurarPorNumeroInterno(int numeroInterno) {
        EntityManager em = getEntityManager();
        TypedQuery <Atividade> query = 
                em.createQuery("SELECT p FROM Atividade p WHERE p.numeroInterno LIKE :numeroInterno", Atividade.class);
        query.setParameter("numero","%"+numeroInterno+"%");
        List<Atividade> lista = query.getResultList();
        em.close();
        return lista; 
    }

  
    
}
