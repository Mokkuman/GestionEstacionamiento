/* Integrantes:
  Carmona D'amico Ramiro
  Hernandez de la Rosa Manuel
  Padilla Rosete Ricardo
  Santiago Porras David*/

package Vista;

import javax.swing.*;
import java.awt.*;
import Control.*;
import Modelo.*;
import java.util.regex.Pattern;

public class TarifaVista extends JFrame {
    private JButton buttonPagoDirecto, buttonPagoMensual;
    private JLabel  horas, placas, dosPuntos;
    private JPanel pan1, pan2, pan3;
    private JTextField horaIn, minutosIn,placasIn;
    private JOptionPane vehiculoDesconocido,pagoDirecto,pagoMensual;
    TarifaControl control;
    Estacionamiento est;

    public TarifaVista(TarifaControl control ) {
        super("Tipo de tarifa");
        this.control = control;
        setLayout(new BorderLayout(2,2));
        initComponents();
        setLocation(250, 250);
        setSize(300,130);
        setResizable(false);
    }

    public void initComponents() {
        pan1 = new JPanel(); pan2 = new JPanel(); pan3 = new JPanel();
        vehiculoDesconocido=new JOptionPane();pagoDirecto=new JOptionPane();pagoMensual=new JOptionPane();
        placas = new JLabel("Placas: ");
        pan1.add(placas);
        placasIn = new JTextField("", 7);
        pan1.add(placasIn);
        horas = new JLabel("Hora de salida :");
        pan2.add(horas);
        horaIn = new JTextField("", 2);
        pan2.add(horaIn);
        dosPuntos = new JLabel(":");
        pan2.add(dosPuntos);
        minutosIn = new JTextField("", 2);
        pan2.add(minutosIn);
        buttonPagoDirecto = new JButton("Pago directo");
        buttonPagoDirecto.addActionListener(control);
        pan3.add(buttonPagoDirecto);
        buttonPagoMensual = new JButton("Pago mensual");
        buttonPagoMensual.addActionListener(control);
        pan3.add(buttonPagoMensual);
        add( "North",pan1);
        add( "Center",pan2);
        add( "South",pan3);
    }

    public JTextField getMinutosIn() {       //Se obtiene el input de los textFields
        return minutosIn;
    }

    public JTextField gethoraIn() {
        return horaIn;
    }

    public String getTxtPlaca()  {
        String placaS = placasIn.getText();
        placaS = placaS.toUpperCase();          //Pasando a mayusculas
        return placaS;
    }
    
    public void clearTxtField(){
        placasIn.setText("");
        horaIn.setText("");
        minutosIn.setText("");
    }
    
}
