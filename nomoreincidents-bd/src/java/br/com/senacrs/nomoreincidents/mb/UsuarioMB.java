/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.senacrs.nomoreincidents.mb;

import br.com.senacrs.nomoreincidents.business.BusinessException;
import br.com.senacrs.nomoreincidents.business.UsuarioService;
import br.com.senacrs.nomoreincidents.model.Usuario;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * @author Diego Kremer
 */
@ManagedBean
@SessionScoped
public class UsuarioMB {
    
    /* 
    Variáveis temporárias de usuário e senha para usar na verificação 
    dos valores digitados na tela de login com o que está cadastrado no 
    banco.
    */ 
    private String username;
    private String password;

    // Variável para manipulação do usuário.
    private Usuario usuarioSelecionado;
    
    // Variável para verificação se usuário está logado.
    private boolean logado;
    
    
    private UsuarioService usuarioService;
    
    /**
     * Creates a new instance of UsuarioMB
     */
    public UsuarioMB() {
        usuarioSelecionado = new Usuario ();
        usuarioService = new UsuarioService ();
    }
    
    // Get e Set
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Usuario getUsuarioSelecionado() {
        return usuarioSelecionado;
    }

    public void setUsuarioSelecionado(Usuario usuarioSelecionado) {
        this.usuarioSelecionado = usuarioSelecionado;
    }
    
    
    // Métodos
    
    public String verificaDadosUsuario () throws BusinessException {
        
        if (isAdmin(usuarioService.buscaPorUsuario(username))) {
            return ("index_admin?faces-redirect=true");
        } else if (isUsuario(usuarioService.buscaPorUsuario(username))) {
            return ("index?faces-redirect=true");
        } else {
            return ("login?faces-redirect=true");
        }
     
    }
    
    public boolean isAdmin (Usuario usuario) {
        if (usuario.getTipoUsuario().equals("Admin")) {
            return true;
        } else {
        return false;
        }
    }
    
    public boolean isUsuario (Usuario usuario) {
        if (usuario.getTipoUsuario().equals("User")) {
            return true;
        } else {
        return false;
        }
    }
    
    public boolean isLogado () {
        return logado;
    }
    
    public List<Usuario> getListaUsuarios() {
        return new UsuarioService().listar();
    }
    
    public String novoUsuario() {
        usuarioSelecionado = new Usuario();
        return ("cadastrarUsuario?faces-redirect=true");
    }
    
    public String adicionarUsuario() {
        try {
            new UsuarioService().salvar(usuarioSelecionado);
            System.out.println(usuarioSelecionado.getNome());
            System.out.println(usuarioSelecionado.getCargo());
            System.out.println(usuarioSelecionado.getUsuario());
            System.out.println(usuarioSelecionado.getNome());
        } catch (BusinessException ex) {
            System.out.println("ERRO AO ADICIONAR USUARIO");
        }
        return (this.novoUsuario());
        
    }
    
    public String editarUsuario(Usuario u) {
        usuarioSelecionado = u;
        return ("editarUsuario?faces-redirect=true");
    }
    
    public String atualizarUsuario() {
        try {
            new UsuarioService().atualizar(usuarioSelecionado);
        } catch (BusinessException ex) {
            //Mensagem de erro!
        }
        return ("usuarios?faces-redirect=true");
    }
    
    public void removerUsuario(Usuario u) {
        try {
            new UsuarioService().excluir(usuarioSelecionado);
        } catch (BusinessException ex) {
            //Mensagem de erro!
        }
    }
    
}
