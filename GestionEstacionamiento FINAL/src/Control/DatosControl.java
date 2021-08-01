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
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatosControl implements ActionListener {

    DatosVista vista;
    Estacionamiento est;
    private String vehiculo;

    private MatrizControl cMatriz;
    private MatrizVista vMatriz;

    public DatosControl(Estacionamiento estacionamiento) {      //Aqui paso el vehiculo del combobox a un String vehiculo para facilitar
        this.est = estacionamiento;                                             //las cosas maybe
        cMatriz = new MatrizControl(est);        //Se crean las instancias para la ventana Matriz LGBTQ+
        vMatriz = new MatrizVista(cMatriz);
        vMatriz.setVisible(false);
        cMatriz.setVista(vMatriz);
    }

    public void setVista(DatosVista vista) {
        this.vista = vista;
    }

    public DatosVista getVista() {
        return vista;
    }

    @Override                                           //Asignamos el ActionListener
    public void actionPerformed(ActionEvent e) {
        String marca, modelo, color, placas;
        int hora, minuto;
        if (e.getActionCommand() == "Seleccionar espacio") {
            try {
                marca   = vista.getMarcaIn().getText();               //Se crean variables para depositar lo que el usuario escribió
                modelo  = vista.getModeloIn().getText();
                color   = vista.getColorIn().getText();
                placas  = vista.getTxtPlacas();
                est.comprobarFormatoPlacas(placas);
                //Creados para evaluar que no esten vacios
                String strHora = vista.getHoraIn().getText();
                String strMin  = vista.getMinutoIn().getText();
                boolean b = true;
                int m,h;
                try { //Verifica que el formato de la hora sea correcto
                    h = Integer.parseInt(strHora);
                    m = Integer.parseInt(strMin);
                    if (est.getHora().comprobarHora(h)==false || est.getHora().comprobarMinuto(m)==false) {
                        JOptionPane.showMessageDialog(null, "Hora invalida", "ERROR", JOptionPane.ERROR_MESSAGE);
                        b = false;
                    } 
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Dato invalido", "ERROR", JOptionPane.ERROR_MESSAGE);
                    b = false;
                }

                 if (b == true) {
                MVehiculo v = null;
                vMatriz.actualizarMatriz(); //Comprueba si los parametros estan vacios
                if (marca.compareTo("") != 0 && modelo.compareTo("") != 0 && color.compareTo("") != 0 && placas.compareTo("") != 0 &&strHora.compareTo("")!=0 && strMin.compareTo("")!=0) { //ningun campo debe de estar vacio
                    if(est.buscarVehiculo(placas)==false){//Busca la placa, de encontrarse ya fue creada anteriormente
                    hora = Integer.parseInt(strHora);
                    minuto = Integer.parseInt(strMin);
                    switch (vehiculo) {//Crea el vehiculo correspondiente
                        case "Van":
                            v = new Van(marca, modelo, color, placas, new Hora(hora,minuto));
                            break;

                        case "Camioneta":
                            v = new Camioneta(marca, modelo, color, placas,new Hora(hora,minuto));
                            break;

                        case "Auto Estandar":
                            v = new AutoCompacto(marca, modelo, color, placas, new Hora(hora,minuto));
                            break;

                        case "Auto Compacto":
                            v = new AutoEstandar(marca, modelo, color, placas, new Hora(hora,minuto));
                            break;

                        case "Motocicleta":
                            v = new Motocicleta(marca, modelo, color, placas, new Hora(hora,minuto));
                            break;
                    }
                    cMatriz.setVehiculoTemp(v); //Se muestra la matriz del estacionamiento
                    vMatriz.setVisible(true);
                    vista.setVisible(false);
                    }else{
                        throw new vehiculoYaExistenteException();
                    }
                } else {
                    throw new SinDatosTxtException();

                }
                 }
                 vista.clearTxtField();
            } catch (SizePlacaException | IsAlphaException | FormatPlacaException | SinDatosTxtException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }catch(vehiculoYaExistenteException ex){
                JOptionPane.showMessageDialog(null, "Placas ya registradas anteriormente", "ERROR", JOptionPane.ERROR_MESSAGE);
            }           
        }
    }

    public void setVehiculo(String vehiculo) {
        this.vehiculo = vehiculo;
    }
}
