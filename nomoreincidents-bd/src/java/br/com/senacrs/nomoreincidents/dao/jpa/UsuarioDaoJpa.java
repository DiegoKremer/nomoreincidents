/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.senacrs.nomoreincidents.dao.jpa;

import br.com.senacrs.nomoreincidents.dao.UsuarioDao;
import br.com.senacrs.nomoreincidents.model.Usuario;

/**
 *
 * @author Diego Kremer
 */
public class UsuarioDaoJpa extends GenericDaoJpa<Usuario> implements UsuarioDao {

    public UsuarioDaoJpa() {
        super(Usuario.class);
    }

    @Override
    public Usuario buscarPorUsuario(String usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
