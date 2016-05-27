/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.senacrs.nomoreincidents.dao.jpa;

import br.com.senacrs.nomoreincidents.dao.IncidenteDao;
import br.com.senacrs.nomoreincidents.model.Incidente;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Marcelo Fritz
 */
public class IncidenteDaoJpa extends GenericDaoJpa<Incidente> implements IncidenteDao {

    public IncidenteDaoJpa() {
        super(Incidente.class);
    }

    @Override
    public List<Incidente> procurarPorNumeroRef(String numeroRef) {
        EntityManager em = getEntityManager();
        TypedQuery <Incidente> query = 
                em.createQuery("SELECT p FROM Incidente p WHERE p.numeroRef LIKE :numeroRef", Incidente.class);
        query.setParameter("numero","%"+numeroRef+"%");
        List<Incidente> lista = query.getResultList();
        em.close();
        return lista;   
    }


    
}
