/*
 * DESCRIPCIÓN
 * 
 * ____________________________________________________________________________
 * Autor:   Darwin Rosero Vaca <darwin11rv@gmail.com>
 * Fecha:   13/10/2017
 * Versión: 1.0
 * Descrip: Creacion
 * ____________________________________________________________________________
 * Copyright © 2017 Darwin Rosero Vaca <darwin11rv@gmail.com> All rights
 */
package com.drv.runcptbash.model;

/**
 *
 * @author Darwin Rosero Vaca <darwin11rv@gmail.com>
 */
public class PronosticoModel {
    private int año;
    private int mes;
    private String codEs;
    private double latit;
    private double longi;
    private double sobre;
    private double normal;
    private double bajo;

    public PronosticoModel() {
    }

    public PronosticoModel(int año, int mes, String codEs, double latit, double longi, double sobre, double normal, double bajo) {
        this.año = año;
        this.mes = mes;
        this.codEs = codEs;
        this.latit = latit;
        this.longi = longi;
        this.sobre = sobre;
        this.normal = normal;
        this.bajo = bajo;
    }

    
    
    /**
     * @return the codEs
     */
    public String getCodEs() {
        return codEs;
    }

    /**
     * @param codEs the codEs to set
     */
    public void setCodEs(String codEs) {
        this.codEs = codEs;
    }
    

    /**
     * @return the sobre
     */
    public double getSobre() {
        return sobre;
    }

    /**
     * @param sobre the sobre to set
     */
    public void setSobre(double sobre) {
        this.sobre = sobre;
    }

    /**
     * @return the normal
     */
    public double getNormal() {
        return normal;
    }

    /**
     * @param normal the normal to set
     */
    public void setNormal(double normal) {
        this.normal = normal;
    }

    /**
     * @return the bajo
     */
    public double getBajo() {
        return bajo;
    }

    /**
     * @param bajo the bajo to set
     */
    public void setBajo(double bajo) {
        this.bajo = bajo;
    }

    /**
     * @return the latit
     */
    public double getLatit() {
        return latit;
    }

    /**
     * @param latit the latit to set
     */
    public void setLatit(double latit) {
        this.latit = latit;
    }

    /**
     * @return the longi
     */
    public double getLongi() {
        return longi;
    }

    /**
     * @param longi the longi to set
     */
    public void setLongi(double longi) {
        this.longi = longi;
    }

    /**
     * @return the año
     */
    public int getAño() {
        return año;
    }

    /**
     * @param año the año to set
     */
    public void setAño(int año) {
        this.año = año;
    }

    /**
     * @return the mes
     */
    public int getMes() {
        return mes;
    }

    /**
     * @param mes the mes to set
     */
    public void setMes(int mes) {
        this.mes = mes;
    }
    
}
