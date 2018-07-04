/*
 * DESCRIPCIÓN
 * 
 * ____________________________________________________________________________
 * Autor:   Darwin Rosero Vaca <darwin11rv@gmail.com>
 * Fecha:   13/11/2017
 * Versión: 1.0
 * Descrip: Creacion
 * ____________________________________________________________________________
 * Copyright © 2017 Darwin Rosero Vaca <darwin11rv@gmail.com> All rights
 */
package com.drv.runcptbash.util;

import com.drv.runcptbash.model.PronosticoModel;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Darwin Rosero Vaca <darwin11rv@gmail.com>
 */
public class MakeCSV {

    public MakeCSV() {

    }

    public void makeCSVResult(String ruta, ArrayList<PronosticoModel> pro, String variable, int año, int mes) {
        try {
            FileWriter fr = new FileWriter(ruta);
            fr.append("Código;Latitud;Longitud;Sobre;Normal;Bajo;Pron;Grupo\n");
            for (PronosticoModel pm : pro) {
                double s = pm.getSobre();
                double n = pm.getNormal();
                double b = pm.getBajo();
                double mayor = -10;
                int gr = -1;
                if (s > 0 && n > 0 && b > 0) {
                    if (s > n && s > b) {
                        mayor = s;
                        gr=creaGrupo(mayor, 6);
                    } else {
                        if (n > s && n > b) {
                            mayor = n;
                            gr=creaGrupo(mayor, 3);
                        } else {
                            if (b > n && b > s) {
                                mayor = b;
                                gr=creaGrupo(mayor, 0);
                            } else {
                                mayor = n;
                                gr=4;
                            }
                        }
                    }
                    fr.append(pm.getCodEs()+";"+pm.getLatit()+";"+pm.getLongi()+";"+s+";"+n+";"+b+";"+mayor+";"+gr+"\n");
                }
                
                
            }
            fr.close();
        } catch (IOException ex) {
            Logger.getLogger(MakeCSV.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public int creaGrupo(double mayor, int inicio) {
        /* valores inicio
        0 bajo
        3 normal
        6 sobre
         */
        int gr= -1;
        if (mayor < 60) {
            gr = inicio+1;
        }
        if (mayor >= 60 && mayor < 80) {
            gr = inicio+2;
        }
        if (mayor >= 80) {
            gr = inicio+3;
        }
        return gr;
    }

}
