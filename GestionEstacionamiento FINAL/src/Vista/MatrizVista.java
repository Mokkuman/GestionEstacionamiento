/* Integrantes:
  Carmona D'amico Ramiro
  Hernandez de la Rosa Manuel
  Padilla Rosete Ricardo
  Santiago Porras David*/

package Vista;

import java.awt.*;
import javax.swing.*;
import Control.*;

public class MatrizVista extends JFrame {

    private JButton b[][];
    private JPanel pIntruccion, pgBoton[], pInstruccion2;
    MatrizControl control;

    //Poner simbología
    public MatrizVista(MatrizControl control) {
        super("Estacionamiendo");
        this.control = control;
        setLayout(new GridLayout(7, 1));
        setLocation(400, 250);
        initComponentes();
        pack();
    }

    public void initComponentes() {
        b = new JButton[5][5];
        pgBoton = new JPanel[5];
        for (int i = 0; i < 5; i++) {
            pgBoton[i] = new JPanel(new FlowLayout(FlowLayout.CENTER));
            for (int j = 0; j < 5; j++) {
                b[i][j] = new JButton("Disponible");
                b[i][j].setSize(4, 4);
                b[i][j].addActionListener(control);
                pgBoton[i].add(b[i][j]);
                // 0-Van 1-Camionetas 2-Auto estandar 3-Auto Compacto 4-Motocicletas
                switch (i) {
                    case 0:
                        b[i][j].setBackground(Color.MAGENTA);//VAN
                        break;
                    case 1:
                        b[i][j].setBackground(Color.CYAN);//Camionetas
                        break;
                    case 2:
                        b[i][j].setBackground(Color.GREEN);//Auto estandar
                        break;
                    case 3:
                        b[i][j].setBackground(Color.YELLOW);//Auto compacto
                        break;
                    case 4:
                        b[i][j].setBackground(Color.ORANGE);//Motocicletas
                }
            }
        }
        pIntruccion = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pIntruccion.add(new JLabel("Selecciona un espacio"));
        pInstruccion2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pInstruccion2.add(new JLabel("Magenta - Van Cian - Camioneta Verde - Auto Estandar Amarillo - Auto Compacto Naranja - Motocicleta"));
        add(pIntruccion);
        add(pInstruccion2);
        for (int i = 0; i < 5; i++) {
            add(pgBoton[i]);
        }
    }

    public JButton getButton(int i, int j) {
        return b[i][j];
    }

    public void cambiarColor(JButton b, int i, int j) {
        if (b.getBackground() == Color.MAGENTA || b.getBackground() == Color.CYAN || b.getBackground() == Color.GREEN || b.getBackground() == Color.YELLOW || b.getBackground() == Color.ORANGE) {
            this.b[i][j].setBackground(Color.RED);
        }
    }

    public void actualizarMatriz() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (b[i][j].getBackground() == Color.RED && control.getEstacionamiento().getVehiculo(i, j).getPlacas().compareTo("") == 0) {
                    switch (i) {
                        case 0:
                            b[i][j].setBackground(Color.MAGENTA);//VAN
                            break;
                        case 1:
                            b[i][j].setBackground(Color.CYAN);//Camionetas
                            break;
                        case 2:
                            b[i][j].setBackground(Color.GREEN);//Auto estandar
                            break;
                        case 3:
                            b[i][j].setBackground(Color.YELLOW);//Auto compacto
                            break;
                        case 4:
                            b[i][j].setBackground(Color.ORANGE);//Motocicletas
                    }
                }
            }

        }
    }
}
