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
@Table(name = "pronos_prob", catalog = "Pronostico", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PronosProb.findAll", query = "SELECT p FROM PronosProb p")
    , @NamedQuery(name = "PronosProb.findByMesPro", query = "SELECT p FROM PronosProb p WHERE p.mesPro = :mesPro")
    , @NamedQuery(name = "PronosProb.findByYearPro", query = "SELECT p FROM PronosProb p WHERE p.yearPro = :yearPro")
    , @NamedQuery(name = "PronosProb.findByCodPp", query = "SELECT p FROM PronosProb p WHERE p.codPp = :codPp")
    , @NamedQuery(name = "PronosProb.findByValBajo", query = "SELECT p FROM PronosProb p WHERE p.valBajo = :valBajo")
    , @NamedQuery(name = "PronosProb.findByValNormal", query = "SELECT p FROM PronosProb p WHERE p.valNormal = :valNormal")
    , @NamedQuery(name = "PronosProb.findByValSobre", query = "SELECT p FROM PronosProb p WHERE p.valSobre = :valSobre")})
public class PronosProb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "mes_pro")
    private Integer mesPro;
    @Column(name = "year_pro")
    private Integer yearPro;
    @Id
    @Basic(optional = false)
    @Column(name = "cod_pp")
    private Integer codPp;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "val_bajo")
    private BigDecimal valBajo;
    @Column(name = "val_normal")
    private BigDecimal valNormal;
    @Column(name = "val_sobre")
    private BigDecimal valSobre;
    @JoinColumn(name = "cod_n_m", referencedColumnName = "cod_n_m")
    @ManyToOne
    private NormalMes codNM;
    @JoinColumn(name = "cod_per", referencedColumnName = "cod_per")
    @ManyToOne
    private PeriodoPron codPer;
    @JoinColumn(name = "cod_est", referencedColumnName = "cod_est")
    @ManyToOne
    private PuntosPro codEst;
    @JoinColumn(name = "cod_reg", referencedColumnName = "cod_var")
    @ManyToOne
    private Variables codReg;

    public PronosProb() {
    }

    public PronosProb(Integer codPp) {
        this.codPp = codPp;
    }

    public Integer getMesPro() {
        return mesPro;
    }

    public void setMesPro(Integer mesPro) {
        this.mesPro = mesPro;
    }

    public Integer getYearPro() {
        return yearPro;
    }

    public void setYearPro(Integer yearPro) {
        this.yearPro = yearPro;
    }

    public Integer getCodPp() {
        return codPp;
    }

    public void setCodPp(Integer codPp) {
        this.codPp = codPp;
    }

    public BigDecimal getValBajo() {
        return valBajo;
    }

    public void setValBajo(BigDecimal valBajo) {
        this.valBajo = valBajo;
    }

    public BigDecimal getValNormal() {
        return valNormal;
    }

    public void setValNormal(BigDecimal valNormal) {
        this.valNormal = valNormal;
    }

    public BigDecimal getValSobre() {
        return valSobre;
    }

    public void setValSobre(BigDecimal valSobre) {
        this.valSobre = valSobre;
    }

    public NormalMes getCodNM() {
        return codNM;
    }

    public void setCodNM(NormalMes codNM) {
        this.codNM = codNM;
    }

    public PeriodoPron getCodPer() {
        return codPer;
    }

    public void setCodPer(PeriodoPron codPer) {
        this.codPer = codPer;
    }

    public PuntosPro getCodEst() {
        return codEst;
    }

    public void setCodEst(PuntosPro codEst) {
        this.codEst = codEst;
    }

    public Variables getCodReg() {
        return codReg;
    }

    public void setCodReg(Variables codReg) {
        this.codReg = codReg;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codPp != null ? codPp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PronosProb)) {
            return false;
        }
        PronosProb other = (PronosProb) object;
        if ((this.codPp == null && other.codPp != null) || (this.codPp != null && !this.codPp.equals(other.codPp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.drv.runcptbash.modeldb.PronosProb[ codPp=" + codPp + " ]";
    }
    
}
