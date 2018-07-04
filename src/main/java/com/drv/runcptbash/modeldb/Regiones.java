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
import javax.persistence.CascadeType;
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
@Table(name = "regiones", catalog = "Pronostico", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Regiones.findAll", query = "SELECT r FROM Regiones r")
    , @NamedQuery(name = "Regiones.findByCodReg", query = "SELECT r FROM Regiones r WHERE r.codReg = :codReg")
    , @NamedQuery(name = "Regiones.findByNombreReg", query = "SELECT r FROM Regiones r WHERE r.nombreReg = :nombreReg")
    , @NamedQuery(name = "Regiones.findByDescripReg", query = "SELECT r FROM Regiones r WHERE r.descripReg = :descripReg")})
public class Regiones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cod_reg")
    private Integer codReg;
    @Column(name = "nombre_reg")
    private String nombreReg;
    @Column(name = "descrip_reg")
    private String descripReg;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codReg")
    private Collection<Dominios> dominiosCollection;
    @OneToMany(mappedBy = "codReg")
    private Collection<Predictores> predictoresCollection;
    @JoinColumn(name = "cod_var", referencedColumnName = "cod_var")
    @ManyToOne
    private Variables codVar;

    public Regiones() {
    }

    public Regiones(Integer codReg) {
        this.codReg = codReg;
    }

    public Integer getCodReg() {
        return codReg;
    }

    public void setCodReg(Integer codReg) {
        this.codReg = codReg;
    }

    public String getNombreReg() {
        return nombreReg;
    }

    public void setNombreReg(String nombreReg) {
        this.nombreReg = nombreReg;
    }

    public String getDescripReg() {
        return descripReg;
    }

    public void setDescripReg(String descripReg) {
        this.descripReg = descripReg;
    }

    @XmlTransient
    public Collection<Dominios> getDominiosCollection() {
        return dominiosCollection;
    }

    public void setDominiosCollection(Collection<Dominios> dominiosCollection) {
        this.dominiosCollection = dominiosCollection;
    }

    @XmlTransient
    public Collection<Predictores> getPredictoresCollection() {
        return predictoresCollection;
    }

    public void setPredictoresCollection(Collection<Predictores> predictoresCollection) {
        this.predictoresCollection = predictoresCollection;
    }

    public Variables getCodVar() {
        return codVar;
    }

    public void setCodVar(Variables codVar) {
        this.codVar = codVar;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codReg != null ? codReg.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Regiones)) {
            return false;
        }
        Regiones other = (Regiones) object;
        if ((this.codReg == null && other.codReg != null) || (this.codReg != null && !this.codReg.equals(other.codReg))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.drv.runcptbash.modeldb.Regiones[ codReg=" + codReg + " ]";
    }
    
}
