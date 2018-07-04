/*
 * DESCRIPCIÓN
 * 
 * ____________________________________________________________________________
 * Autor:   Darwin Rosero Vaca <darwin11rv@gmail.com>
 * Fecha:   05/02/2018
 * Versión: 1.0
 * Descrip: Creacion
 * ____________________________________________________________________________
 * Copyright © 2018 Darwin Rosero Vaca <darwin11rv@gmail.com> All rights
 */
package com.drv.runcptbash.modeldb;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Darwin Rosero Vaca <darwin11rv@gmail.com>
 */
@Entity
@Table(name = "normal_mes", catalog = "Pronostico", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NormalMes.findAll", query = "SELECT n FROM NormalMes n")
    , @NamedQuery(name = "NormalMes.findByCodNM", query = "SELECT n FROM NormalMes n WHERE n.codNM = :codNM")
    , @NamedQuery(name = "NormalMes.findByValor", query = "SELECT n FROM NormalMes n WHERE n.valor = :valor")})
public class NormalMes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cod_n_m")
    private Integer codNM;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor")
    private BigDecimal valor;
    @JoinColumn(name = "cod_desc_nor", referencedColumnName = "cod_desc_nor")
    @ManyToOne
    private DescrNormal codDescNor;
    @OneToMany(mappedBy = "codNM")
    private Collection<PronosProb> pronosProbCollection;

    public NormalMes() {
    }

    public NormalMes(Integer codNM) {
        this.codNM = codNM;
    }

    public Integer getCodNM() {
        return codNM;
    }

    public void setCodNM(Integer codNM) {
        this.codNM = codNM;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public DescrNormal getCodDescNor() {
        return codDescNor;
    }

    public void setCodDescNor(DescrNormal codDescNor) {
        this.codDescNor = codDescNor;
    }

    @XmlTransient
    public Collection<PronosProb> getPronosProbCollection() {
        return pronosProbCollection;
    }

    public void setPronosProbCollection(Collection<PronosProb> pronosProbCollection) {
        this.pronosProbCollection = pronosProbCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codNM != null ? codNM.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NormalMes)) {
            return false;
        }
        NormalMes other = (NormalMes) object;
        if ((this.codNM == null && other.codNM != null) || (this.codNM != null && !this.codNM.equals(other.codNM))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.drv.runcptbash.modeldb.NormalMes[ codNM=" + codNM + " ]";
    }
    
}
