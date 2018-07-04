/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.drv.runcptbash.model;

/**
 *
 * @author darwin
 */
public class RegionDominio {
    private String variable;
    private String nombreRegion;
    private int lat_nor;
    private int lat_sur;
    private int lon_oes;
    private int lon_est;
    private String predictor;
    private int es_lat_nor;
    private int es_lat_sur;
    private int es_lon_oes;
    private int es_lon_est;
    private int maxModos=10;
    
    public RegionDominio(String variable, String nombreRegion,int es_lat_nor, int es_lat_sur, int es_lon_oes, int es_lon_est, String predictor, 
            int lat_nor, int lat_sur, int lon_oes, int lon_est,int maxModos) {
        this.variable = variable;
        this.nombreRegion = nombreRegion;
        this.lat_nor = lat_nor;
        this.lat_sur = lat_sur;
        this.lon_oes = lon_oes;
        this.lon_est = lon_est;
        this.predictor = predictor;
        this.es_lat_nor = es_lat_nor;
        this.es_lat_sur = es_lat_sur;
        this.es_lon_oes = es_lon_oes;
        this.es_lon_est = es_lon_est;
        this.maxModos=maxModos;
    }
    

    public RegionDominio(String variable,String nombreRegion,int es_lat_nor, int es_lat_sur, int es_lon_oes, int es_lon_est,  String predictor, 
            int lat_nor, int lat_sur, int lon_oes, int lon_est) {
        this.variable = variable;
        this.nombreRegion = nombreRegion;
        this.lat_nor = lat_nor;
        this.lat_sur = lat_sur;
        this.lon_oes = lon_oes;
        this.lon_est = lon_est;
        this.predictor = predictor;
        this.es_lat_nor = es_lat_nor;
        this.es_lat_sur = es_lat_sur;
        this.es_lon_oes = es_lon_oes;
        this.es_lon_est = es_lon_est;
    }
    

    public RegionDominio() {
    }
    /**
     * @return the nombreRegion
     */
    public String getNombreRegion() {
        return nombreRegion;
    }

    /**
     * @param nombreRegion the nombreRegion to set
     */
    public void setNombreRegion(String nombreRegion) {
        this.nombreRegion = nombreRegion;
    }

    /**
     * @return the lat_nor
     */
    public int getLat_nor() {
        return lat_nor;
    }

    /**
     * @param lat_nor the lat_nor to set
     */
    public void setLat_nor(int lat_nor) {
        this.lat_nor = lat_nor;
    }

    /**
     * @return the lat_sur
     */
    public int getLat_sur() {
        return lat_sur;
    }

    /**
     * @param lat_sur the lat_sur to set
     */
    public void setLat_sur(int lat_sur) {
        this.lat_sur = lat_sur;
    }

    /**
     * @return the lon_oes
     */
    public int getLon_oes() {
        return lon_oes;
    }

    /**
     * @param lon_oes the lon_oes to set
     */
    public void setLon_oes(int lon_oes) {
        this.lon_oes = lon_oes;
    }

    /**
     * @return the lon_est
     */
    public int getLon_est() {
        return lon_est;
    }

    /**
     * @param lon_est the lon_est to set
     */
    public void setLon_est(int lon_est) {
        this.lon_est = lon_est;
    }

    /**
     * @return the variable
     */
    public String getVariable() {
        return variable;
    }

    /**
     * @param variable the variable to set
     */
    public void setVariable(String variable) {
        this.variable = variable;
    }

    /**
     * @return the predictor
     */
    public String getPredictor() {
        return predictor;
    }

    /**
     * @param predictor the predictor to set
     */
    public void setPredictor(String predictor) {
        this.predictor = predictor;
    }

    /**
     * @return the es_lat_nor
     */
    public int getEs_lat_nor() {
        return es_lat_nor;
    }

    /**
     * @param es_lat_nor the es_lat_nor to set
     */
    public void setEs_lat_nor(int es_lat_nor) {
        this.es_lat_nor = es_lat_nor;
    }

    /**
     * @return the es_lat_sur
     */
    public int getEs_lat_sur() {
        return es_lat_sur;
    }

    /**
     * @param es_lat_sur the es_lat_sur to set
     */
    public void setEs_lat_sur(int es_lat_sur) {
        this.es_lat_sur = es_lat_sur;
    }

    /**
     * @return the es_lon_oes
     */
    public int getEs_lon_oes() {
        return es_lon_oes;
    }

    /**
     * @param es_lon_oes the es_lon_oes to set
     */
    public void setEs_lon_oes(int es_lon_oes) {
        this.es_lon_oes = es_lon_oes;
    }

    /**
     * @return the es_lon_est
     */
    public int getEs_lon_est() {
        return es_lon_est;
    }

    /**
     * @param es_lon_est the es_lon_est to set
     */
    public void setEs_lon_est(int es_lon_est) {
        this.es_lon_est = es_lon_est;
    }


    /**
     * @return the maxModos
     */
    public int getMaxModos() {
        return maxModos;
    }

    /**
     * @param maxModos the maxModos to set
     */
    public void setMaxModos(int maxModos) {
        this.maxModos = maxModos;
    }
    
    @Override
    public String toString() {
        //rd.add(new RegionDominio("RR", "COSTA_I", 3, -5, -92, -78, "AG500", 0, -4, -81, -79));
        return getVariable() + "\t" + getNombreRegion() + "\t"+getEs_lat_nor()+"\t"+getEs_lat_sur()+"\t"+getEs_lon_oes()+"\t"
                +getEs_lon_est()+"\t"+ getPredictor()+"\t"+getLat_nor()+"\t"+getLat_sur()+"\t"+getLon_oes()+"\t"+getLon_est()+"\t"+getMaxModos(); 
    }
    
    
    
}
