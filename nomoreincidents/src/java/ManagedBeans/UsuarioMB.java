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
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import models.GrupoTecnico;
import models.Usuario;

/**
 *
 * @author Diego Kremer
 */
@Named(value = "usuarioMB")

@SessionScoped
public class UsuarioMB implements Serializable {
    
    private String username;
    private String password;
   
    private boolean logado;
    private Usuario novoUsuario;
    
    //Armazena dados
    List<Usuario> usuariosDB;

    /**
     * Creates a new instance of usuarioMB
     */
    public UsuarioMB() {
        novoUsuario = new Usuario ();
        usuariosDB = new ArrayList<>();
        usuariosDB.add(new Usuario("diegokremer", "12345", "Diego Kremer", "Admin", "555555", "email@email", 'A'));
        usuariosDB.add(new Usuario("marcelofritz", "12345", "Marcelo Fritz", "Admin", "555555", "email@email", 'A'));
        usuariosDB.add(new Usuario("jurandircosta", "12345", "Jurandir Costa", "Analista", "555555", "email@email", 'U'));
        usuariosDB.add(new Usuario("gerivaldapedreira", "12345", "Gerivalda Pedreira", "Colaborador", "555555", "email@email", 'C'));
        logado = false;
    }
    /*
     public usuarioMB(String novoUsuario, String senha, String nome,  String cargo, String telefone, String email, char tipoUsuario) {
        
     }
     */

    public String verificaDadosUsuario() {
        for (int i = 0; i < usuariosDB.size(); i++) {
            
            if (usuariosDB.get(i).getUsuario().equals(this.username) 
                    && usuariosDB.get(i).getSenha().equals(this.password)) {
                
                if (isAdmin(usuariosDB.get(i))) {
                    logado = true;
                    return ("index_admin?faces-redirect=true");
                } else if (isUsuario(usuariosDB.get(i))) {
                    logado = true;
                    return ("index?faces-redirect=true");
                } else {
                    username = "";
                    password = "";
        
                    FacesContext contexto = FacesContext.getCurrentInstance();
                    FacesMessage mensagem = new FacesMessage(
                    FacesMessage.SEVERITY_ERROR,
                    "Login inválido!",
                    "Usuario ou senha incorretos! Verifique os dados digitados.");
                    contexto.addMessage(null, mensagem);
                    System.out.println("Usuario deve estar cadastrado");

                    return ("login?faces-redirect=true");
                }
            
            }
        
        }
        
        return ("login?faces-redirect=true");
    }
    
    
   
    
    public boolean isAdmin (Usuario usuario) {
        if (usuario.getTipoUsuario() == 'A') {
            return true;
        } else  {
            return false;
        }
    }
    
    public boolean isUsuario (Usuario usuario) {
        if (usuario.getTipoUsuario() == 'U') {
            return true;
        } else  {
            return false;
        }
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
            
            limpaUsuario(this.novoUsuario);
            
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
    
    public Usuario limpaUsuario(Usuario usuario) {
        
        usuario.setUsuario("");
        usuario.setSenha("");
        usuario.setNome("");
        usuario.setCargo("");
        usuario.setTelefone("");
        usuario.setEmail("");
        
        return usuario;
        
    }

    public Usuario getNovoUsuario() {
        return novoUsuario;
    }

    public void setNovoUsuario(Usuario novoUsuario) {
        this.novoUsuario = novoUsuario;
    }

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
    
    
    
    
    
    
    public String realizaLogout() {
        FacesContext contexto = FacesContext.getCurrentInstance();
        contexto.getExternalContext().invalidateSession();
        return ("login?faces-redirect=true");
    }

    public Usuario pesquisaUsuario(String nome) {
        for(Usuario e: usuariosDB)
            if(e.getNome().equals(nome))
                return(e);
        return null;
    }
    
    //--------------------------------------------------------------------------
    public String removerUsuario(Usuario novoUsuario){
        usuariosDB.remove(novoUsuario);
        return "usuario?faces-redirect=true";
    }
    public String editarUsuario(Usuario u){
        novoUsuario = u;
        return("/editarUsuario?faces-redirect=true");
    }
    public String atualizarUsuario()
    {
        return("/usuarios?faces-redirect=true");
    }

}
