package org.presentation.persistence.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.enterprise.inject.Vetoed;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Entity class representing the entity Checkup in JPA entity architecture.
 *
 * @author radio.koza
 * @version 1.0-SNAPSHOT
 */
@Entity
@Vetoed
@Table(name = "checkup")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Checkup.findAll", query = "SELECT c FROM Checkup c"),
    @NamedQuery(name = "Checkup.findByIdCheckup", query = "SELECT c FROM Checkup c WHERE c.idCheckup = :idCheckup"),
    @NamedQuery(name = "Checkup.findByCheckingCreated", query = "SELECT c FROM Checkup c WHERE c.checkingCreated = :checkingCreated"),
    @NamedQuery(name = "Checkup.findByState", query = "SELECT c FROM Checkup c WHERE c.state = :state"),
    @NamedQuery(name = "Checkup.findByCheckingFinished", query = "SELECT c FROM Checkup c WHERE c.checkingFinished = :checkingFinished"),
    @NamedQuery(name = "Checkup.findByStartPoint", query = "SELECT c FROM Checkup c WHERE c.startPoint = :startPoint"),
    @NamedQuery(name = "Checkup.findByMaxDepth", query = "SELECT c FROM Checkup c WHERE c.maxDepth = :maxDepth"),
    @NamedQuery(name = "Checkup.findByUserEmail", query = "SELECT c FROM Checkup c WHERE c.user.email = :email ORDER BY c.checkingCreated DESC"),
    @NamedQuery(name = "Checkup.countUserCheckups", query = "SELECT COUNT(c) FROM Checkup c WHERE c.user.email = :email")})
