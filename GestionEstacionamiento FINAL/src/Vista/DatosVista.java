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

public class DatosVista extends JFrame {

    private JButton buttonSelEspacio;
    private JLabel marca, modelo, color, placas, hora,minuto;
    private JPanel pan1, pan2, pan3;
    private JTextField marcaIn, modeloIn, colorIn, placasIn, horaIn,minutoIn;
    DatosControl control;
    Estacionamiento est;

    public DatosVista(DatosControl control) {
        super("Datos de vehiculo");
        this.control = control;
        setLayout(new BorderLayout(2, 2));
        initComponents();
        setLocation(250, 250);
        setSize(700, 130);
        setResizable(false);
    }

    public void initComponents() {
        pan1 = new JPanel();
        pan2 = new JPanel();
        pan3 = new JPanel();
        marca = new JLabel("Marca: ");
        marcaIn = new JTextField("", 20);
        pan1.add(marca);
        pan1.add(marcaIn);
        modelo = new JLabel("Modelo: ");
        modeloIn = new JTextField("", 10);
        pan1.add(modelo);
        pan1.add(modeloIn);
        color = new JLabel("Color :");
        colorIn = new JTextField("", 10);
        pan1.add(color);
        pan1.add(colorIn);
        placas = new JLabel("Placas: ");
        placasIn = new JTextField("", 7);
        pan2.add(placas);
        pan2.add(placasIn);
        hora = new JLabel("Hora: ");
        horaIn = new JTextField("", 5);
        minuto = new JLabel("Minuto: ");
        minutoIn = new JTextField("",5);
        pan2.add(hora);
        pan2.add(horaIn);
        pan2.add(minuto);
        pan2.add(minutoIn);
        buttonSelEspacio = new JButton("Seleccionar espacio");
        buttonSelEspacio.addActionListener(control);
        pan3.add(buttonSelEspacio);
        add("North", pan1);
        add("Center", pan2);
        add("South", pan3);
    }

    public JTextField getMarcaIn() {            //No incluyo la hora
        return marcaIn;
    }

    public JTextField getModeloIn() {       //Se obtiene el input de los textFields
        return modeloIn;
    }

    public JTextField getColorIn() {
        return colorIn;
    }

    public String getTxtPlacas() {
        String placaS = placasIn.getText();
        placaS = placaS.toUpperCase();          //Pasando a mayusculas
        return placaS;
    }

    public JTextField getHoraIn(){
        return horaIn;
    }
    
    public JTextField getMinutoIn(){
        return minutoIn;
    }
    
    public void clearTxtField(){
        placasIn.setText("");
        marcaIn.setText("");
        modeloIn.setText("");
        colorIn.setText("");
        horaIn.setText("");
        minutoIn.setText("");
    }
    
}
