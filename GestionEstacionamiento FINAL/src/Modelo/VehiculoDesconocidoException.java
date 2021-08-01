/* Integrantes:
  Carmona D'amico Ramiro
  Hernandez de la Rosa Manuel
  Padilla Rosete Ricardo
  Santiago Porras David*/

package Modelo;
/* Al buscar las placas si es que no las encuentra lanza esta exception

 */
public class VehiculoDesconocidoException extends Exception{
    public VehiculoDesconocidoException(){
        super("Vehiculo NO encontrado");
    }
    public VehiculoDesconocidoException(String msj){
        super(msj);
    }
}
