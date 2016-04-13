/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
    private Usuario novoUsuario;
    
    //Armazena dados
    List<Usuario> usuariosDB;

    /**
     * Creates a new instance of usuarioMB
     */
    public UsuarioMB() {
        novoUsuario = new Usuario ();
        usuariosDB = new ArrayList<>();
        usuariosDB.add(new Usuario("admin", "admin"));
    }
    /*
     public usuarioMB(String novoUsuario, String senha, String nome,  String cargo, String telefone, String email, char tipoUsuario) {
        
     }
     */

    public String verificaDadosUsuario() {
        for (int i = 0; i < usuariosDB.size(); i++) {
            if (novoUsuario.getUsuario().equals(usuariosDB.get(i).getUsuario()) && novoUsuario.getSenha().equals(usuariosDB.get(i).getSenha()) && novoUsuario.getTipoUsuario() == 'A') {
                logado = true;
                return "index_admin";

            } else if (novoUsuario.getUsuario().equals(usuariosDB.get(i).getUsuario()) && novoUsuario.getSenha().equals(usuariosDB.get(i).getSenha()) && novoUsuario.getTipoUsuario() == 'U') {
                logado = true;
                return "index";

            } 
        }

        novoUsuario.setUsuario("");
        novoUsuario.setSenha("");
        
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


    public List<Usuario> getUsuariosDB() {
        return usuariosDB;
    }

    public void cadastraUsuario() {

        if (novoUsuario.getUsuario().length() <= 2) {
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage mensagem = new FacesMessage(
                    FacesMessage.SEVERITY_WARN,
                    "O usuário deve conter no minimo 3 caracteres",
                    "O usuário deve conter no minimo 3 caracteres");
            contexto.addMessage(null, mensagem);
            System.out.println("Campo usuario inválido");
            
        } else if (novoUsuario.getSenha().length() <= 4) {
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage mensagem = new FacesMessage(
                    FacesMessage.SEVERITY_WARN,
                    "A senha deve conter no minimo 5 caracteres",
                    "A senha deve conter no minimo 5 caracteres");
            contexto.addMessage(null, mensagem);
            System.out.println("Campo senha inválido");
        } else if (novoUsuario.getNome().length() <= 2) {
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage mensagem = new FacesMessage(
                    FacesMessage.SEVERITY_WARN,
                    "O nome deve conter no minimo 3 caracteres",
                    "O nome deve conter no minimo 3 caracteres");
            contexto.addMessage(null, mensagem);
            System.out.println("Campo nome inválido");
            
        } else if (novoUsuario.getTipoUsuario() != 'A' && novoUsuario.getTipoUsuario() != 'U' && novoUsuario.getTipoUsuario() != 'C') {
            
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage mensagem = new FacesMessage(
                    FacesMessage.SEVERITY_WARN,
                    "Você deve selecionar um tipo de usuário",
                    "Você deve selecionar um tipo de usuário");
            contexto.addMessage(null, mensagem);
            System.out.println("Campo tipo de usuário inválido");
            
        } else {
            
//            Usuario novoUsuario = new Usuario();
//            novoUsuario.setUsuario(this.novoUsuario.getUsuario());
//            novoUsuario.setSenha(this.novoUsuario.getSenha());
//            novoUsuario.setNome(this.novoUsuario.getNome());
//            novoUsuario.setCargo(this.novoUsuario.getCargo());
//            novoUsuario.setTelefone(this.novoUsuario.getTelefone());
//            novoUsuario.setEmail(this.novoUsuario.getEmail());
//            novoUsuario.setTipoUsuario(this.novoUsuario.getTipoUsuario());
            
            usuariosDB.add(novoUsuario);
                       
            this.novoUsuario = new Usuario();
            
            //limpaUsuario(this.novoUsuario);
            
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
        return novoUsuario;
    }

    public void setUsuario(Usuario usuario) {
        this.novoUsuario = usuario;
    }
    
//    public String limpaUsuario() {
//        
//        novoUsuario.setUsuario("");
//        novoUsuario.setSenha("");
//        novoUsuario.setNome("");
//        novoUsuario.setCargo("");
//        novoUsuario.setTelefone("");
//        novoUsuario.setEmail("");
//        
//        return "cadastrarUsuario";
//    }

    public Usuario getNovoUsuario() {
        return novoUsuario;
    }

    public void setNovoUsuario(Usuario novoUsuario) {
        this.novoUsuario = novoUsuario;
    }
    
    

}
