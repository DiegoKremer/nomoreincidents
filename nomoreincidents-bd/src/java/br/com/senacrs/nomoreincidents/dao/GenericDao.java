/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.senacrs.nomoreincidents.dao;

import java.util.List;

/**
 *
 * @author Diego Kremer
 * @param <T>
 * 
 */
public interface GenericDao<T> {
    
    public T salvar(T entity);
    public void excluir(T entity);
    public T atualizar(T entity);    
    public List<T> listar();
    public T procurarPorId(Long id);
    
}
