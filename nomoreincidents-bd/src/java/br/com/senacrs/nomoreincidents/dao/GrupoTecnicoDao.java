/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.senacrs.nomoreincidents.dao;

import br.com.senacrs.nomoreincidents.model.GrupoTecnico;
import java.util.List;

/**
 *
 * @author Diego Kremer
 */
public interface GrupoTecnicoDao extends GenericDao<GrupoTecnico> {
    
    public List<GrupoTecnico> procurarPorNome(String nome);
    
}
