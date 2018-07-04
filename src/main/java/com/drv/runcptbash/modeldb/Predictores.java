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
@Table(name = "predictores", catalog = "Pronostico", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Predictores.findAll", query = "SELECT p FROM Predictores p")
    , @NamedQuery(name = "Predictores.findByCodPredict", query = "SELECT p FROM Predictores p WHERE p.codPredict = :codPredict")
    , @NamedQuery(name = "Predictores.findByNombre", query = "SELECT p FROM Predictores p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Predictores.findByDescripcion", query = "SELECT p FROM Predictores p WHERE p.descripcion = :descripcion")})
public class Predictores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cod_predict")
    private Integer codPredict;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;
    @JoinColumn(name = "cod_reg", referencedColumnName = "cod_reg")
    @ManyToOne
    private Regiones codReg;

    public Predictores() {
    }

    public Predictores(Integer codPredict) {
        this.codPredict = codPredict;
    }

    public Integer getCodPredict() {
        return codPredict;
    }

    public void setCodPredict(Integer codPredict) {
        this.codPredict = codPredict;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
        hash += (codPredict != null ? codPredict.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Predictores)) {
            return false;
        }
        Predictores other = (Predictores) object;
        if ((this.codPredict == null && other.codPredict != null) || (this.codPredict != null && !this.codPredict.equals(other.codPredict))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.drv.runcptbash.modeldb.Predictores[ codPredict=" + codPredict + " ]";
    }
    
}
