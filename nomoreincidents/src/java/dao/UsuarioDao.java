/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import models.Usuario;

/**
 *
 * @author 631320019
 */
public interface UsuarioDao {
    public Usuario inserir(Usuario usuario);
    public void deletar(Usuario usuario);
    public void atualizar(Usuario usuario);
    public List<Usuario> listar();
    public Usuario buscarPorId(int id);
    public Usuario buscarPorNome(String nome);
}

