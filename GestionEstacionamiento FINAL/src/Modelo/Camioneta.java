/* Integrantes:
  Carmona D'amico Ramiro
  Hernandez de la Rosa Manuel
  Padilla Rosete Ricardo
  Santiago Porras David*/


package Modelo;

public class Camioneta extends MVehiculo{
    
    public Camioneta(int i, int j){
        super(i,j);
    }
    
    public Camioneta(String marca, String modelo, String color, String placas,Hora hora){
        super(marca, modelo, color , placas,hora);
    }
}
