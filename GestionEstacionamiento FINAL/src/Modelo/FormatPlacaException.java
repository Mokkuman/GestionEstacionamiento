/* Integrantes:
  Carmona D'amico Ramiro
  Hernandez de la Rosa Manuel
  Padilla Rosete Ricardo
  Santiago Porras David*/

/*   Clase que lanza un EXCEPTION cuando el formato de la placa no es el correcto
    el cual es AAA0000 :p
*/
package Modelo;

public class FormatPlacaException extends Exception{
    public FormatPlacaException(){
        super("El formato de las placas no es corecto");
    }
    public FormatPlacaException(String msj){
        super(msj);
    }
    
}
