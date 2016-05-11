/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Marcelo
 */
@Entity
@Table(name = "atividade")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Atividade.findAll", query = "SELECT a FROM Atividade a"),
    @NamedQuery(name = "Atividade.findByIdAtividade", query = "SELECT a FROM Atividade a WHERE a.idAtividade = :idAtividade"),
    @NamedQuery(name = "Atividade.findByNumeroInterno", query = "SELECT a FROM Atividade a WHERE a.numeroInterno = :numeroInterno"),
    @NamedQuery(name = "Atividade.findByData", query = "SELECT a FROM Atividade a WHERE a.data = :data"),
    @NamedQuery(name = "Atividade.findByHora", query = "SELECT a FROM Atividade a WHERE a.hora = :hora")})
public class Atividade implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_atividade")
    private Integer idAtividade;
    @Column(name = "numero_interno")
    private Integer numeroInterno;
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Column(name = "hora")
    @Temporal(TemporalType.DATE)
    private Date hora;
    @JoinColumn(name = "id_grupotecnico", referencedColumnName = "id_grupotecnico")
    @ManyToOne(optional = false)
    private GrupoTecnico idGrupotecnico;
    @JoinColumn(name = "id_incidente", referencedColumnName = "id_incidente")
    @ManyToOne(optional = false)
    private Incidente idIncidente;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario idUsuario;

    public Atividade() {
    }

    public Atividade(Integer idAtividade) {
        this.idAtividade = idAtividade;
    }

    public Integer getIdAtividade() {
        return idAtividade;
    }

    public void setIdAtividade(Integer idAtividade) {
        this.idAtividade = idAtividade;
    }

    public Integer getNumeroInterno() {
        return numeroInterno;
    }

    public void setNumeroInterno(Integer numeroInterno) {
        this.numeroInterno = numeroInterno;
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

    public GrupoTecnico getIdGrupotecnico() {
        return idGrupotecnico;
    }

    public void setIdGrupotecnico(GrupoTecnico idGrupotecnico) {
        this.idGrupotecnico = idGrupotecnico;
    }

    public Incidente getIdIncidente() {
        return idIncidente;
    }

    public void setIdIncidente(Incidente idIncidente) {
        this.idIncidente = idIncidente;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAtividade != null ? idAtividade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Atividade)) {
            return false;
        }
        Atividade other = (Atividade) object;
        if ((this.idAtividade == null && other.idAtividade != null) || (this.idAtividade != null && !this.idAtividade.equals(other.idAtividade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Atividade[ idAtividade=" + idAtividade + " ]";
    }
    
}
