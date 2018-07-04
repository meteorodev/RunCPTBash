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
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "periodo_pron", catalog = "Pronostico", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PeriodoPron.findAll", query = "SELECT p FROM PeriodoPron p")
    , @NamedQuery(name = "PeriodoPron.findByCodPer", query = "SELECT p FROM PeriodoPron p WHERE p.codPer = :codPer")
    , @NamedQuery(name = "PeriodoPron.findByDescripcion", query = "SELECT p FROM PeriodoPron p WHERE p.descripcion = :descripcion")
    , @NamedQuery(name = "PeriodoPron.findByEstado", query = "SELECT p FROM PeriodoPron p WHERE p.estado = :estado")})
public class PeriodoPron implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cod_per")
    private Integer codPer;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "estado")
    private Boolean estado;
    @OneToMany(mappedBy = "codPer")
    private Collection<PronosProb> pronosProbCollection;

    public PeriodoPron() {
    }

    public PeriodoPron(Integer codPer) {
        this.codPer = codPer;
    }

    public Integer getCodPer() {
        return codPer;
    }

    public void setCodPer(Integer codPer) {
        this.codPer = codPer;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
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
        hash += (codPer != null ? codPer.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PeriodoPron)) {
            return false;
        }
        PeriodoPron other = (PeriodoPron) object;
        if ((this.codPer == null && other.codPer != null) || (this.codPer != null && !this.codPer.equals(other.codPer))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.drv.runcptbash.modeldb.PeriodoPron[ codPer=" + codPer + " ]";
    }
    
}
