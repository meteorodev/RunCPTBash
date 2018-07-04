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
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Darwin Rosero Vaca <darwin11rv@gmail.com>
 */
@Entity
@Table(name = "dominios", catalog = "Pronostico", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dominios.findAll", query = "SELECT d FROM Dominios d")
    , @NamedQuery(name = "Dominios.findByCodDominio", query = "SELECT d FROM Dominios d WHERE d.codDominio = :codDominio")
    , @NamedQuery(name = "Dominios.findByLatNor", query = "SELECT d FROM Dominios d WHERE d.latNor = :latNor")
    , @NamedQuery(name = "Dominios.findByLatSur", query = "SELECT d FROM Dominios d WHERE d.latSur = :latSur")
    , @NamedQuery(name = "Dominios.findByLonOes", query = "SELECT d FROM Dominios d WHERE d.lonOes = :lonOes")
    , @NamedQuery(name = "Dominios.findByLonEst", query = "SELECT d FROM Dominios d WHERE d.lonEst = :lonEst")
    , @NamedQuery(name = "Dominios.findByAplicable", query = "SELECT d FROM Dominios d WHERE d.aplicable = :aplicable")})
public class Dominios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cod_dominio")
    private Integer codDominio;
    @Column(name = "lat_nor")
    private Integer latNor;
    @Column(name = "lat_sur")
    private Integer latSur;
    @Column(name = "lon_oes")
    private Integer lonOes;
    @Column(name = "lon_est")
    private Integer lonEst;
    @Column(name = "aplicable")
    private Integer aplicable;
    @JoinColumn(name = "cod_reg", referencedColumnName = "cod_reg")
    @ManyToOne(optional = false)
    private Regiones codReg;

    public Dominios() {
    }

    public Dominios(Integer codDominio) {
        this.codDominio = codDominio;
    }

    public Integer getCodDominio() {
        return codDominio;
    }

    public void setCodDominio(Integer codDominio) {
        this.codDominio = codDominio;
    }

    public Integer getLatNor() {
        return latNor;
    }

    public void setLatNor(Integer latNor) {
        this.latNor = latNor;
    }

    public Integer getLatSur() {
        return latSur;
    }

    public void setLatSur(Integer latSur) {
        this.latSur = latSur;
    }

    public Integer getLonOes() {
        return lonOes;
    }

    public void setLonOes(Integer lonOes) {
        this.lonOes = lonOes;
    }

    public Integer getLonEst() {
        return lonEst;
    }

    public void setLonEst(Integer lonEst) {
        this.lonEst = lonEst;
    }

    public Integer getAplicable() {
        return aplicable;
    }

    public void setAplicable(Integer aplicable) {
        this.aplicable = aplicable;
    }

    public Regiones getCodReg() {
        return codReg;
    }

    public void setCodReg(Regiones codReg) {
        this.codReg = codReg;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codDominio != null ? codDominio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dominios)) {
            return false;
        }
        Dominios other = (Dominios) object;
        if ((this.codDominio == null && other.codDominio != null) || (this.codDominio != null && !this.codDominio.equals(other.codDominio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.drv.runcptbash.modeldb.Dominios[ codDominio=" + codDominio + " ]";
    }
    
}
