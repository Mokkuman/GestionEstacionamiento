/* Integrantes:
  Carmona D'amico Ramiro
  Hernandez de la Rosa Manuel
  Padilla Rosete Ricardo
  Santiago Porras David*/
package Modelo;

public class vehiculoYaExistenteException extends Exception {

    public vehiculoYaExistenteException() {
        super("Placas ya ingresadas anteriormente");
    }
    
    public vehiculoYaExistenteException(String excepcion){
        super(excepcion);
    }
}
