/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import ManagedBeans.GrupotecnicoMB;
import ManagedBeans.IncidenteMB;
import ManagedBeans.UsuarioMB;
import java.util.Date;

/**
 *
 * @author marce
 */
public class Atividade {
    
    private int numeroInterno;
    private UsuarioMB analista;
    private IncidenteMB incidente;
    private GrupotecnicoMB grupoTecnico;
    private Date data;
    private Date hora;

    public Atividade() {
    }

    public Atividade(int numeroInterno, UsuarioMB analista, IncidenteMB incidente, GrupotecnicoMB grupoTecnico, Date data, Date hora) {
        this.numeroInterno = numeroInterno;
        this.analista = analista;
        this.incidente = incidente;
        this.grupoTecnico = grupoTecnico;
        this.data = data;
        this.hora = hora;
    }

    public int getNumeroInterno() {
        return numeroInterno;
    }

    public void setNumeroInterno(int numeroInterno) {
        this.numeroInterno = numeroInterno;
    }

    public UsuarioMB getAnalista() {
        return analista;
    }

    public void setAnalista(UsuarioMB analista) {
        this.analista = analista;
    }

    public IncidenteMB getIncidente() {
        return incidente;
    }

    public void setIncidente(IncidenteMB incidente) {
        this.incidente = incidente;
    }

    public GrupotecnicoMB getGrupoTecnico() {
        return grupoTecnico;
    }

    public void setGrupoTecnico(GrupotecnicoMB grupoTecnico) {
        this.grupoTecnico = grupoTecnico;
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
    
    
    
}
