/* Integrantes:
  Carmona D'amico Ramiro
  Hernandez de la Rosa Manuel
  Padilla Rosete Ricardo
  Santiago Porras David*/

//Excepcion para comprobar si esta lleno el estacionamiento

package Modelo;
public class isFullException extends Exception{
    public isFullException(){
        super("El estacionamiento está lleno");
    }
    
    public isFullException(String msj){
        super(msj);
    }
}
