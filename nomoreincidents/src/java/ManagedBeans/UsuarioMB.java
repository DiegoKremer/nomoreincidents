/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import models.Usuario;

/**
 *
 * @author Diego Kremer
 */
@Named(value = "usuarioMB")

@ApplicationScoped
public class UsuarioMB implements Serializable {


    private boolean logado = false;
    private Usuario usuario;
    
    //Armazena dados
    ArrayList<Usuario> usuariosDB;

    /**
     * Creates a new instance of usuarioMB
     */
    public UsuarioMB() {
        usuario = new Usuario ();
        usuariosDB = new ArrayList<>();
        
    }
    /*
     public usuarioMB(String usuario, String senha, String nome,  String cargo, String telefone, String email, char tipoUsuario) {
        
     }
     */

    public String verificaDadosUsuario() {
        for (int i = 0; i < usuariosDB.size(); i++) {
            if (usuario.getUsuario().equals(usuariosDB.get(i).getUsuario()) && usuario.getSenha().equals(usuariosDB.get(i).getSenha()) && usuario.getTipoUsuario() == 'A') {
                logado = true;
                return "index_admin";

            } else if (usuario.getUsuario().equals(usuariosDB.get(i).getUsuario()) && usuario.getSenha().equals(usuariosDB.get(i).getSenha()) && usuario.getTipoUsuario() == 'U') {
                logado = true;
                return "index";

            } 
        }

        usuario.setUsuario("");
        usuario.setSenha("");
        
        FacesContext contexto = FacesContext.getCurrentInstance();
        FacesMessage mensagem = new FacesMessage(
                FacesMessage.SEVERITY_ERROR,
                "Login inválido!",
                "Usuario ou senha incorretos! Verifique os dados digitados.");
        contexto.addMessage(null, mensagem);
        System.out.println("Usuario deve estar cadastrado");

        return "login";

    }
    
    public boolean isLogado () {
        return logado;
    }


    public ArrayList<Usuario> getUsuariosDB() {
        return usuariosDB;
    }

    public void cadastraUsuario() {

        if (usuario.getUsuario().length() <= 2) {
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage mensagem = new FacesMessage(
                    FacesMessage.SEVERITY_WARN,
                    "O usuário deve conter no minimo 3 caracteres",
                    "O usuário deve conter no minimo 3 caracteres");
            contexto.addMessage(null, mensagem);
            System.out.println("Campo usuario inválido");
        } else if (usuario.getSenha().length() <= 4) {
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage mensagem = new FacesMessage(
                    FacesMessage.SEVERITY_WARN,
                    "A senha deve conter no minimo 5 caracteres",
                    "A senha deve conter no minimo 5 caracteres");
            contexto.addMessage(null, mensagem);
            System.out.println("Campo senha inválido");
        } else if (usuario.getNome().length() <= 2) {
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage mensagem = new FacesMessage(
                    FacesMessage.SEVERITY_WARN,
                    "O nome deve conter no minimo 3 caracteres",
                    "O nome deve conter no minimo 3 caracteres");
            contexto.addMessage(null, mensagem);
            System.out.println("Campo nome inválido");
            
        } else if (usuario.getTipoUsuario() != 'A' && usuario.getTipoUsuario() != 'U' && usuario.getTipoUsuario() != 'C') {
            
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage mensagem = new FacesMessage(
                    FacesMessage.SEVERITY_WARN,
                    "Você deve selecionar um tipo de usuário",
                    "Você deve selecionar um tipo de usuário");
            contexto.addMessage(null, mensagem);
            System.out.println("Campo tipo de usuário inválido");
            
        } else {
            
            Usuario novoUsuario = new Usuario();
            novoUsuario.setUsuario(usuario.getUsuario());
            novoUsuario.setSenha(usuario.getSenha());
            novoUsuario.setNome(usuario.getNome());
            novoUsuario.setCargo(usuario.getCargo());
            novoUsuario.setTelefone(usuario.getTelefone());
            novoUsuario.setEmail(usuario.getEmail());
            novoUsuario.setTipoUsuario(usuario.getTipoUsuario());
            
            usuariosDB.add(novoUsuario);

            limpaUsuario(usuario);

            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage mensagem = new FacesMessage(
                    FacesMessage.SEVERITY_INFO,
                    "Usuário cadastrado com sucesso",
                    "O cadastro do usuário foi realizado com sucesso.");
            contexto.addMessage(null, mensagem);
            System.out.println("Usuario cadastrado");
            
        }
    }

    public String getAnalistasCadastrados() {
        for (int i = 0; i < usuariosDB.size(); i++) {
            if (usuariosDB.get(i).getTipoUsuario() == 'U' || usuariosDB.get(i).getTipoUsuario() == 'A') {
                return usuariosDB.get(i).getNome();
            }
        }

        return "Usuário Não Encontrado";
    }

    public int getNumeroUsuariosCadastrados() {
        return usuariosDB.size();
    }

    public void setUsuariosDB(ArrayList<Usuario> usuariosDB) {
        this.usuariosDB = usuariosDB;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public void limpaUsuario(Usuario usuario) {
        
        usuario.setUsuario("");
        usuario.setSenha("");
        usuario.setNome("");
        usuario.setCargo("");
        usuario.setTelefone("");
        usuario.setEmail("");
    
    }
    
    

}
