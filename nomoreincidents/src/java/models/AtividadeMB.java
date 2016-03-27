/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

import java.util.ArrayList;
import java.util.Date;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Diego Kremer
 */
@ManagedBean
@ApplicationScoped
public class atividadeMB {
    
    private int numeroInterno;
    private usuarioMB analista;
    private incidenteMB incidente;
    private grupotecnicoMB grupoTecnico;
    private Date data;
    private Date hora;
    
    
    ArrayList<atividadeMB> atividadeDB = new ArrayList();

    /**
     * Creates a new instance of atividadeMB
     */
    public atividadeMB() {
        
    }
    
    // Metodos
    
    public void registraAtividade () {
    
    }
    
    // Getters and Setters
    public int getNumeroInterno() {
        return numeroInterno;
    }

    public void setNumeroInterno(int numeroInterno) {
        this.numeroInterno = numeroInterno;
    }

    public usuarioMB getAnalista() {
        return analista;
    }

    public void setAnalista(usuarioMB analista) {
        this.analista = analista;
    }

    public incidenteMB getIncidente() {
        return incidente;
    }

    public void setIncidente(incidenteMB incidente) {
        this.incidente = incidente;
    }

    public grupotecnicoMB getGrupoTecnico() {
        return grupoTecnico;
    }

    public void setGrupoTecnico(grupotecnicoMB grupoTecnico) {
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
