/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 * @author marcelo
 */

public class Usuario {
    

    // Dados para login
    private String usuario;
    private String senha;

    //Dados gerais de cadastro
    private String nome;
    private String cargo;
    private String telefone;
    private String email;
    private char tipoUsuario;
    
    public Usuario () {
    
    }

    public Usuario(String usuario, String senha, String nome, String cargo, String telefone, String email, char tipoUsuario) {
        this.usuario = usuario;
        this.senha = senha;
        this.nome = nome;
        this.cargo = cargo;
        this.telefone = telefone;
        this.email = email;
        this.tipoUsuario = tipoUsuario;
    }

    public Usuario(String admin, String senha) {
        this.usuario = admin;
        this.senha = senha;
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
    
    
    @Override
    public String toString () {
        return nome;
    }
  

}
