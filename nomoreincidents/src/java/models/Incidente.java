/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import ManagedBeans.UsuarioMB;
import java.util.Date;

/**
 *
 * @author marce
 */
public class Incidente {
    
    private int numero;
    private String numeroRef;
    private String localidade;
    private UsuarioMB usuario;
    private String pesquisaUsuario;
    private Date data;
    private String descricao;
    
    public Incidente () {
    
    }
    

    public Incidente(int numero, String numeroRef, String localidade, UsuarioMB usuario, String pesquisaUsuario, Date data, String descricao) {
        this.numero = numero;
        this.numeroRef = numeroRef;
        this.localidade = localidade;
        this.usuario = usuario;
        this.pesquisaUsuario = pesquisaUsuario;
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

    public UsuarioMB getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioMB usuario) {
        this.usuario = usuario;
    }

    public String getPesquisaUsuario() {
        return pesquisaUsuario;
    }

    public void setPesquisaUsuario(String pesquisaUsuario) {
        this.pesquisaUsuario = pesquisaUsuario;
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
