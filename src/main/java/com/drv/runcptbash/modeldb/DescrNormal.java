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
@Table(name = "descr_normal", catalog = "Pronostico", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DescrNormal.findAll", query = "SELECT d FROM DescrNormal d")
    , @NamedQuery(name = "DescrNormal.findByCodDescNor", query = "SELECT d FROM DescrNormal d WHERE d.codDescNor = :codDescNor")
    , @NamedQuery(name = "DescrNormal.findByIniYear", query = "SELECT d FROM DescrNormal d WHERE d.iniYear = :iniYear")
    , @NamedQuery(name = "DescrNormal.findByEndYear", query = "SELECT d FROM DescrNormal d WHERE d.endYear = :endYear")
    , @NamedQuery(name = "DescrNormal.findByMes", query = "SELECT d FROM DescrNormal d WHERE d.mes = :mes")
    , @NamedQuery(name = "DescrNormal.findByDatosDiarios", query = "SELECT d FROM DescrNormal d WHERE d.datosDiarios = :datosDiarios")
    , @NamedQuery(name = "DescrNormal.findByOrigen", query = "SELECT d FROM DescrNormal d WHERE d.origen = :origen")})
public class DescrNormal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cod_desc_nor")
    private Integer codDescNor;
    @Column(name = "ini_year")
    private Integer iniYear;
    @Column(name = "end_year")
    private Integer endYear;
    @Column(name = "mes")
    private Integer mes;
    @Column(name = "datos_diarios")
    private Integer datosDiarios;
    @Column(name = "origen")
    private String origen;
    @JoinColumn(name = "cod_est", referencedColumnName = "cod_est")
    @ManyToOne
    private PuntosPro codEst;
    @JoinColumn(name = "cod_var", referencedColumnName = "cod_var")
    @ManyToOne
    private Variables codVar;
    @OneToMany(mappedBy = "codDescNor")
    private Collection<NormalTrim> normalTrimCollection;
    @OneToMany(mappedBy = "codDescNor")
    private Collection<NormalDec> normalDecCollection;
    @OneToMany(mappedBy = "codDescNor")
    private Collection<NormalMes> normalMesCollection;

    public DescrNormal() {
    }

    public DescrNormal(Integer codDescNor) {
        this.codDescNor = codDescNor;
    }

    public Integer getCodDescNor() {
        return codDescNor;
    }

    public void setCodDescNor(Integer codDescNor) {
        this.codDescNor = codDescNor;
    }

    public Integer getIniYear() {
        return iniYear;
    }

    public void setIniYear(Integer iniYear) {
        this.iniYear = iniYear;
    }

    public Integer getEndYear() {
        return endYear;
    }

    public void setEndYear(Integer endYear) {
        this.endYear = endYear;
    }

    public Integer getMes() {
        return mes;
    }

    public void setMes(Integer mes) {
        this.mes = mes;
    }

    public Integer getDatosDiarios() {
        return datosDiarios;
    }

    public void setDatosDiarios(Integer datosDiarios) {
        this.datosDiarios = datosDiarios;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public PuntosPro getCodEst() {
        return codEst;
    }

    public void setCodEst(PuntosPro codEst) {
        this.codEst = codEst;
    }

    public Variables getCodVar() {
        return codVar;
    }

    public void setCodVar(Variables codVar) {
        this.codVar = codVar;
    }

    @XmlTransient
    public Collection<NormalTrim> getNormalTrimCollection() {
        return normalTrimCollection;
    }

    public void setNormalTrimCollection(Collection<NormalTrim> normalTrimCollection) {
        this.normalTrimCollection = normalTrimCollection;
    }

    @XmlTransient
    public Collection<NormalDec> getNormalDecCollection() {
        return normalDecCollection;
    }

    public void setNormalDecCollection(Collection<NormalDec> normalDecCollection) {
        this.normalDecCollection = normalDecCollection;
    }

    @XmlTransient
    public Collection<NormalMes> getNormalMesCollection() {
        return normalMesCollection;
    }

    public void setNormalMesCollection(Collection<NormalMes> normalMesCollection) {
        this.normalMesCollection = normalMesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codDescNor != null ? codDescNor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DescrNormal)) {
            return false;
        }
        DescrNormal other = (DescrNormal) object;
        if ((this.codDescNor == null && other.codDescNor != null) || (this.codDescNor != null && !this.codDescNor.equals(other.codDescNor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.drv.runcptbash.modeldb.DescrNormal[ codDescNor=" + codDescNor + " ]";
    }
    
}
