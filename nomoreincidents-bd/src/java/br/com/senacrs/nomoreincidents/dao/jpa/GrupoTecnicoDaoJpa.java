/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senacrs.nomoreincidents.dao.jpa;

import br.com.senacrs.nomoreincidents.dao.GrupoTecnicoDao;
import br.com.senacrs.nomoreincidents.model.GrupoTecnico;

/**
 *
 * @author 631320019
 */
public class GrupoTecnicoDaoJpa extends GenericDaoJpa<GrupoTecnico> implements GrupoTecnicoDao {
    
    public GrupoTecnicoDaoJpa() {
        super(GrupoTecnico.class);
    }
    
    
    
    
    
}
