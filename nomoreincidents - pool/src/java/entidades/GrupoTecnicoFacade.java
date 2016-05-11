/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Marcelo
 */
@Stateless
public class GrupoTecnicoFacade extends AbstractFacade<GrupoTecnico> {

    @PersistenceContext(unitName = "nomoreincidents_-_poolPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GrupoTecnicoFacade() {
        super(GrupoTecnico.class);
    }
    
}
