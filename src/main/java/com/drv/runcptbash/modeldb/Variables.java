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
@Table(name = "variables", catalog = "Pronostico", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Variables.findAll", query = "SELECT v FROM Variables v")
    , @NamedQuery(name = "Variables.findByCodVar", query = "SELECT v FROM Variables v WHERE v.codVar = :codVar")
    , @NamedQuery(name = "Variables.findByNombVar", query = "SELECT v FROM Variables v WHERE v.nombVar = :nombVar")
    , @NamedQuery(name = "Variables.findByDescripVar", query = "SELECT v FROM Variables v WHERE v.descripVar = :descripVar")})
public class Variables implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cod_var")
    private Integer codVar;
    @Column(name = "nomb_var")
    private String nombVar;
    @Column(name = "descrip_var")
    private String descripVar;
    @OneToMany(mappedBy = "codVar")
    private Collection<DescrNormal> descrNormalCollection;
    @OneToMany(mappedBy = "codVar")
    private Collection<Regiones> regionesCollection;
    @OneToMany(mappedBy = "codReg")
    private Collection<PronosProb> pronosProbCollection;

    public Variables() {
    }

    public Variables(Integer codVar) {
        this.codVar = codVar;
    }

    public Integer getCodVar() {
        return codVar;
    }

    public void setCodVar(Integer codVar) {
        this.codVar = codVar;
    }

    public String getNombVar() {
        return nombVar;
    }

    public void setNombVar(String nombVar) {
        this.nombVar = nombVar;
    }

    public String getDescripVar() {
        return descripVar;
    }

    public void setDescripVar(String descripVar) {
        this.descripVar = descripVar;
    }

    @XmlTransient
    public Collection<DescrNormal> getDescrNormalCollection() {
        return descrNormalCollection;
    }

    public void setDescrNormalCollection(Collection<DescrNormal> descrNormalCollection) {
        this.descrNormalCollection = descrNormalCollection;
    }

    @XmlTransient
    public Collection<Regiones> getRegionesCollection() {
        return regionesCollection;
    }

    public void setRegionesCollection(Collection<Regiones> regionesCollection) {
        this.regionesCollection = regionesCollection;
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
        hash += (codVar != null ? codVar.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Variables)) {
            return false;
        }
        Variables other = (Variables) object;
        if ((this.codVar == null && other.codVar != null) || (this.codVar != null && !this.codVar.equals(other.codVar))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.drv.runcptbash.modeldb.Variables[ codVar=" + codVar + " ]";
    }
    
}
