/* Integrantes:
  Carmona D'amico Ramiro
  Hernandez de la Rosa Manuel
  Padilla Rosete Ricardo
  Santiago Porras David*/

package Control;

//import com.sun.prism.paint.Color;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import Vista.*;
import Modelo.*;

public class MatrizControl implements ActionListener {

    MatrizVista vista;
    Estacionamiento est;
    MVehiculo v;

    public MatrizControl(Estacionamiento estacionamiento) {
        this.est = estacionamiento;
    }

    public void actionPerformed(ActionEvent e) { 
        for (int i = 0; i < 5; i++) {  //Busca posicion del boton que fue seleccionado
            for (int j = 0; j < 5; j++) {
                if (e.getSource() == vista.getButton(i, j)) {
                    if (est.addVehiculo(i, j, v) == true) { //Comprueba de que el estacionamiento sea el adecuado
                        vista.cambiarColor(vista.getButton(i, j), i, j);
                        vista.setVisible(false);
                        Archivo.guardar(v);
                        Archivo.escribir(v);
                        Archivo.copiar("auxiliar.txt", "informeDia.txt"); //Copia el archivo origen al archivo destino
                    } else {
                        JOptionPane.showMessageDialog(null, "No puedes acceder a ese lugar", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                }
            }
        }
    }

    public void setVista(MatrizVista vista) {
        this.vista = vista;
    }

    public MatrizVista getVista() {
        return vista;
    }

    public void setVehiculoTemp(MVehiculo v) {
        this.v = v;
    }

    public Estacionamiento getEstacionamiento() {
        return est;
    }

}
