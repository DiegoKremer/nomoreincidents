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

    // Dados para login
    private String usuario;
    private String senha;
    private boolean logado = false;

    //Dados gerais de cadastro
    private String nome;
    private String cargo;
    private String telefone;
    private String email;
    private char tipoUsuario;

    
    
    //Armazena dados
    ArrayList<Usuario> usuariosDB = new ArrayList<Usuario>();

    /**
     * Creates a new instance of usuarioMB
     */
    public UsuarioMB() {
<<<<<<< HEAD
        usuariosDB.add(new Usuario("admin", "12345", "Admin", "Admin", "000000", "admin@admin.com", 'A'));
=======
        usuariosDB.add(new Usuario())
>>>>>>> origin/master

    }
    /*
     public usuarioMB(String usuario, String senha, String nome,  String cargo, String telefone, String email, char tipoUsuario) {
        
     }
     */

    public String verificaDadosUsuario() {
        for (int i = 0; i < usuariosDB.size(); i++) {
            if (this.getUsuario().equals(usuariosDB.get(i).getUsuario()) && this.getSenha().equals(usuariosDB.get(i).getSenha()) && this.getTipoUsuario() == 'A') {
                logado = true;
                return "index_admin";

            } else if (this.getUsuario().equals(usuariosDB.get(i).getUsuario()) && this.getSenha().equals(usuariosDB.get(i).getSenha()) && this.getTipoUsuario() == 'U') {
                logado = true;
                return "index";

            } 
        }

        usuario = "";
        senha = "";
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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public char getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(char tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public ArrayList<Usuario> getUsuariosDB() {
        return usuariosDB;
    }

    public void cadastraUsuario() {

        if (usuario.length() <= 2) {
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage mensagem = new FacesMessage(
                    FacesMessage.SEVERITY_WARN,
                    "O usuário deve conter no minimo 3 caracteres",
                    "O usuário deve conter no minimo 3 caracteres");
            contexto.addMessage(null, mensagem);
            System.out.println("Campo usuario inválido");
        } else if (senha.length() <= 4) {
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage mensagem = new FacesMessage(
                    FacesMessage.SEVERITY_WARN,
                    "A senha deve conter no minimo 5 caracteres",
                    "A senha deve conter no minimo 5 caracteres");
            contexto.addMessage(null, mensagem);
            System.out.println("Campo senha inválido");
        } else if (nome.length() <= 2) {
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage mensagem = new FacesMessage(
                    FacesMessage.SEVERITY_WARN,
                    "O nome deve conter no minimo 3 caracteres",
                    "O nome deve conter no minimo 3 caracteres");
            contexto.addMessage(null, mensagem);
            System.out.println("Campo nome inválido");
            
        } else if (tipoUsuario != 'A' && tipoUsuario != 'U' && tipoUsuario != 'C') {
            
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage mensagem = new FacesMessage(
                    FacesMessage.SEVERITY_WARN,
                    "Você deve selecionar um tipo de usuário",
                    "Você deve selecionar um tipo de usuário");
            contexto.addMessage(null, mensagem);
            System.out.println("Campo tipo de usuário inválido");
            
        } else {
            
            Usuario novoUsuario = new Usuario();
            novoUsuario.setUsuario(usuario);
            novoUsuario.setSenha(senha);
            novoUsuario.setNome(nome);
            novoUsuario.setCargo(cargo);
            novoUsuario.setTelefone(telefone);
            novoUsuario.setEmail(email);
            novoUsuario.setTipoUsuario(tipoUsuario);
            // usuariosDB.add(0, novoUsuario);
            usuariosDB.add(novoUsuario);

            usuario = "";
            senha = "";
            nome = "";
            cargo = "";
            telefone = "";
            email = "";

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

}
