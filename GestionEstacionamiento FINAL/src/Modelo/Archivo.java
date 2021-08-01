/* Integrantes:
  Carmona D'amico Ramiro
  Hernandez de la Rosa Manuel
  Padilla Rosete Ricardo
  Santiago Porras David*/

package Modelo;

import Vista.MostrarReporteD;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Archivo {

    public static void mostrar(MostrarReporteD vista) {             
        vista.setTitulo();//Escribe el encabezado del archivo
        String a = "informeDia.txt";//Se crea el archivo
        File archivo = new File(a);
        BufferedReader entrada;
        try {
            entrada = new BufferedReader(new FileReader(archivo));
            String linea;
            while ((linea = entrada.readLine()) != null) {//Mientras haya contenido, se concatenan todas las lineas del documento
                vista.setArea(linea);
            }
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void generarTicketLiberar(String placas, float costo) {
        String nombreArchivo = placas + ".txt";//Nombre de las placas con .txt para crear el archivo
        File archivo = new File(nombreArchivo);
        BufferedWriter salida = null;
        String costoS = String.valueOf(costo);//Buffer de salida tipo String porque solo este lo admite
        try {
            salida = new BufferedWriter(new FileWriter(archivo));//Se escribe la informacion
            salida.write("Placas del vehiculo : ");
            salida.write(placas);
            salida.write("\n");
            salida.write("Usted debe pagar: ");
            salida.write(costoS);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error", "Error", JOptionPane.ERROR_MESSAGE);
        }
        if (salida != null) {
            try {
                salida.close();        //Se cierra obligatoriamente
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Ocurrio un error", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    public static void limpiar() { //Sobreescribe un espacio en blanco para "limpiarlo" en el informe diario
        String a= "informeDia.txt";
        String b = "auxiliar.txt";
        String c = "auxiliarC.txt";
        File archivo = new File(a);
        File auxiliar = new File(b);
        File auxiliarC = new File(c);
        BufferedWriter salida = null, salidaAux = null, salidaAuxC = null;
        try {
            salida = new BufferedWriter(new FileWriter(archivo));
            salida.write(" ");//Justo aqui
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error", "Error", JOptionPane.ERROR_MESSAGE);
        }
        if (salida != null) {
            try {
                salida.close();        //Se cierra obligatoriamente
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Ocurrio un error", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        try {
            salidaAux = new BufferedWriter(new FileWriter(auxiliar));
            salidaAux.write(" ");//Justo aqui
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error", "Error", JOptionPane.ERROR_MESSAGE);
        }
        if (salida != null) {
            try {
                salidaAux.close();        //Se cierra obligatoriamente
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Ocurrio un error", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        try {
            salidaAuxC = new BufferedWriter(new FileWriter(auxiliarC));
            salidaAuxC.write(" ");//Justo aqui
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error", "Error", JOptionPane.ERROR_MESSAGE);
        }
        if (salida != null) {
            try {
                salidaAuxC.close();        //Se cierra obligatoriamente
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Ocurrio un error", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    public static void escribir(MVehiculo vehiculo) {//Genera el ticket al agregar un vehiculo
        String nombre = "ticket.txt";
        File archivo = new File(nombre);
        BufferedWriter salida = null;
        String minuto, hora;
        minuto = String.valueOf(vehiculo.getMinuto());
        hora = String.valueOf(vehiculo.getHora());
        try {
            salida = new BufferedWriter(new FileWriter(archivo));
            salida.write("Marca: ");
            salida.write(" ");
            salida.write(vehiculo.getMarca());
            salida.write("\n");
            salida.write("Modelo: ");
            salida.write(vehiculo.getModelo());
            salida.write("\n");
            salida.write("Color: ");
            salida.write(vehiculo.getColor());
            salida.write("\n");
            salida.write("Placas: ");
            salida.write(vehiculo.getPlacas());
            salida.write("\n");
            salida.write("Hora: ");
            salida.write(hora);
            salida.write("\n");
            salida.write("Minutos: ");
            salida.write(minuto);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error", "Error", JOptionPane.ERROR_MESSAGE);
        }
        if (salida != null) {
            try {
                salida.close();        //Se cierra obligatoriamente
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Ocurrio un error", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void copiar(String a, String b) {             //Se copiara A en B
        File archivo =  new File(a);                            
        File archivoC = new File(b);
        BufferedWriter salida = null, salidaC = null;
        BufferedReader entrada = null, entradaC = null;

        String linea = "";
        try {
            entrada = new BufferedReader(new FileReader(archivo));
            salida = new BufferedWriter(new FileWriter(archivoC));
            while ((linea = entrada.readLine()) != null) {
                salida.write(linea);
                salida.write("\n");
            }
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error", "Error", JOptionPane.ERROR_MESSAGE);
        }
        if (salida != null) {
            try {
                salida.close();        //Se cierra obligatoriamente
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Ocurrio un error", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void guardar(MVehiculo vehiculo) {
        //boolean band = false;         Para pruebas
        String a= "informe.txt";
        String b = "informeC.txt";
        String c = "auxiliar.txt";
        String d = "auxiliarC.txt";
        File auxiliar = new File(c);
        File auxiliarC = new File(d);
        File archivo = new File(a);
        File archivoC = new File(b);
        String minuto, hora;
        minuto = String.valueOf(vehiculo.getMinuto());
        hora = String.valueOf(vehiculo.getHora());
        BufferedWriter salida = null, salidaC = null, auxiliarO = null;
        BufferedReader entrada = null, entradaC = null, auxiliarI = null, auxiliarIC = null;
        try {
            entrada =  new BufferedReader(new FileReader(archivo));
            String linea, lineaC;
            //if(archivo.length() != 0) {            //Si el archivo esta vacio
            if((linea = entrada.readLine()) != null) {            //Si el archivo esta vacio
                // System.out.println("Entro a copiar");    Pruebas
                copiar(a,b);
                entradaC = new BufferedReader(new FileReader(archivoC));
                salida = new BufferedWriter(new FileWriter(archivo));
                while ((lineaC = entradaC.readLine()) != null) {
                 salida.write(lineaC);
                 salida.write("\n");
                }
                salida.write(vehiculo.getMarca());
                salida.write("     ");
                salida.write(vehiculo.getModelo());
                salida.write("     ");
                salida.write(vehiculo.getColor());
                salida.write("     ");
                salida.write(vehiculo.getPlacas());
                salida.write("     ");
                salida.write(hora);
                salida.write("     ");
                salida.write(minuto);
                salida.write("\n");
            }
            else { 
                salida = new BufferedWriter(new FileWriter(archivo));
                salida.write(vehiculo.getMarca());
                salida.write("     ");
                salida.write(vehiculo.getModelo());
                salida.write("     ");
                salida.write(vehiculo.getColor());
                salida.write("     ");
                salida.write(vehiculo.getPlacas());
                salida.write("     ");
                salida.write(hora);
                salida.write("     ");
                salida.write(minuto);
                salida.write("\n");
            }
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error", "Error", JOptionPane.ERROR_MESSAGE);
        }
        if (salida != null) {
            try {
                salida.close();        //Se cierra obligatoriamente
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Ocurrio un error", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        try {
            auxiliarI =  new BufferedReader(new FileReader(auxiliar));
            String linea, lineaC;
            //if(archivo.length() != 0) {            //Si el archivo esta vacio
            if((linea = auxiliarI.readLine()) != null) {            //Si el archivo esta vacio
                // System.out.println("Entro a copiar");    Pruebas
                copiar(c,d);
                auxiliarIC = new BufferedReader(new FileReader(auxiliarC));
                auxiliarO = new BufferedWriter(new FileWriter(auxiliar));
                while ((lineaC = auxiliarIC.readLine()) != null) {
                    auxiliarO.write(lineaC);
                    auxiliarO.write("\n");
                }
                auxiliarO.write(vehiculo.getMarca());
                auxiliarO.write("     ");
                auxiliarO.write(vehiculo.getModelo());
                auxiliarO.write("     ");
                auxiliarO.write(vehiculo.getColor());
                auxiliarO.write("     ");
                auxiliarO.write(vehiculo.getPlacas());
                auxiliarO.write("     ");
                auxiliarO.write(hora);
                auxiliarO.write("     ");
                auxiliarO.write(minuto);
                auxiliarO.write("\n");
            }
            else {
                auxiliarO = new BufferedWriter(new FileWriter(archivo));
                auxiliarO.write(vehiculo.getMarca());
                auxiliarO.write("     ");
                auxiliarO.write(vehiculo.getModelo());
                auxiliarO.write("     ");
                auxiliarO.write(vehiculo.getColor());
                auxiliarO.write("     ");
                auxiliarO.write(vehiculo.getPlacas());
                auxiliarO.write("     ");
                auxiliarO.write(hora);
                auxiliarO.write("     ");
                auxiliarO.write(minuto);
                auxiliarO.write("\n");
            }
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error", "Error", JOptionPane.ERROR_MESSAGE);
        }
        if (auxiliarO != null) {
            try {
                auxiliarO.close();        //Se cierra obligatoriamente
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Ocurrio un error", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
