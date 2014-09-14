package org.presentation.checker.persistence.model;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author radio.koza
 */
@Entity
@Table(name = "domain")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Domain.findAll", query = "SELECT d FROM Domain d"),
    @NamedQuery(name = "Domain.findByIdDomain", query = "SELECT d FROM Domain d WHERE d.idDomain = :idDomain"),
    @NamedQuery(name = "Domain.findByName", query = "SELECT d FROM Domain d WHERE d.name = :name"),
    @NamedQuery(name = "Domain.findByRequestInterval", query = "SELECT d FROM Domain d WHERE d.requestInterval = :requestInterval"),
    @NamedQuery(name = "Domain.findByCheckupId", query = "SELECT d FROM Domain d WHERE d.checking.idCheckup = :checkupId")})
public class Domain implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_domain")
    private Integer idDomain;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Column(name = "request_interval")
    private Integer requestInterval;
    @JoinColumn(name = "checking", referencedColumnName = "id_checkup")
    @ManyToOne(optional = false)
    private Checkup checking;

    public Domain() {
    }

    public Domain(Integer idDomain) {
        this.idDomain = idDomain;
    }

    public Domain(Integer idDomain, String name) {
        this.idDomain = idDomain;
        this.name = name;
    }

    public Integer getIdDomain() {
        return idDomain;
    }

    public void setIdDomain(Integer idDomain) {
        this.idDomain = idDomain;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRequestInterval() {
        return requestInterval;
    }

    public void setRequestInterval(Integer requestInterval) {
        this.requestInterval = requestInterval;
    }

    public Checkup getChecking() {
        return checking;
    }

    public void setChecking(Checkup checking) {
        this.checking = checking;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDomain != null ? idDomain.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Domain)) {
            return false;
        }
        Domain other = (Domain) object;
        return !((this.idDomain == null && other.idDomain != null) || (this.idDomain != null && !this.idDomain.equals(other.idDomain)));
    }

    @Override
    public String toString() {
        return "testicek.Domain[ idDomain=" + idDomain + " ]";
    }

}