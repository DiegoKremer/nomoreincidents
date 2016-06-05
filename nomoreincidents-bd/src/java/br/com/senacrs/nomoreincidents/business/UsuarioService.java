/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.senacrs.nomoreincidents.business;

import br.com.senacrs.nomoreincidents.dao.UsuarioDao;
import br.com.senacrs.nomoreincidents.dao.jpa.UsuarioDaoJpa;
import br.com.senacrs.nomoreincidents.model.Usuario;
import java.util.List;

/**
 *
 * @author Diego Kremer
 */
public class UsuarioService {
    
    private final UsuarioDao usuarioDao;
    
    public UsuarioService () {
        usuarioDao = new UsuarioDaoJpa();
    }

    public List<Usuario> listar() {
        return (usuarioDao.listar());
    }

    public void salvar(Usuario usuario) throws BusinessException {
        this.validaCamposObrigatorios(usuario);
        usuarioDao.salvar(usuario);
    }

    public void atualizar(Usuario usuario) throws BusinessException {
        if (usuario == null || usuario.getUsuario() == null) {
            throw new BusinessException("Usuário não existe!");
        }
        this.validaCamposObrigatorios(usuario);
        usuarioDao.atualizar(usuario);
    }

    public void excluir(Usuario usuario) throws BusinessException {
        if (usuario == null || usuario.getUsuario() == null) {
            throw new BusinessException("Paciente nao existe!");
        }
        usuarioDao.excluir(usuario);
    }
    
    
    public Usuario buscaPorUsuario(String usuarioBuscado) throws BusinessException {
        if (usuarioBuscado == null || usuarioBuscado.isEmpty()) {
            throw new BusinessException("Campo Usuario não informado");
        }
        Usuario usuario = usuarioDao.buscarPorUsuario(usuarioBuscado);
        if (usuario == null) {
            throw new BusinessException("Usuário não encontrado");
        }
        return (usuario);
    }

    private void validaCamposObrigatorios(Usuario usuario) throws BusinessException {
        if (usuario.getUsuario() == null || usuario.getUsuario().isEmpty()) {
            throw new BusinessException("Campo Usuário não informado");
        }
        
        if (usuario.getSenha() == null || usuario.getSenha().isEmpty()) {
            throw new BusinessException("Campo Senha não informado");
        }
        
        if (usuario.getTipoUsuario() == null || usuario.getTipoUsuario().isEmpty()) {
            throw new BusinessException("Campo Tipo de Usuário não informado");
        }
    } 
    
    
}
