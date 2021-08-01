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
import Modelo.Estacionamiento;
import Modelo.FormatPlacaException;
import Modelo.IsAlphaException;
import Modelo.SizePlacaException;
import Modelo.isFullException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Modelo.VehiculoDesconocidoException;
import Modelo.Archivo;

public class MenuPrincipalControl implements ActionListener {

    private MenuPrincipalVista vista;
    private Estacionamiento estacionamiento;
    private InfoVista vInfo;
    private DatosControl cDatos;
    private DatosVista vDatos;
    private CambiarTarifaControl cCTarifa;
    private CambiarTarifaVista vCTarifa;
    private TarifaVista vTarifa;
    private TarifaControl cTarifa;
    public MostrarReporteD vReporte;

    public MenuPrincipalControl(Estacionamiento estacionamiento) { 
        this.estacionamiento = estacionamiento;

        //Instanciando las demás ventanas
        vInfo = new InfoVista();
        vInfo.setVisible(false);
        vInfo.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        cDatos = new DatosControl(this.estacionamiento);
        vDatos = new DatosVista(cDatos);
        cDatos.setVista(vDatos);
        vDatos.setVisible(false);

        cCTarifa = new CambiarTarifaControl(this.estacionamiento);
        vCTarifa = new CambiarTarifaVista(cCTarifa);
        cCTarifa.setVista(vCTarifa);
        vCTarifa.setVisible(false);

        cTarifa = new TarifaControl(this.estacionamiento);
        vTarifa = new TarifaVista(cTarifa);
        cTarifa.setVista(vTarifa);
        vTarifa.setVisible(false);

        vReporte = new MostrarReporteD();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Ir"://Para buscar placas y mostrar información
                try {
                    boolean b = true;
                    int m = 0, h = 0;
                    String placas = vista.getTxtPlaca();
                    if (estacionamiento.buscarVehiculo(placas) == true) {//Busca las placas
                        try {
                            String a = JOptionPane.showInputDialog(null, "Ingrese hora", "");
                            h = Integer.parseInt(a);
                            a = JOptionPane.showInputDialog(null, "Ingrese minuto", "");
                            m = Integer.parseInt(a);
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "Dato invalido", "ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        throw new VehiculoDesconocidoException();
                    }
                    if (estacionamiento.getVehiculo(placas).getHoraClase().compararHoras(h, m) == true) {//Comprueba las horas
                        int i = estacionamiento.getVehiculo(placas).getI();
                        int j = estacionamiento.getVehiculo(placas).getJ();
                        vInfo.setColor(estacionamiento.getVehiculo(placas).getColor());         //Aqui se modifican los labels para
                        vInfo.setMarca(estacionamiento.getVehiculo(placas).getMarca());         //que aparezcan los datos del vehiculo
                        vInfo.setModelo(estacionamiento.getVehiculo(placas).getModelo());
                        vInfo.setPlacas(placas);
                        vInfo.setHora(String.valueOf(estacionamiento.getVehiculo(placas).getHora()));
                        vInfo.setMinuto(String.valueOf(estacionamiento.getVehiculo(placas).getMinuto()));
                        vInfo.setI(String.valueOf(estacionamiento.getVehiculo(placas).getI()));
                        vInfo.setJ(String.valueOf(estacionamiento.getVehiculo(placas).getJ()));
                        h = h - estacionamiento.getVehiculo(placas).getHora();//Se obtiene diferencia de tiempo
                        m = m - estacionamiento.getVehiculo(placas).getMinuto();
                        vInfo.setPermanencia(h, m);
                        vInfo.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Hora invalida", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (VehiculoDesconocidoException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
                }
                vista.clearTxtField();

                break;
            case "Ok"://Para ingresar un nuevo vehículo
                //Comprobar espacio en la matriz (Primero se especifíca el vehículo a ingresar)
                int i = 5;
                try {
                    switch (vista.getVehiculo().getSelectedItem().toString()) {//Depende del comboBox y obtiene el tipo de vehiculo
                        case "Van":
                            i = estacionamiento.getNumVehiculos(0);
                            break;
                        case "Camioneta":
                            i = estacionamiento.getNumVehiculos(1);
                            break;
                        case "Auto Estandar":
                            i = estacionamiento.getNumVehiculos(2);
                            break;
                        case "Auto Compacto":
                            i = estacionamiento.getNumVehiculos(3);
                            break;
                        case "Motocicleta":
                            i = estacionamiento.getNumVehiculos(4);
                            break;
                    }

                    if (i < 5) {//Comprueba la disponibilidad del estacionamiento
                        cDatos.setVehiculo(vista.getVehiculo().getSelectedItem().toString());
                        vDatos.setVisible(true);
                        vDatos.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    } else {
                        throw new isFullException();
                    }
                } catch (isFullException ex) {
                    JOptionPane.showMessageDialog(null, "Estacionamiento de " + vista.getVehiculo().getSelectedItem().toString() + " lleno", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
                break;
            case "Liberar":
                vTarifa.setVisible(true);
                vTarifa.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                break;
            case "Generar Informe":
                //Muestra información de los vehículos hasta ese momento 
                Archivo.mostrar(vReporte);
                vReporte.setVisible(true);
                vReporte.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                break;
            case "Modificar Tarifa":
                vCTarifa.setVisible(true);
                break;
        }
    }

    public void setVista(MenuPrincipalVista vista) {
        this.vista = vista;
    }

    public MenuPrincipalVista getVista() {
        return vista;
    }

}
