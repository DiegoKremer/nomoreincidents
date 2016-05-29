/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.senacrs.nomoreincidents.dao.jpa;

import br.com.senacrs.nomoreincidents.dao.UsuarioDao;
import br.com.senacrs.nomoreincidents.model.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Diego Kremer
 */
public class UsuarioDaoJpa extends GenericDaoJpa<Usuario> implements UsuarioDao {

    public UsuarioDaoJpa() 
    {
        super(Usuario.class);
    }

    @Override
    public Usuario buscarPorUsuario(String usuarioBuscado) {
        EntityManager em = getEntityManager();
        TypedQuery <Usuario> query = 
                em.createQuery("SELECT u FROM Usuario u "
                        + "WHERE u.usuario = :usuarioBuscado", Usuario.class);
        query.setParameter("usuarioBuscado", usuarioBuscado);
        List<Usuario> lista = query.getResultList();
        em.close();
        if(lista.isEmpty()) return null;
        return lista.get(0);
    }
    
}
