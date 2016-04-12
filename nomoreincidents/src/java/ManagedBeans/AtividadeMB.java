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
import models.Atividade;


/**
 *
 * @author Diego Kremer
 */
@Named(value = "atividadeMB")
@ApplicationScoped
public class AtividadeMB {
    
    
    Atividade novaAtividade = new Atividade();
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


    public ArrayList<AtividadeMB> getAtividadeDB() {
        return atividadeDB;
    }

    public void setAtividadeDB(ArrayList<AtividadeMB> atividadeDB) {
        this.atividadeDB = atividadeDB;
    }

    public Atividade getNovaAtividade() {
        return novaAtividade;
    }

    public void setNovaAtividade(Atividade novaAtividade) {
        this.novaAtividade = novaAtividade;
    }
    
    
    
}
