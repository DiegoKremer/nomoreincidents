/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ManagedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.inject.Named;
import models.Atividade;


/**
 *
 * @author Diego Kremer
 */
@Named(value = "atividadeMB")
@ApplicationScoped
public class AtividadeMB implements Serializable {
    
    
    private Atividade novaAtividade;
    private List<Atividade> atividadeDB;

    /**
     * Creates a new instance of atividadeMB
     */
    public AtividadeMB() {
        novaAtividade = new Atividade();
        atividadeDB = new ArrayList<>();
    }
    
    // Metodos
    
    public String registraAtividade () {
        atividadeDB.add(novaAtividade);
        this.novaAtividade = new Atividade();
        return "atividades?faces-redirect=true";
    
    }
    
    // Getters and Setters

    public Atividade getNovaAtividade() {
        return novaAtividade;
    }

    public void setNovaAtividade(Atividade novaAtividade) {
        this.novaAtividade = novaAtividade;
    }

    public List<Atividade> getAtividadeDB() {
        return atividadeDB;
    }

    public void setAtividadeDB(List<Atividade> atividadeDB) {
        this.atividadeDB = atividadeDB;
    }

    
    
    
    
    
}
