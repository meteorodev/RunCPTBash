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
@Table(name = "puntos_pro", catalog = "Pronostico", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PuntosPro.findAll", query = "SELECT p FROM PuntosPro p")
    , @NamedQuery(name = "PuntosPro.findByCodEst", query = "SELECT p FROM PuntosPro p WHERE p.codEst = :codEst")
    , @NamedQuery(name = "PuntosPro.findByLatitud", query = "SELECT p FROM PuntosPro p WHERE p.latitud = :latitud")
    , @NamedQuery(name = "PuntosPro.findByLongitud", query = "SELECT p FROM PuntosPro p WHERE p.longitud = :longitud")
    , @NamedQuery(name = "PuntosPro.findByAltitud", query = "SELECT p FROM PuntosPro p WHERE p.altitud = :altitud")
    , @NamedQuery(name = "PuntosPro.findBySistemaCoordenadas", query = "SELECT p FROM PuntosPro p WHERE p.sistemaCoordenadas = :sistemaCoordenadas")
    , @NamedQuery(name = "PuntosPro.findByEnpronos", query = "SELECT p FROM PuntosPro p WHERE p.enpronos = :enpronos")
    , @NamedQuery(name = "PuntosPro.findByNombreEst", query = "SELECT p FROM PuntosPro p WHERE p.nombreEst = :nombreEst")})
public class PuntosPro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cod_est")
    private String codEst;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "latitud")
    private BigDecimal latitud;
    @Column(name = "longitud")
    private BigDecimal longitud;
    @Column(name = "altitud")
    private BigDecimal altitud;
    @Column(name = "sistema_coordenadas")
    private String sistemaCoordenadas;
    @Column(name = "enpronos")
    private Boolean enpronos;
    @Column(name = "nombre_est")
    private String nombreEst;
    @OneToMany(mappedBy = "codEst")
    private Collection<DescrNormal> descrNormalCollection;
    @OneToMany(mappedBy = "codEst")
    private Collection<PronosProb> pronosProbCollection;

    public PuntosPro() {
    }

    public PuntosPro(String codEst) {
        this.codEst = codEst;
    }

    public String getCodEst() {
        return codEst;
    }

    public void setCodEst(String codEst) {
        this.codEst = codEst;
    }

    public BigDecimal getLatitud() {
        return latitud;
    }

    public void setLatitud(BigDecimal latitud) {
        this.latitud = latitud;
    }

    public BigDecimal getLongitud() {
        return longitud;
    }

    public void setLongitud(BigDecimal longitud) {
        this.longitud = longitud;
    }

    public BigDecimal getAltitud() {
        return altitud;
    }

    public void setAltitud(BigDecimal altitud) {
        this.altitud = altitud;
    }

    public String getSistemaCoordenadas() {
        return sistemaCoordenadas;
    }

    public void setSistemaCoordenadas(String sistemaCoordenadas) {
        this.sistemaCoordenadas = sistemaCoordenadas;
    }

    public Boolean getEnpronos() {
        return enpronos;
    }

    public void setEnpronos(Boolean enpronos) {
        this.enpronos = enpronos;
    }

    public String getNombreEst() {
        return nombreEst;
    }

    public void setNombreEst(String nombreEst) {
        this.nombreEst = nombreEst;
    }

    @XmlTransient
    public Collection<DescrNormal> getDescrNormalCollection() {
        return descrNormalCollection;
    }

    public void setDescrNormalCollection(Collection<DescrNormal> descrNormalCollection) {
        this.descrNormalCollection = descrNormalCollection;
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
        hash += (codEst != null ? codEst.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PuntosPro)) {
            return false;
        }
        PuntosPro other = (PuntosPro) object;
        if ((this.codEst == null && other.codEst != null) || (this.codEst != null && !this.codEst.equals(other.codEst))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.drv.runcptbash.modeldb.PuntosPro[ codEst=" + codEst + " ]";
    }
    
}
