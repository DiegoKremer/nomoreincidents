/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ManagedBeans;

import java.util.ArrayList;
import java.util.Date;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;


/**
 *
 * @author Diego Kremer
 */
@Named(value = "atividadeMB")
@ManagedBean
@ApplicationScoped
public class AtividadeMB {
    
    private int numeroInterno;
    private UsuarioMB analista;
    private IncidenteMB incidente;
    private GrupotecnicoMB grupoTecnico;
    private Date data;
    private Date hora;
    
    
    ArrayList<AtividadeMB> atividadeDB = new ArrayList();

    /**
     * Creates a new instance of atividadeMB
     */
    public AtividadeMB() {
        
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

    public ArrayList<AtividadeMB> getAtividadeDB() {
        return atividadeDB;
    }

    public void setAtividadeDB(ArrayList<AtividadeMB> atividadeDB) {
        this.atividadeDB = atividadeDB;
    }
    
    
    
}