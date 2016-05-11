/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Marcelo
 */
@Entity
@Table(name = "incidente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Incidente.findAll", query = "SELECT i FROM Incidente i"),
    @NamedQuery(name = "Incidente.findByIdIncidente", query = "SELECT i FROM Incidente i WHERE i.idIncidente = :idIncidente"),
    @NamedQuery(name = "Incidente.findByNumero", query = "SELECT i FROM Incidente i WHERE i.numero = :numero"),
    @NamedQuery(name = "Incidente.findByReferencia", query = "SELECT i FROM Incidente i WHERE i.referencia = :referencia"),
    @NamedQuery(name = "Incidente.findByLocalidade", query = "SELECT i FROM Incidente i WHERE i.localidade = :localidade"),
    @NamedQuery(name = "Incidente.findByData", query = "SELECT i FROM Incidente i WHERE i.data = :data"),
    @NamedQuery(name = "Incidente.findByDescricao", query = "SELECT i FROM Incidente i WHERE i.descricao = :descricao")})
public class Incidente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_incidente")
    private Integer idIncidente;
    @Column(name = "numero")
    private Integer numero;
    @Size(max = 50)
    @Column(name = "referencia")
    private String referencia;
    @Size(max = 50)
    @Column(name = "localidade")
    private String localidade;
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Size(max = 100)
    @Column(name = "descricao")
    private String descricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idIncidente")
    private Collection<Atividade> atividadeCollection;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario idUsuario;

    public Incidente() {
    }

    public Incidente(Integer idIncidente) {
        this.idIncidente = idIncidente;
    }

    public Integer getIdIncidente() {
        return idIncidente;
    }

    public void setIdIncidente(Integer idIncidente) {
        this.idIncidente = idIncidente;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
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

    @XmlTransient
    public Collection<Atividade> getAtividadeCollection() {
        return atividadeCollection;
    }

    public void setAtividadeCollection(Collection<Atividade> atividadeCollection) {
        this.atividadeCollection = atividadeCollection;
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
        hash += (idIncidente != null ? idIncidente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Incidente)) {
            return false;
        }
        Incidente other = (Incidente) object;
        if ((this.idIncidente == null && other.idIncidente != null) || (this.idIncidente != null && !this.idIncidente.equals(other.idIncidente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Incidente[ idIncidente=" + idIncidente + " ]";
    }
    
}
