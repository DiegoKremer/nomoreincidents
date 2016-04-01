/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ManagedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import models.GrupoTecnico;


/**
 *
 * @author Diego Kremer
 */
@Named
@SessionScoped

public class GrupotecnicoMB implements Serializable {
    
    private GrupoTecnico novoGrupo;    
    private List<GrupoTecnico> grupoTecnicoDB;
    
    public GrupotecnicoMB() {
       novoGrupo = new GrupoTecnico();
       grupoTecnicoDB = new ArrayList<>();
        
    }

    
    
    public String cadastraGrupo() {
        grupoTecnicoDB.add(novoGrupo);
        this.novoGrupo = new GrupoTecnico();
        return ("grupoTecnico");
        
    }

    public GrupoTecnico getNovoGrupo() {
        return novoGrupo;
    }

    public void setNovoGrupo(GrupoTecnico novoGrupo) {
        this.novoGrupo = novoGrupo;
    }

    public List<GrupoTecnico> getGrupoTecnicoDB() {
        return grupoTecnicoDB;
    }

    public void setGrupoTecnicoDB(List<GrupoTecnico> grupoTecnicoDB) {
        this.grupoTecnicoDB = grupoTecnicoDB;
    }

   
    

    

    
    
    
}