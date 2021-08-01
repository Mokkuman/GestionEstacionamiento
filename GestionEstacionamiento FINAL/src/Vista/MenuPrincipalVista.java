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


public class MenuPrincipalVista extends JFrame{
    private JButton     buttonOK,buttonSearch,buttonLiberar,buttonInforme,buttonTarifa;
    private JLabel      lblLogo,placas, estacionar;
    private JPanel      panel , pan0, pan1, pan2, pan3, pan4, pan5;
    private JTextField  placasIn;
    private JComboBox   vehiculo;
    MenuPrincipalControl control;
    //MenuPrincipalModelo modelo;

    public MenuPrincipalVista(MenuPrincipalControl control ) {
        super("Bienvenido a Todos Cabemos ! - Menu Principal");
        this.control = control;
         setLayout(new BorderLayout(2,2));
        initComponents();
        setSize(600,300);
        setResizable(false);
    }

    public void initComponents() {
        pan0 = new JPanel();   pan1 = new JPanel();    pan2 = new JPanel();
        pan3 = new JPanel();    pan4 = new JPanel(); pan5 = new JPanel();
        //Poniendo el logo en mi pan0
        Icon logo = new ImageIcon("TodosCabemos2.png");
        lblLogo = new JLabel("",logo,SwingConstants.LEFT);
        lblLogo.setToolTipText("Logo TodosCabemos");
        pan0.add(lblLogo);

        placas = new JLabel("Buscar placas: ");
        placasIn = new JTextField("", 7);
        pan1.add(placas);
        pan1.add(placasIn);
        buttonSearch = new JButton("Ir");
        buttonSearch.addActionListener(control);
        pan1.add(buttonSearch);
        estacionar = new JLabel("Estacionar: ");
        vehiculo = new JComboBox ();
        vehiculo.setBounds(10,10,80,20);
        pan2.add(estacionar);
        pan2.add(vehiculo);
        vehiculo.addItem("Van");
        vehiculo.addItem("Camioneta");
        vehiculo.addItem("Auto Estandar");
        vehiculo.addItem("Auto Compacto");
        vehiculo.addItem("Motocicleta");
        buttonOK = new JButton("Ok");
        buttonOK.addActionListener(control);
        pan2.add(buttonOK);
        buttonLiberar = new JButton("Liberar");
        buttonLiberar.addActionListener(control);
        pan2.add(buttonLiberar);
        buttonInforme = new JButton("Generar Informe");
        buttonInforme.addActionListener(control);
        pan3.add(buttonInforme);
        buttonTarifa = new JButton("Modificar Tarifa");
        buttonTarifa.addActionListener(control);
        pan3.add(buttonTarifa);
        //panel =new JPanel(new FlowLayout(FlowLayout.CENTER));
        add( "North",pan0);
        add( "West",pan1);
        add( "Center",pan2);
        add( "South",pan3);
        setLocationRelativeTo(null);
    }

    public String getTxtPlaca()  {
        String placaS = placasIn.getText();
        placaS = placaS.toUpperCase();          //Pasando a mayusculas
        return placaS;
    }
    
    public JComboBox getVehiculo() {
        return vehiculo;
    }
    
    public void clearTxtField(){
        placasIn.setText("");
    }

}
