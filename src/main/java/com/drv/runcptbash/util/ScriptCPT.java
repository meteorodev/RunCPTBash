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
package com.drv.runcptbash.util;

import com.drv.runcptbash.model.RegionDominio;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

/**
 *
 * @author Darwin Rosero Vaca <darwin11rv@gmail.com>
 */
public class ScriptCPT {

    String mes[] = {"ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO", "JULIO",
        "AGOSTO", "SEPTIEMBRE", "OCTUBRE", "NOVIEMBRE", "DICIEMBRE"};
    String mesNum[] = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
    String trim[] = {"EFM", "FMA", "MAM", "AMJ", "MJJ", "JJA", "JAS", "ASO", "SON", "OND", "NDE", "DEF"};

    public void runCPT(String rutaExe, String rutaCorrida, ArrayList<RegionDominio> dominios, int año, int index, int periodo, double mingi) {
        String xInDa;
        String yInDa;
        String per = "";
        String regionN = "";
        String goodIndex;
        String persCoor;
        String sperCoor;
        String rocBel;
        String rocAvo;
        String probFore;
        String odds;
        String getGI;
        String badGI;
        String errorLog;
        String dominUse;
        switch (periodo) {
            case 1://pronostico mensual
                per = mes[index];

                break;
            case 2://pronostoco trimestral
                per = trim[index];
                break;
            default:
                break;
        }
        //logs de los Goodness index
        FileWriter gisFw;
        PrintWriter gisPw;
        //logs de los Goodness index nu usados (malos)
        FileWriter badGisFw;
        PrintWriter badGisPw;
        //logs de los DOMINIOS EJECUTADOS
        FileWriter errorsFw;
        PrintWriter errorsPw;
        //impresion de DOMINIOS EJECUTADOS
        FileWriter domFw;
        PrintWriter domPw;
        RegionDominio domTemp= null;        
        String ructemp=rutaCorrida; // ruta temnporal que sera usada cuando no se encuentre un buen indice
        
        //contruye las rutas de salidas de los archivos
        
        rutaCorrida = rutaCorrida + "" + año + "/" + mesNum[index] + "_PronosCPT_" + trim[index] + "_" + año + "/";
        System.out.println("Ruta del ejecutable :" + rutaExe);
        System.out.println("Ruta de las corridas :" + rutaCorrida);
        System.out.println("Regiones cargadas.. ");
        System.out.println("____________________________________________________");
        int conteo = 1;

        /*maximo indice de bondad encontrado*/
        double maxNoGI = -10;
        String l;
        try {
            getGI = rutaCorrida + per + "/RESULTADOS/GIs_" + dominios.get(0).getVariable() + "_" + dominios.get(0).getNombreRegion() + ".csv";
            badGI = rutaCorrida + per + "/RESULTADOS/noGIs_" + dominios.get(0).getVariable() + "_" + dominios.get(0).getNombreRegion() + ".csv";
            errorLog = rutaCorrida + per + "/RESULTADOS/Errors_" + dominios.get(0).getVariable() + "_" + dominios.get(0).getNombreRegion() + ".csv";
            dominUse = rutaCorrida + per + "/RESULTADOS/Dominios_" + dominios.get(0).getVariable() + "_" + dominios.get(0).getNombreRegion() + ".csv";
            gisFw = new FileWriter(getGI, true);
            gisPw = new PrintWriter(gisFw);
            gisPw.println("Corrida\tRegión\tGoodIndex\tCCA coor\t" + Calendar.getInstance().getTime());

            badGisFw = new FileWriter(badGI, true);
            badGisPw = new PrintWriter(badGisFw);
            badGisPw.println("Corrida\tRegión\tbad GoodIndex\tCCA coor\t" + Calendar.getInstance().getTime());

            errorsFw = new FileWriter(new File(errorLog), true);
            errorsPw = new PrintWriter(errorsFw);
            errorsPw.println("Errores generados " + Calendar.getInstance().getTime());

            domFw = new FileWriter(new File(dominUse), true);
            domPw = new PrintWriter(domFw);
            domPw.println("corrida No\t Variable\t NombreRegion\tEs_lat_nor\tEs_lat_sur\tEs_lon_oes\tEs_lon_est"
                    + "\tPredictor\tpre_Lat_nor\tpre_Lat_sur\tpre_Lon_oes\tpre_Lon_est\tMaxModos\t" + Calendar.getInstance().getTime());

            int conteoHelp;
            String lant = null;
            int cdom = 0;// conteo de corrida por dominio
            for (RegionDominio rd : dominios) {

                System.out.println("*******************************************************************");
                switch (periodo) {
                    case 1://pronostico mensual
                        regionN = rd.getNombreRegion();
                        break;
                    case 2://pronostoco trimestral
                        regionN = rd.getNombreRegion() + "_" + per;
                        break;
                    default:
                        break;
                }
                xInDa = rutaCorrida + "IRI/" + rd.getPredictor() + ".txt";
                yInDa = rutaCorrida + per + "/Estaciones/" + rd.getVariable() + "_" + regionN + ".txt";
                goodIndex = rutaCorrida + per + "/RESULTADOS/GI_" + rd.getVariable() + "_" + regionN + "_" + rd.getPredictor() + "_C" + conteo + ".txt";
                persCoor = rutaCorrida + per + "/RESULTADOS/PCO_" + rd.getVariable() + "_" + regionN + "_" + rd.getPredictor() + "_C" + conteo + ".txt";
                sperCoor = rutaCorrida + per + "/RESULTADOS/SCO_" + rd.getVariable() + "_" + regionN + "_" + rd.getPredictor() + "_C" + conteo + ".txt";
                rocBel = rutaCorrida + per + "/RESULTADOS/ROCBN_" + rd.getVariable() + "_" + regionN + "_" + rd.getPredictor() + "_C" + conteo + ".txt";
                rocAvo = rutaCorrida + per + "/RESULTADOS/ROCAN_" + rd.getVariable() + "_" + regionN + "_" + rd.getPredictor() + "_C" + conteo + ".txt";
                probFore = rutaCorrida + per + "/RESULTADOS/PF_" + rd.getVariable() + "_" + regionN + "_" + rd.getPredictor() + "_C" + conteo + ".txt";
                odds = rutaCorrida + per + "/RESULTADOS/ODDS_" + rd.getVariable() + "_" + regionN + "_" + rd.getPredictor() + "_C" + conteo + ".txt";
                System.out.println("# Corriendo CPT para: " + per + " de " + año + " Corrida C" + conteo);
                System.out.println("# Predictor " + rd.getPredictor() + " cordenadas Latitud[" + rd.getLat_nor() + ":" + rd.getLat_sur()
                        + "]  Longitud[" + rd.getLon_oes() + ":" + rd.getLon_est() + "]");
                System.out.println("# Predictante " + rd.getVariable() + "_" + rd.getNombreRegion() + " coordenadas Latitud[" + rd.getEs_lat_nor() + ":" + rd.getEs_lat_sur()
                        + "]  Longitud[" + rd.getEs_lon_oes() + ":" + rd.getEs_lon_est() + "]");
                System.out.println("# Las salidas se guardaran en :" + rutaCorrida + per + "/RESULTADOS/");
                //comprobar si datos de X y Y existen
                boolean xI = new File(xInDa).exists();
                boolean yI = new File(yInDa).exists();
                if (xI && yI) {
                    ProcessBuilder pb = new ProcessBuilder("./CPT.x");
                    pb.directory(new File(rutaExe));
                    Process pr = pb.start();
                    InputStream stdout = pr.getInputStream();
                    InputStreamReader isr = new InputStreamReader(stdout);
                    BufferedReader br = new BufferedReader(isr);
                    //BufferedWriter bw = new BufferedWriter(osw);
                    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(pr.getOutputStream()));

                    //inicio de la oipciones del CPT
                    bw.write("611\n");
                    bw.write("1\n");
                    bw.write(xInDa + "\n");
//                System.out.println(xInDa");
                    bw.write(rd.getLat_nor() + "\n");
                    bw.write(rd.getLat_sur() + "\n");
                    bw.write(rd.getLon_oes() + "\n");
                    bw.write(rd.getLon_est() + "\n");
//                //System.out.println(rd.getLat_nor() + " "+rd.getLat_sur() +"  "+rd.getLon_oes() + rd.getLon_est() + "");
                    bw.write("1\n");
                    bw.write(rd.getMaxModos() + "\n");
                    //System.out.println("Maximos modos "+rd.getMaxModos());
                    bw.write("2\n");
                    bw.write(yInDa + "\n");
                    //System.out.println(yInDa);
                    bw.write(rd.getEs_lat_nor() + "\n");
                    bw.write(rd.getEs_lat_sur() + "\n");
                    bw.write(rd.getEs_lon_oes() + "\n");
                    bw.write(rd.getEs_lon_est() + "\n");
                    bw.write("1\n");
                    bw.write(rd.getMaxModos() + "\n");
                    bw.write("1\n");
                    bw.write(rd.getMaxModos() + "\n");
                    bw.write("531\n");
                    bw.write("1\n");
                    bw.write("532\n");
                    bw.write("1981\n");
                    bw.write("2010\n");
                    bw.write("Y\n");
                    bw.write("534\n");
                    bw.write("5\n");
                    bw.write("554\n");
                    bw.write("2\n");
                    bw.write("542\n");
                    bw.write("544\n");
                    bw.write("-999\n");
                    bw.write("10\n");
                    bw.write("10\n");
                    bw.write("2\n");
                    bw.write("1\n");
                    bw.write("-999\n");
                    bw.write("20\n");
                    bw.write("10\n");
                    bw.write("2\n");
                    bw.write("4\n");
                    bw.write("9\n");
                    bw.write("1\n");
                    bw.write("112\n");
                    bw.write(goodIndex + "\n");
                    //System.out.println(goodIndex);
                    bw.write("311\n");
                    //si tiene que resetear el numero de modos 
                    bw.write("Y\n");
                    bw.write("Y\n");
                    //bw.write("411\n");
                    /*bw.write("413\n");
                bw.write("1\n");
                bw.write(persCoor + "\n");
                bw.write("413\n");
                bw.write("2\n");
                bw.write(sperCoor + "\n");
                bw.write("413\n");
                bw.write("10\n");
                bw.write(rocBel + "\n");
                bw.write("413\n");
                bw.write("11\n");
                bw.write(rocAvo + "\n");
                bw.write("451\n");*/
                    //bw.write("452\n");
                    //bw.write("453\n");
                    bw.write("450\n");
                    bw.write("454\n");
                    bw.write("455\n");
                    bw.write("456\n");
                    bw.write("111\n");
                    bw.write("501\n");
                    bw.write(probFore + "\n");
                    //System.out.println(probFore);
                    /*bw.write("502\n");
                bw.write(odds + "\n");*/
                    bw.write("0\n");
                    bw.write("0\n");

                    bw.flush();
                    bw.close();
                    conteoHelp = 0;
                    int conteoIF = 0;
                    while ((l = br.readLine()) != null) {
                        //System.out.println(l);                       
                        //Error de lectura del archivo
                        if (l.indexOf("ERROR:") > 0 || l.indexOf("Problem") > 0) {
                            errorsPw.println("Error: de lectura para\tcorrida " + conteo + "\t" + rd.toString() + " :\t" + l);
                            break;
                        }
                        //Error ingreso de datos
                        if (l.contains("711.") && lant.contains(">   HELP")) {
                            System.out.println(l + " " + lant);
                            conteoHelp++;
                            //if (conteoHelp > 5) {
                            errorsPw.println("Error: máximo modos para\tcorrida " + conteo + "\t" + cdom + "\t" + rd.toString() + "\tmodos maximos = " + rd.getMaxModos());
                            conteoHelp = 10;
                            break;

                            //}
                        }

                        lant = l;
                    }

                    br.close();
                    pr.destroy();
                    //System.out.println("Antes de comprobar si se debe borrar " + conteoHelp);
                    if (conteoHelp == 0) {
                        double giv = isGood(goodIndex);
                        if (giv > maxNoGI) {
                            maxNoGI = giv;
                            domTemp= new RegionDominio(rd.getVariable(),rd.getNombreRegion(),rd.getEs_lat_nor(),rd.getEs_lat_sur(),
                                    rd.getEs_lon_oes(),rd.getEs_lon_est(),rd.getPredictor(),rd.getLat_nor(),rd.getLat_sur(),rd.getLon_oes(),
                                    rd.getLon_est(),rd.getMaxModos());
                        }
                        System.out.println("Valor GI " + giv + " para " + rd.toString());
                        if (giv > mingi) {
                            gisPw.println(conteo + "\t" + rd.getVariable() + "_" + rd.getNombreRegion() + "_" + rd.getPredictor() + "\t" + giv);
                            File del = new File(goodIndex);
                            del.delete();
                        } else {
//                        System.out.println(goodIndex);
//                        System.out.println("se va a eliminar GI, PCO, ROCBN, ROCAN, ODDS");
                            badGisPw.println(conteo + "\t" + rd.getVariable() + "_" + rd.getNombreRegion() + "_" + rd.getPredictor() + "\t" + giv + "\t *Eliminado");
                            File del = new File(goodIndex);
                            del.delete();
                            del = new File(persCoor);
                            del.delete();
                            del = new File(sperCoor);
                            del.delete();
                            del = new File(rocBel);
                            del.delete();
                            del = new File(rocAvo);
                            del.delete();
                            del = new File(probFore);
                            del.delete();
                            del = new File(odds);
                            del.delete();
                        }
                    }
                    domPw.println(cdom + "\t" + rd.toString() + "\t" + rd.getMaxModos());

                    conteo++;
                    isr.close();
                    stdout.close();
                    cdom++;
                }//Fin del if existe
                else {
                    if (!xI) {
                        errorsPw.println("Error: el archivo de entrada X no existe:\t " + xInDa);
                        System.out.println("El archivo de entrada X no existe: " + xInDa);
                    }
                    if (!yI) {
                        errorsPw.println("Error: el archivo de entrada Y no existe:\t" + yInDa);
                        System.out.println("El archivo de entrada Y no existe: " + yInDa);
                    }
                }
            }///fin del for            
            gisPw.close();
            gisFw.close();
            badGisPw.close();
            badGisFw.close();
            errorsPw.close();
            errorsFw.close();
            domFw.close();
            domPw.close();

            /*verificar si se generaron errores  caso contrario elimina el archivo errorLog*/
            System.out.println(isError(errorLog) + " 0 ");

        } catch (IOException ex) {
            Logger.getLogger(ScriptCPT.class.getName()).log(Level.SEVERE, null, ex);
        }

