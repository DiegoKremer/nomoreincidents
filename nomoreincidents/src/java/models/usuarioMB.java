/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

import java.io.Serializable;
import java.util.ArrayList;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ApplicationScoped;
import javax.inject.Named;

/**
 *
 * @author Diego Kremer
 */
@Named(value = "usuarioMB")

@ApplicationScoped
public class usuarioMB implements Serializable {
    
    // Dados para login
    private String usuario;
    private String senha;
    
    //Dados gerais de cadastro
    private String nome;
    private String cargo;
    private String telefone;
    private String email;
    private char tipoUsuario;
    
    //Armazena dados
    
    ArrayList<usuarioMB> usuariosDB = new ArrayList<usuarioMB> ();

    /**
     * Creates a new instance of usuarioMB
     */
    
    public usuarioMB () {
        
        
    }
    
    public usuarioMB(String usuario, String senha, String nome,  String cargo, String telefone, String email, char tipoUsuario) {
        
    }
    

  
 
    
    public String verificaDadosUsuario() {
        for (int i = 0; i < usuariosDB.size(); i++) 
        
       {
            if (this.usuario.equals(usuariosDB.get(i).getUsuario()) && this.senha.equals(usuariosDB.get(i).getSenha())) {

                return "index";
            } 
        }
        
        return "login";  
    
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
    
    public void cadastraUsuario () {
        usuariosDB.add(new usuarioMB (usuario, senha, nome, cargo, telefone, email, tipoUsuario));
    }
    
    
}
