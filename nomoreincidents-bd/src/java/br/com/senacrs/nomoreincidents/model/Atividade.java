/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.senacrs.nomoreincidents.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Diego Kremer
 */
@Entity
public class Atividade implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private int numeroInterno;
    private Usuario analista;
    private Incidente incidente;
    private GrupoTecnico grupoTecnico;
    private String descricao;
    private Date data;
    private Date hora;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumeroInterno() {
        return numeroInterno;
    }

    public void setNumeroInterno(int numeroInterno) {
        this.numeroInterno = numeroInterno;
    }

    public Usuario getAnalista() {
        return analista;
    }

    public void setAnalista(Usuario analista) {
        this.analista = analista;
    }

    public Incidente getIncidente() {
        return incidente;
    }

    public void setIncidente(Incidente incidente) {
        this.incidente = incidente;
    }

    public GrupoTecnico getGrupoTecnico() {
        return grupoTecnico;
    }

    public void setGrupoTecnico(GrupoTecnico grupoTecnico) {
        this.grupoTecnico = grupoTecnico;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Atividade)) {
            return false;
        }
        Atividade other = (Atividade) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.senacrs.nomoreincidents.model.Atividade[ id=" + id + " ]";
    }
    
}
