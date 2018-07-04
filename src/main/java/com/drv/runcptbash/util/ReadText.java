/*
 * DESCRIPCIÓN
 * 
 * ____________________________________________________________________________
 * Autor:   Darwin Rosero Vaca <darwin11rv@gmail.com>
 * Fecha:   12/10/2017
 * Versión: 1.0
 * Descrip: Creacion
 * ____________________________________________________________________________
 * Copyright © 2017 Darwin Rosero Vaca <darwin11rv@gmail.com> All rights
 */
package com.drv.runcptbash.util;

import com.drv.runcptbash.model.PronosticoModel;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Darwin Rosero Vaca <darwin11rv@gmail.com>
 */
public class ReadText {

    public ReadText() {

    }

    public String[] varPron = {"prcp", "temp"};

    public ArrayList<PronosticoModel> readCPTResult(String ruta) {
        // = new ArrayList();
        ArrayList<PronosticoModel> pronos=new ArrayList<>();
        Logger.getLogger(ReadText.class.getName()).log(Level.INFO,ruta);
        FileReader fr = null;
        try {
            File arc = new File(ruta);
            fr = new FileReader(arc);
            BufferedReader br = new BufferedReader(fr);
            String cadena = null;
            int yearPron = -1;
            int mesPron = -1;
            int lin = 1;
            String[] codigos = null;
            String[] sob = null;
            String[] nor = null;
            String[] baj = null;
            String[] lat = null;
            String[] lon = null;
            while ((cadena = br.readLine()) != null) {
                // System.out.println(lin+" "+cadena);
                // para saber cual es la variable
                switch (lin) {
                    case 3: // etiqueta del pronos
                        //System.out.println(lin + " " + cadena);
                        break;
                    case 4:// codigos de las estaciones
                        //System.out.println(lin + " " + cadena);
                        codigos = cadena.split("\t");
                        //System.out.println("codigos " + codigos.length);
                        break;
                    
                    case 5: //Y latitud 
                        lat= cadena.split("\t");
			break; 
                    case 6: //X longitud
			lon= cadena.split("\t");
                        break;
                     
                    case 7: // Bajo
                        //System.out.println(lin + " " + cadena);
                        baj = cadena.split("\t");
                        //System.out.println("sobre " + sob.length);
                        break;
                    case 12: // normal
                        //System.out.println(lin + " " + cadena);
                        nor = cadena.split("\t");
                        //System.out.println("normal " + nor.length);
                        break;
                    case 17: // SOBRE
                        //System.out.println(lin + " " + cadena);
                        sob = cadena.split("\t");
                        //System.out.println("bajo " + baj.length);
                        break;
                }

                lin++;
            }
            //Logger.getLogger(ReadText.class.getName()).log(Level.INFO, "numero de estaciones  {0} numero de sobre {1} numero de normal {2} numero de bajo {3}", new Object[]{codigos.length, sob.length, nor.length, baj.length});
            //make a pronos list 
            String[] fect = baj[0].split("-");
            //System.out.println("antes del error "+fect[0]);
            yearPron = Integer.parseInt((fect[0]));
            mesPron = Integer.parseInt(fect[1]);
            Logger.getLogger(ReadText.class.getName()).log(Level.INFO, "Pronostico para el mes de {0} del a\u00f1o de {1}", new Object[]{mesPron, yearPron});
            for (int i = 1; i < codigos.length; i++) {
                pronos.add(new PronosticoModel(yearPron, mesPron, codigos[i], Double.parseDouble(lat[i]),
                        Double.parseDouble(lon[i]), Double.parseDouble(sob[i]), Double.parseDouble(nor[i]), Double.parseDouble(baj[i])));
                //Logger.getLogger(ReadText.class.getName()).log(Level.INFO, " Estacion leida {0} sob = {1}: nor = {2}: baj = {3}", new Object[]{codigos[i], Double.parseDouble(sob[i]), nor[i], baj[i]});
            }
            br.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReadText.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ReadText.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {

                fr.close();
            } catch (IOException ex) {
                Logger.getLogger(ReadText.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return pronos;
    }

}
