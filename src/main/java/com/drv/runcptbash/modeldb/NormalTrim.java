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
@Table(name = "normal_trim", catalog = "Pronostico", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NormalTrim.findAll", query = "SELECT n FROM NormalTrim n")
    , @NamedQuery(name = "NormalTrim.findByCodNT", query = "SELECT n FROM NormalTrim n WHERE n.codNT = :codNT")
    , @NamedQuery(name = "NormalTrim.findByEndMes", query = "SELECT n FROM NormalTrim n WHERE n.endMes = :endMes")
    , @NamedQuery(name = "NormalTrim.findByAbrev", query = "SELECT n FROM NormalTrim n WHERE n.abrev = :abrev")})
public class NormalTrim implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cod_n_t")
    private Integer codNT;
    @Column(name = "end_mes")
    private Integer endMes;
    @Column(name = "abrev")
    private String abrev;
    @JoinColumn(name = "cod_desc_nor", referencedColumnName = "cod_desc_nor")
    @ManyToOne
    private DescrNormal codDescNor;

    public NormalTrim() {
    }

    public NormalTrim(Integer codNT) {
        this.codNT = codNT;
    }

    public Integer getCodNT() {
        return codNT;
    }

    public void setCodNT(Integer codNT) {
        this.codNT = codNT;
    }

    public Integer getEndMes() {
        return endMes;
    }

    public void setEndMes(Integer endMes) {
        this.endMes = endMes;
    }

    public String getAbrev() {
        return abrev;
    }

    public void setAbrev(String abrev) {
        this.abrev = abrev;
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
        hash += (codNT != null ? codNT.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NormalTrim)) {
            return false;
        }
        NormalTrim other = (NormalTrim) object;
        if ((this.codNT == null && other.codNT != null) || (this.codNT != null && !this.codNT.equals(other.codNT))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.drv.runcptbash.modeldb.NormalTrim[ codNT=" + codNT + " ]";
    }
    
}
