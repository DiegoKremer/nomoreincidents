/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senacrs.nomoreincidents.dao.jpa;

import br.com.senacrs.nomoreincidents.dao.GrupoTecnicoDao;
import br.com.senacrs.nomoreincidents.model.GrupoTecnico;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Marcelo Fritz
 */
public class GrupoTecnicoDaoJpa extends GenericDaoJpa<GrupoTecnico> implements GrupoTecnicoDao {
    
    public GrupoTecnicoDaoJpa() {
        super(GrupoTecnico.class);
    }

    @Override
    public List<GrupoTecnico> procurarPorNome(String nome) {
            EntityManager em = getEntityManager();
        TypedQuery <GrupoTecnico> query = 
                em.createQuery("SELECT p FROM GrupoTecnico p WHERE p.nome LIKE :nome", GrupoTecnico.class);
        query.setParameter("nome","%"+nome+"%");
        List<GrupoTecnico> lista = query.getResultList();
        em.close();
        return lista; 
    }
    
    
    
    
    
}
