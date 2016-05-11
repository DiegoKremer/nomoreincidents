/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Collection;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Marcelo
 */
@Entity
@Table(name = "grupo_tecnico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GrupoTecnico.findAll", query = "SELECT g FROM GrupoTecnico g"),
    @NamedQuery(name = "GrupoTecnico.findByIdGrupotecnico", query = "SELECT g FROM GrupoTecnico g WHERE g.idGrupotecnico = :idGrupotecnico"),
    @NamedQuery(name = "GrupoTecnico.findByNome", query = "SELECT g FROM GrupoTecnico g WHERE g.nome = :nome"),
    @NamedQuery(name = "GrupoTecnico.findByEmail", query = "SELECT g FROM GrupoTecnico g WHERE g.email = :email"),
    @NamedQuery(name = "GrupoTecnico.findByTelefone", query = "SELECT g FROM GrupoTecnico g WHERE g.telefone = :telefone")})
public class GrupoTecnico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_grupotecnico")
    private Integer idGrupotecnico;
    @Size(max = 50)
    @Column(name = "nome")
    private String nome;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "email")
    private String email;
    @Size(max = 50)
    @Column(name = "telefone")
    private String telefone;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idGrupotecnico")
    private Collection<Atividade> atividadeCollection;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario idUsuario;

    public GrupoTecnico() {
    }

    public GrupoTecnico(Integer idGrupotecnico) {
        this.idGrupotecnico = idGrupotecnico;
    }

    public Integer getIdGrupotecnico() {
        return idGrupotecnico;
    }

    public void setIdGrupotecnico(Integer idGrupotecnico) {
        this.idGrupotecnico = idGrupotecnico;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
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
        hash += (idGrupotecnico != null ? idGrupotecnico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GrupoTecnico)) {
            return false;
        }
        GrupoTecnico other = (GrupoTecnico) object;
        if ((this.idGrupotecnico == null && other.idGrupotecnico != null) || (this.idGrupotecnico != null && !this.idGrupotecnico.equals(other.idGrupotecnico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.GrupoTecnico[ idGrupotecnico=" + idGrupotecnico + " ]";
    }
    
}
