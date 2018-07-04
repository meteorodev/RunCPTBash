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
@Table(name = "normal_dec", catalog = "Pronostico", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NormalDec.findAll", query = "SELECT n FROM NormalDec n")
    , @NamedQuery(name = "NormalDec.findByCodNorDec", query = "SELECT n FROM NormalDec n WHERE n.codNorDec = :codNorDec")
    , @NamedQuery(name = "NormalDec.findByDecada", query = "SELECT n FROM NormalDec n WHERE n.decada = :decada")
    , @NamedQuery(name = "NormalDec.findByValor", query = "SELECT n FROM NormalDec n WHERE n.valor = :valor")})
public class NormalDec implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cod_nor_dec")
    private Integer codNorDec;
    @Column(name = "decada")
    private Integer decada;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor")
    private BigDecimal valor;
    @JoinColumn(name = "cod_desc_nor", referencedColumnName = "cod_desc_nor")
    @ManyToOne
    private DescrNormal codDescNor;

    public NormalDec() {
    }

    public NormalDec(Integer codNorDec) {
        this.codNorDec = codNorDec;
    }

    public Integer getCodNorDec() {
        return codNorDec;
    }

    public void setCodNorDec(Integer codNorDec) {
        this.codNorDec = codNorDec;
    }

    public Integer getDecada() {
        return decada;
    }

    public void setDecada(Integer decada) {
        this.decada = decada;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codNorDec != null ? codNorDec.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NormalDec)) {
            return false;
        }
        NormalDec other = (NormalDec) object;
        if ((this.codNorDec == null && other.codNorDec != null) || (this.codNorDec != null && !this.codNorDec.equals(other.codNorDec))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.drv.runcptbash.modeldb.NormalDec[ codNorDec=" + codNorDec + " ]";
    }
    
}
