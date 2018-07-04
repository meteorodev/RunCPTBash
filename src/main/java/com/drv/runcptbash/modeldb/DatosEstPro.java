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
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Darwin Rosero Vaca <darwin11rv@gmail.com>
 */
@Entity
@Table(name = "datos_est_pro", catalog = "Pronostico", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DatosEstPro.findAll", query = "SELECT d FROM DatosEstPro d")
    , @NamedQuery(name = "DatosEstPro.findByCodDatEst", query = "SELECT d FROM DatosEstPro d WHERE d.codDatEst = :codDatEst")
    , @NamedQuery(name = "DatosEstPro.findByCodPronProb", query = "SELECT d FROM DatosEstPro d WHERE d.codPronProb = :codPronProb")
    , @NamedQuery(name = "DatosEstPro.findByXMax", query = "SELECT d FROM DatosEstPro d WHERE d.xMax = :xMax")
    , @NamedQuery(name = "DatosEstPro.findByXMin", query = "SELECT d FROM DatosEstPro d WHERE d.xMin = :xMin")
    , @NamedQuery(name = "DatosEstPro.findByYMax", query = "SELECT d FROM DatosEstPro d WHERE d.yMax = :yMax")
    , @NamedQuery(name = "DatosEstPro.findByYMin", query = "SELECT d FROM DatosEstPro d WHERE d.yMin = :yMin")
    , @NamedQuery(name = "DatosEstPro.findByGoodIn", query = "SELECT d FROM DatosEstPro d WHERE d.goodIn = :goodIn")
    , @NamedQuery(name = "DatosEstPro.findByCorrel", query = "SELECT d FROM DatosEstPro d WHERE d.correl = :correl")})
public class DatosEstPro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cod_dat_est")
    private Integer codDatEst;
    @Column(name = "cod_pron_prob")
    private Integer codPronProb;
    @Column(name = "x_max")
    private Short xMax;
    @Column(name = "x_min")
    private Short xMin;
    @Column(name = "y_max")
    private Short yMax;
    @Column(name = "y_min")
    private Short yMin;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "good_in")
    private BigDecimal goodIn;
    @Column(name = "correl")
    private BigDecimal correl;

    public DatosEstPro() {
    }

    public DatosEstPro(Integer codDatEst) {
        this.codDatEst = codDatEst;
    }

    public Integer getCodDatEst() {
        return codDatEst;
    }

    public void setCodDatEst(Integer codDatEst) {
        this.codDatEst = codDatEst;
    }

    public Integer getCodPronProb() {
        return codPronProb;
    }

    public void setCodPronProb(Integer codPronProb) {
        this.codPronProb = codPronProb;
    }

    public Short getXMax() {
        return xMax;
    }

    public void setXMax(Short xMax) {
        this.xMax = xMax;
    }

    public Short getXMin() {
        return xMin;
    }

    public void setXMin(Short xMin) {
        this.xMin = xMin;
    }

    public Short getYMax() {
        return yMax;
    }

    public void setYMax(Short yMax) {
        this.yMax = yMax;
    }

    public Short getYMin() {
        return yMin;
    }

    public void setYMin(Short yMin) {
        this.yMin = yMin;
    }

    public BigDecimal getGoodIn() {
        return goodIn;
    }

    public void setGoodIn(BigDecimal goodIn) {
        this.goodIn = goodIn;
    }

    public BigDecimal getCorrel() {
        return correl;
    }

    public void setCorrel(BigDecimal correl) {
        this.correl = correl;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codDatEst != null ? codDatEst.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DatosEstPro)) {
            return false;
        }
        DatosEstPro other = (DatosEstPro) object;
        if ((this.codDatEst == null && other.codDatEst != null) || (this.codDatEst != null && !this.codDatEst.equals(other.codDatEst))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.drv.runcptbash.modeldb.DatosEstPro[ codDatEst=" + codDatEst + " ]";
    }
    
}
