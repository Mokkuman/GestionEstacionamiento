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

public class CambiarTarifaControl implements ActionListener{
    private CambiarTarifaVista vista;
    private Estacionamiento estacionamiento;
    
    public CambiarTarifaControl(Estacionamiento estacionamiento){
        this.estacionamiento=estacionamiento;
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        try{
            String txt = vista.getText().getText(); //Regresa un string
            float r = Float.parseFloat(txt);//Convierte a flotante
            estacionamiento.setTarifa(r);//Se almacena
            vista.setVisible(false);
        }catch(Exception ex){//Error de conversion
            JOptionPane.showMessageDialog(null, "Dato invalido", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        vista.clearTxtField();
    }
    
    public void setVista(CambiarTarifaVista vista){
        this.vista = vista;
    }
    
    public CambiarTarifaVista getVista(){
        return vista;
    }
    
}