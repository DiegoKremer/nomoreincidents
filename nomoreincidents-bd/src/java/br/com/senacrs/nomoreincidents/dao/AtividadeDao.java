/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.senacrs.nomoreincidents.dao;

import br.com.senacrs.nomoreincidents.model.Atividade;
import java.util.List;

/**
 *
 * @author Diego Kremer
 */
public interface AtividadeDao extends GenericDao<Atividade> {
    public List<Atividade> procurarPorNumeroInterno(int numeroInterno);
    
    
}
