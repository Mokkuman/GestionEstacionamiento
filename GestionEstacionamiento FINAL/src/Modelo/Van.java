/* Integrantes:
  Carmona D'amico Ramiro
  Hernandez de la Rosa Manuel
  Padilla Rosete Ricardo
  Santiago Porras David*/

package Modelo;

public class Van extends MVehiculo{
    public Van(int i, int j){
        super(i,j);
    }
    
    public Van(String marca, String modelo, String color, String placas, Hora hora){
        super(marca,modelo,color,placas,hora);
    }
    
}