        /*verifica que exista un indice de bondad*/
        if (maxNoGI < mingi) {
            System.out.println("...........................................................");
            System.out.println("...........................................................");
            System.out.println("no existe un indice aceptable se debe volver a ejecutar con " + maxNoGI);
            //public void runCPT(String rutaExe, String rutaCorida, ArrayList<RegionDominio> dominios, int año, int index, int periodo, double mingi) {
            ArrayList<RegionDominio> domT=new ArrayList();
            domT.add(domTemp);
            runCPT(rutaExe, ructemp, domT , año, index, periodo, maxNoGI-0.02);//costaI
        }
        System.out.println("ejcucion lista .......");

    }

    private double isGood(String ruta) {
        BufferedReader br;
        double valor = 0.0;
        try {
            br = new BufferedReader(new FileReader(new File(ruta)));
            String line;
            int c = 0;
            while ((line = br.readLine()) != null) {
                if (c > 6) { //para leer desde la fila 7
                    int largo = line.length();
                    valor = Double.parseDouble(line.substring((largo - 9), largo).trim());
                    //System.out.println(c + " " + line + " " + largo + " GI : "+valor);
                }
                c++;
            }
            //System.out.println("good index value " + valor);

            br.close();

        } catch (FileNotFoundException ex) {

            Logger.getLogger(ScriptCPT.class.getName()).log(Level.SEVERE, null, "\n" + ex);
        } catch (IOException ex) {
            Logger.getLogger(ScriptCPT.class.getName()).log(Level.SEVERE, null, ex);
        }

        return valor;
    }

    private String isError(String ruta) {
        BufferedReader br;
        String valor = "";
        try {
            File error = new File(ruta);
            br = new BufferedReader(new FileReader(error));
            String line = br.readLine();
            int er = -1;
            while (line != null) {
                boolean contiene = Pattern.matches("^Error:.*", line);
                //System.out.println(contiene+"  : "+line);
                if (contiene) {
                    valor = "Ver los errores encontrados en " + ruta;
                    line = null;
                    er = 10;
                } else {
                    line = br.readLine();
                }
            }
            if (er == -1) {
                valor = "Se elimina el archivo de Errores " + error.delete();
            }

            br.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ScriptCPT.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ScriptCPT.class.getName()).log(Level.SEVERE, null, ex);
        }

        return valor;
    }

    /*método de verificacion si hay un gi*/
    public int thereIsGIS(String gisPath) {
        BufferedReader br;
        int valor = 0;
        //lee el archivo de índice de bondad y verifica que exista un valor,
        // si no exíste busca el mayor índice dentro del archivo nogis y ejecuta elmetodo
        try {
            File gis = new File(gisPath);
            br = new BufferedReader(new FileReader(gis));
            String line;
            while ((line = br.readLine()) != null) {
                /*machers*/
                boolean contiene = Pattern.matches("^[0-9].*", line);
                System.out.println(contiene + "  : " + line);
                if (contiene) {
                    valor = 200;
                }
            }
            br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ScriptCPT.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ScriptCPT.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valor;
    }

    public double maxNoGi(String noGiPath) {
        BufferedReader br;
        int valor = -1;
        //lee el archivo de índice de bondad y verifica que exista un valor,
        // si no exíste busca el mayor índice dentro del archivo nogis y ejecuta elmetodo
        try {
            File gis = new File(noGiPath);
            br = new BufferedReader(new FileReader(gis));
            String line;
            while ((line = br.readLine()) != null) {
                /*machers*/
                boolean contiene = Pattern.matches("^[0-9].*", line);
                System.out.println(contiene + "  : " + line);
                if (contiene) {
                    valor = 200;
                }
            }
            br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ScriptCPT.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ScriptCPT.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valor;
    }
}
