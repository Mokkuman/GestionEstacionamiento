/* Integrantes:
  Carmona D'amico Ramiro
  Hernandez de la Rosa Manuel
  Padilla Rosete Ricardo
  Santiago Porras David*/

/*  EXCEPTION usada cuando los caracteres de la placa ingresados
    superan los 7 caracteres (los tomados como referencia)
*/
package Modelo;

public class SizePlacaException extends Exception{
    public SizePlacaException(){
        super("La placa debe tener 7 caracteres alfanumericos");
    }
    public SizePlacaException(String msj){
        super(msj);
    }

}