public class Checkup implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_checkup")
    private Integer idCheckup;
    @Basic(optional = false)
    @Column(name = "checking_created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkingCreated;
    @Basic(optional = false)
    @Column(name = "\"state\"")
    @Enumerated(EnumType.STRING)
    private CheckState state;
    @Column(name = "checking_finished")
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkingFinished;
    @Basic(optional = false)
    @Column(name = "start_point", length = 2048)
    private String startPoint;
    @Column(name = "max_depth")
    private Integer maxDepth;
    @Column(name = "checking_interval")
    private Integer checkingInterval;
    @Column(name = "page_limit")
    private Integer pageLimit;
    @JoinTable(name = "checkup_has_option", joinColumns = {
        @JoinColumn(name = "checkup", referencedColumnName = "id_checkup")}, inverseJoinColumns = {
        @JoinColumn(name = "\"option\"", referencedColumnName = "id_option")})
    @ManyToMany
    private List<ChosenOption> optionList = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "checkup")
    private List<MessageEntity> messageEntityList = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "checking")
    private List<Domain> domainList = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "checkup")
    private List<HeaderEntity> headerList = new ArrayList<>();
    @JoinColumn(name = "user", referencedColumnName = "email")
    @ManyToOne(optional = false)
    private User user;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "checkup")
    private List<Graph> graphList = new ArrayList<>();

    /**
     * Non-parametrict constructor required by JPA specification.
     */
    public Checkup() {
    }

    /**
     * Constructor with primary key.
     *
     * @param idCheckup Primary key of the checkup
     */
    public Checkup(Integer idCheckup) {
        this.idCheckup = idCheckup;
    }

    /**
     * <p>
     * Getter for the field <code>idCheckup</code>.</p>
     *
     * @return a {@link java.lang.Integer} object.
     */
    public Integer getIdCheckup() {
        return idCheckup;
    }

    /**
     * <p>
     * Setter for the field <code>idCheckup</code>.</p>
     *
     * @param idCheckup a {@link java.lang.Integer} object.
     */
    public void setIdCheckup(Integer idCheckup) {
        this.idCheckup = idCheckup;
    }

    /**
     * <p>
     * Getter for the field <code>checkingCreated</code>.</p>
     *
     * @return a {@link java.util.Date} object.
     */
    public Date getCheckingCreated() {
        return checkingCreated;
    }

    /**
     * <p>
     * Setter for the field <code>checkingCreated</code>.</p>
     *
     * @param checkingCreated a {@link java.util.Date} object.
     */
    public void setCheckingCreated(Date checkingCreated) {
        this.checkingCreated = checkingCreated;
    }

    /**
     * <p>
     * Getter for the field <code>state</code>.</p>
     *
     * @return a {@link org.presentation.persistence.model.CheckState} object.
     */
    public CheckState getState() {
        return state;
    }

    /**
     * <p>
     * Setter for the field <code>state</code>.</p>
     *
     * @param state a {@link org.presentation.persistence.model.CheckState}
     * object.
     */
    public void setState(CheckState state) {
        this.state = state;
    }

    /**
     * <p>
     * Getter for the field <code>checkingFinished</code>.</p>
     *
     * @return a {@link java.util.Date} object.
     */
    public Date getCheckingFinished() {
        return checkingFinished;
    }

    /**
     * <p>
     * Setter for the field <code>checkingFinished</code>.</p>
     *
     * @param checkingFinished a {@link java.util.Date} object.
     */
    public void setCheckingFinished(Date checkingFinished) {
        this.checkingFinished = checkingFinished;
    }

    /**
     * <p>
     * Getter for the field <code>startPoint</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getStartPoint() {
        return startPoint;
    }

    /**
     * <p>
     * Setter for the field <code>startPoint</code>.</p>
     *
     * @param startPoint a {@link java.lang.String} object.
     */
    public void setStartPoint(String startPoint) {
        this.startPoint = startPoint;
    }

    /**
     * <p>
     * Getter for the field <code>maxDepth</code>.</p>
     *
     * @return a {@link java.lang.Integer} object.
     */
    public Integer getMaxDepth() {
        return maxDepth;
    }

    /**
     * <p>
     * Setter for the field <code>maxDepth</code>.</p>
     *
     * @param maxDepth a {@link java.lang.Integer} object.
     */
    public void setMaxDepth(Integer maxDepth) {
        this.maxDepth = maxDepth;
    }

    /**
     * <p>
     * Getter for the field <code>checkingInterval</code>.</p>
     *
     * @return a {@link java.lang.Integer} object.
     */
    public Integer getCheckingInterval() {
        return checkingInterval;
    }

    /**
     * <p>
     * Setter for the field <code>checkingInterval</code>.</p>
     *
     * @param checkingInterval a {@link java.lang.Integer} object.
     */
    public void setCheckingInterval(Integer checkingInterval) {
        this.checkingInterval = checkingInterval;
    }

    /**
     * <p>
     * Getter for the field <code>optionList</code>.</p>
     *
     * @return a {@link java.util.List} object.
     */
    @XmlTransient
    public List<ChosenOption> getOptionList() {
        return optionList;
    }

    /**
     * <p>
     * Setter for the field <code>optionList</code>.</p>
     *
     * @param optionList a {@link java.util.List} object.
     */
    public void setOptionList(List<ChosenOption> optionList) {
        this.optionList = optionList;
    }

    /**
     * <p>
     * Getter for the field <code>messageEntityList</code>.</p>
     *
     * @return a {@link java.util.List} object.
     */
    @XmlTransient
    public List<MessageEntity> getMessageEntityList() {
        return messageEntityList;
    }

    /**
     * <p>
     * setResourceList.</p>
     *
     * @param messageEntityList a {@link java.util.List} object.
     */
    public void setResourceList(List<MessageEntity> messageEntityList) {
        this.messageEntityList = messageEntityList;
    }

    /**
     * <p>
     * Getter for the field <code>domainList</code>.</p>
     *
     * @return a {@link java.util.List} object.
     */
    @XmlTransient
    public List<Domain> getDomainList() {
        return domainList;
    }

    /**
     * <p>
     * Setter for the field <code>domainList</code>.</p>
     *
     * @param domainList a {@link java.util.List} object.
     */
    public void setDomainList(List<Domain> domainList) {
        this.domainList = domainList;
    }

    /**
     * <p>
     * Getter for the field <code>headerList</code>.</p>
     *
     * @return a {@link java.util.List} object.
     */
    @XmlTransient
    public List<HeaderEntity> getHeaderList() {
        return headerList;
    }

    /**
     * <p>
     * Setter for the field <code>headerList</code>.</p>
     *
     * @param headerList a {@link java.util.List} object.
     */
    public void setHeaderList(List<HeaderEntity> headerList) {
        this.headerList = headerList;
    }

    /**
     * <p>
     * Getter for the field <code>user</code>.</p>
     *
     * @return a {@link org.presentation.persistence.model.User} object.
     */
    public User getUser() {
        return user;
    }

    /**
     * <p>
     * Setter for the field <code>user</code>.</p>
     *
     * @param user a {@link org.presentation.persistence.model.User} object.
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * <p>
     * Getter for the field <code>graphList</code>.</p>
     *
     * @return a {@link java.util.List} object.
     */
    @XmlTransient
    public List<Graph> getGraphList() {
        return graphList;
    }

    /**
     * <p>
     * Setter for the field <code>graphList</code>.</p>
     *
     * @param graphList a {@link java.util.List} object.
     */
    public void setGraphList(List<Graph> graphList) {
        this.graphList = graphList;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCheckup != null ? idCheckup.hashCode() : 0);
        return hash;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Checkup)) {
            return false;
        }
        Checkup other = (Checkup) object;
        return !((this.idCheckup == null && other.idCheckup != null) || (this.idCheckup != null && !this.idCheckup.equals(other.idCheckup)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "test.Checkup[ idCheckup=" + idCheckup + " ]";
    }

    /**
     * <p>
     * Getter for the field <code>pageLimit</code>.</p>
     *
     * @return a {@link java.lang.Integer} object.
     */
    public Integer getPageLimit() {
        return pageLimit;
    }

    /**
     * <p>
     * Setter for the field <code>pageLimit</code>.</p>
     *
     * @param pageLimit a {@link java.lang.Integer} object.
     */
    public void setPageLimit(Integer pageLimit) {
        this.pageLimit = pageLimit;
    }

}
