/* Integrantes:
  Carmona D'amico Ramiro
  Hernandez de la Rosa Manuel
  Padilla Rosete Ricardo
  Santiago Porras David*/

package Vista;

import javax.swing.*;
import java.awt.*;
import Control.*;

public class CambiarTarifaVista extends JFrame {
   private JLabel precio, horas;
   private JTextField precioInput;
   private JButton bActualizar;
   private CambiarTarifaControl control;

    public CambiarTarifaVista(CambiarTarifaControl control) {
        super("Cambiar Tarifa");
        this.control=control;
        setLayout(new FlowLayout());
        initComponents();
        setLocation(525, 300);
        pack();
        setResizable(false);
    }

    public void initComponents() {
        precio = new JLabel("Precio: ");
        precioInput = new JTextField("", 5);
        horas = new JLabel( "por minuto");
        bActualizar = new JButton("Actualizar");
        bActualizar.addActionListener(control);
        add(precio);
        add(precioInput);
        add(horas);
        add(bActualizar);
    }
    
    public JTextField getText(){
        return precioInput;
    }

    public void clearTxtField(){
        precioInput.setText("");
    }
    
}
