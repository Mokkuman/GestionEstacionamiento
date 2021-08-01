/* Integrantes:
  Carmona D'amico Ramiro
  Hernandez de la Rosa Manuel
  Padilla Rosete Ricardo
  Santiago Porras David*/
package Vista;
import javax.swing.*;
import java.awt.*;
import java.io.*;

public class MostrarReporteD extends JFrame {
    JLabel titulo;
    JTextArea area;
    JScrollPane jScrollPane;
    JPanel pan1, pan2;

    public MostrarReporteD() {
        super("Reporte del estacionamiento Todos Cabemos");
        setLayout(new BorderLayout());
        initComponents();
        setLocation(525, 300);
        setSize(450, 250);
        setResizable(false);
    }

    public void initComponents() {
        pan1 = new JPanel();
        titulo = new JLabel("Reporte del dia");
        pan1.add(titulo);

        pan2 = new JPanel();
        area = new JTextArea("  Marca      Modelo       Color      Placas\n", 10, 25);
        jScrollPane = new JScrollPane(area);
        pan2.add(jScrollPane);

        add("North", pan1);
        add("Center", pan2);

    }

    public void setTitulo() {
        this.area.setText("Marca      Modelo       Color         Placas       Hora      Minutos\n");
    }

    public void setArea(String linea) {
        this.area.append(linea + "\n");
    }

}
