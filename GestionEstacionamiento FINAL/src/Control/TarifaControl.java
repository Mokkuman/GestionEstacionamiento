/* Integrantes:
  Carmona D'amico Ramiro
  Hernandez de la Rosa Manuel
  Padilla Rosete Ricardo
  Santiago Porras David*/

package Control;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import Vista.*;
import Modelo.*;
import java.io.Serializable;

public class TarifaControl implements ActionListener, Serializable {

    TarifaVista vista;
    Estacionamiento est;

    public TarifaControl(Estacionamiento estacionamiento) {      //Aqui paso el vehiculo del combobox a un String vehiculo para facilitar
        this.est = estacionamiento;
    }

    @Override                                           //Asignamos el ActionListener
    public void actionPerformed(ActionEvent e) {
        String placas;
        int hora, minutos;
        placas = vista.getTxtPlaca();
        if (est.buscarVehiculo(placas) == true) {
            try {
                hora = Integer.parseInt(vista.gethoraIn().getText());
                minutos = Integer.parseInt(vista.getMinutosIn().getText());
                String mensaje;
                float total;
                int horaI = est.getVehiculo(placas).getHora();
                int minutoI = est.getVehiculo(placas).getMinuto();

               //Regresa la diferencia de minutos de las 2 horas, y si son incorrectas regresa -1
                if ((total = est.getHora().returnDiferenciaHoras(horaI, minutoI, hora, minutos))!=-1) {
                    if (e.getActionCommand() == "Pago directo") {
                        total = total * est.getTarifa();
                        mensaje = "Pago directo de : " + total + "\n¿Desea factura?";
                        int n = JOptionPane.showConfirmDialog(null, mensaje, "Tarifa", JOptionPane.YES_NO_OPTION);
                        //Si-0 No-1
                        vista.setVisible(false);
                        est.eliminarVehiculo(placas);
                        if (n == 0) {
                            Archivo.generarTicketLiberar(placas, total);
                        }
                    } else {
                        String a = JOptionPane.showInputDialog(null, "Ingrese el numero de mensualidades", "");
                        vista.setVisible(false);
                        if (a.isEmpty() == false) {//Si es false no esta vacia la cadena
                            int mensualidad = Integer.parseInt(a);
                            total = total * est.getTarifa() / mensualidad;
                            mensaje = "Pago a meses de: " + total + "\n¿Desea factura?";
                            int n = JOptionPane.showConfirmDialog(null, mensaje, "Tarifa", JOptionPane.YES_NO_OPTION);
                            vista.setVisible(false);
                            est.eliminarVehiculo(placas);
                            if (n == 0) {
                                Archivo.generarTicketLiberar(placas, total);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Parametros vacíos", "ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Hora invalida", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Dato invalido", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
        vista.clearTxtField();
    }

    public void setVista(TarifaVista vista) {
        this.vista = vista;
    }

    public TarifaVista getVista() {
        return vista;
    }

}
