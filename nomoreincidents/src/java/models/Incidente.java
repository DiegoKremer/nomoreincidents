/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import ManagedBeans.UsuarioMB;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author marcelo
 */
public class Incidente {
    
    private int numero;
    private String numeroRef;
    private String localidade;
    private Usuario usuario;
    private Date data;
    private String descricao;
    
   
    
    public Incidente () {
        this.usuario = new Usuario();
    }
    

    public Incidente(int numero, String numeroRef, String localidade, Usuario usuario, Date data, String descricao) {
        this.usuario = new Usuario ();
        this.numero = numero;
        this.numeroRef = numeroRef;
        this.localidade = localidade;
        this.usuario = usuario;
        this.data = data;
        this.descricao = descricao;
        
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNumeroRef() {
        return numeroRef;
    }

    public void setNumeroRef(String numeroRef) {
        this.numeroRef = numeroRef;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }


    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    

    
    
    
    
    
}
