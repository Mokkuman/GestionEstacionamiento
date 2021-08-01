/* Integrantes:
  Carmona D'amico Ramiro
  Hernandez de la Rosa Manuel
  Padilla Rosete Ricardo
  Santiago Porras David*/

package Modelo;
/* Excepcion creada para saber si nuestra String de las placas es un alfanumerico es decir
    debe de ver si está en el rango [a-z]U[A-Z]U[1-0]

 */
public class IsAlphaException extends Exception{
    public IsAlphaException(){
        super("La matricula debe ser AlfaNumerica");
    }
    public IsAlphaException(String msj){
        super(msj);
    }
}
