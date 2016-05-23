/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.senacrs.nomoreincidents.mb;

import br.com.senacrs.nomoreincidents.model.Usuario;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
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
    
    /**
     * Creates a new instance of UsuarioMB
     */
    public UsuarioMB() {
        usuarioSelecionado = new Usuario ();
    }
    
    public String verificaDadosUsuario () {
        
     return ("login?faces-redirect=true");
     
    }
    
    public boolean isAdmin () {
        return false;
    }
    
    public boolean isUsuario () {
        return false;
    }
    
    public boolean isLogado () {
        return logado;
    }
    
}
