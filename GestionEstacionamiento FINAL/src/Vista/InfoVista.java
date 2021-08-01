/* Integrantes:
  Carmona D'amico Ramiro
  Hernandez de la Rosa Manuel
  Padilla Rosete Ricardo
  Santiago Porras David*/

package Vista;

import javax.swing.*;
import java.awt.*;
import Control.*;

public class InfoVista extends JFrame {
    private JLabel marca, modelo, color, placas, hora,minuto,i,j,permanencia;
    private JPanel pan1, pan2, pan3;

    public InfoVista() {
        super("Datos de vehiculo");
        setLayout(new BorderLayout(2,2));
        initComponents();
        setLocation(500, 250);
        setSize(500,90);
        setResizable(false);
    }

    public void initComponents() {
        pan1 = new JPanel(); pan2 = new JPanel(); pan3 = new JPanel();
        marca = new JLabel("Marca :");
        pan1.add(marca);
        modelo = new JLabel("Modelo: ");
        pan1.add(modelo);
        color = new JLabel("Color :");
        pan1.add(color);
        placas = new JLabel("Placas: ");
        pan1.add(placas);
        hora = new JLabel("Hora de llegada: ");
        pan2.add(hora);
        minuto = new JLabel("Minuto: ");
        pan2.add(minuto);
        i = new JLabel("Posicion i: ");
        pan2.add(i);
        j=new JLabel("Posicion j: ");
        pan2.add(j);
        permanencia=new JLabel("Permanencia: ");
        pan2.add(permanencia);
        add( "North",pan1);
        add( "Center",pan2);
    }

    public void setMarca(String marca) {
        String mensaje = "Marca: " + marca;         //Se crea una variable local para poder concatenar las variables
        this.marca.setText(mensaje);                //unica manera que se pensó
    }

    public void setModelo(String modelo) {
        String mensaje = "Modelo: " + modelo;
        this.modelo.setText(mensaje);
    }

    public void setColor(String color) {
        String mensaje = "Color: " + color;
        this.color.setText(mensaje);
    }

    public void setPlacas(String placas) {
        String mensaje = "Placas: " + placas;
        this.placas.setText(mensaje);
    }
    
    public void setHora(String hora){
        String mensaje ="Hora: "+hora;
        this.hora.setText(mensaje);
    }
    
    public void setMinuto(String minuto){
        String mensaje ="Minuto: "+minuto;
        this.minuto.setText(mensaje);
    }
    
    public void setI(String i){
        String mensaje = "Posicion i: "+i;
        this.i.setText(mensaje);
    }
    
    public void setJ(String j){
        String mensaje = " j: "+j;
        this.j.setText(mensaje);
    }
    
    public void setPermanencia(int h, int m) {
        if (m<0){
            m=60+m;
            h=h-1;
        }
        String mensaje = "Permanencia: " + h+"hrs. "+ m+" min.";         //Se imprime el tiempo de permanencia
        this.permanencia.setText(mensaje);                
    }
    
}
