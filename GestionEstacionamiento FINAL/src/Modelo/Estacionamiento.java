/* Integrantes:
  Carmona D'amico Ramiro
  Hernandez de la Rosa Manuel
  Padilla Rosete Ricardo
  Santiago Porras David*/

package Modelo;

import java.util.ArrayList;
import Modelo.MVehiculo;
import java.util.regex.Pattern;

public class Estacionamiento {

    private String nombre;
    private MVehiculo vehiculos[][];
    private float tarifa;
    private Hora h;
    
    public Estacionamiento(String nombre) {
        this.nombre = nombre;
        vehiculos = new MVehiculo[5][5];
        for (int i = 0; i < 5; i++) {//Asigna espacios
            vehiculos[0][i] = new Van(0,i);
            vehiculos[1][i] = new Camioneta(1,i);
            vehiculos[2][i] = new AutoEstandar(2,i);
            vehiculos[3][i] = new AutoCompacto(3,i);
            vehiculos[4][i] = new Motocicleta(4,i);
        }
        tarifa=(float) 0.5;
        h = new Hora(0,0);
    }

    public void setTarifa(float tarifa){
        this.tarifa=tarifa;
    }
    
    public float getTarifa(){
        return tarifa;
    }
    
    public String getNombreEstacionamiento() {
        return nombre;
    }

    //Lanzar excepción de espacio no adecuada para vehículo y vehículo ya agregado o con placas iguales
    public boolean addVehiculo(int i, int j, MVehiculo v) {
        //Primero busca si existe ese vehículo (Con las placas)
        //Si es falso entonces no está registrado esas placas
        if(buscarVehiculo(v.placas)==false){
            //Comprueba si el espacio y el vehículo a agregar son del mismo tipo
            if(comprobarInstance(v,i,j)){
                //Comprueba si el espacio está vacío
                if(vehiculos[i][j].getPlacas().compareTo("")==0){    
                    vehiculos[i][j] = v;
                    vehiculos[i][j].addPosicion(i, j);
                    return true;
                }
                return false;
            }else
                return false;
        }
        else
            return false;
    }
    
    public boolean comprobarInstance(MVehiculo v, int i, int j){//Comprobar que el espacio es correcto para el vehiculo
        if(v instanceof Van && vehiculos[i][j] instanceof Van){
            return true;
        }
        if(v instanceof Camioneta && vehiculos[i][j] instanceof Camioneta){
            return true;
        }
        if(v instanceof AutoEstandar && vehiculos[i][j] instanceof AutoEstandar){
            return true;
        }
        if(v instanceof AutoCompacto && vehiculos[i][j] instanceof AutoCompacto){
            return true;
        }
        return v instanceof Motocicleta && vehiculos[i][j] instanceof Motocicleta;
    }

    public boolean buscarVehiculo(String placas){
        for(int i=0;i<5;i++){
            for(int j=0; j<5; j++){
                if(vehiculos[i][j].placas.compareTo(placas)==0 && placas.compareTo("")!=0)
                    return true;
            }
        }
        return false;
    }

    public MVehiculo getVehiculo(int i, int j) {
        return vehiculos[i][j];
    }
    
    //Fala poner excepción en el último return
    public MVehiculo getVehiculo(String placas){
        //Primero busca si existen las placas
        if(buscarVehiculo(placas)){
            //Si lo encuentra retorna el vehículo con esas placas para operar
            for(int i=0;i<5;i++){
                for(int j=0;j<5;j++){
                    if(vehiculos[i][j].placas.compareTo(placas)==0)
                        return vehiculos[i][j];
                }
            }
        }
        return vehiculos[5][0]; //ERROR!!!!
    }
    
    public int getNumVehiculos(int i) {
        int cont=0;
        for(int j=0;j<5;j++){
            if(vehiculos[i][j].placas.compareTo("")!=0)
                cont++;
        }
        return cont;
    }
    
    
    public boolean eliminarVehiculo(String placas) {
        //Se elimina solo poniendo las placas vacías pues ese será el método para buscarlo
        if(buscarVehiculo(placas)){
            getVehiculo(placas).placas="";
            return true;
        }
        return false;
    }
    
    public void comprobarFormatoPlacas(String placas) throws IsAlphaException, SizePlacaException, FormatPlacaException{
        placas = placas.toUpperCase();          //Pasando a mayusculas
        if(placas.length()<7||placas.length()>7){
            throw new SizePlacaException();
        }
        //Creando un boolean para evaluar si es alfanumerico
        boolean alfa = Pattern.matches("^[A-Za-z0-9]*$",placas);
        if(!alfa){
            throw new IsAlphaException();
        }
        
        //Comprobamos el formato de la placa AAA0000
        String subPlaca1 = placas.substring(0,3);       //Para las letras
        String subPlaca2 = placas.substring(3);         //Para los numeros
        boolean fLetra,fNumeros; //Banderas que me da true si el formato es el apropiado, si no lanza el error

        fLetra   = Pattern.matches("^[A-Za-z]+$",subPlaca1);
        fNumeros = Pattern.matches("^[0-9]+$",subPlaca2);

        if(fLetra==false || fNumeros == false){ //Si no cumple el formato
            throw new FormatPlacaException();
        }
    }
    
    public Hora getHora(){
        return h;
    }
}
