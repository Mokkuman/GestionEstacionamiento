/* Integrantes:
  Carmona D'amico Ramiro
  Hernandez de la Rosa Manuel
  Padilla Rosete Ricardo
  Santiago Porras David*/

/* Exception que sera arrojada cuando no se encuentren datos en los txtField
 */
package Modelo;

public class SinDatosTxtException extends Exception {

    public SinDatosTxtException() {
        super("No estan todos los campos llenos");
    }

    public SinDatosTxtException(String msj) {
        super(msj);
    }
}
