/* Integrantes:
  Carmona D'amico Ramiro
  Hernandez de la Rosa Manuel
  Padilla Rosete Ricardo
  Santiago Porras David*/

package Control;

import Modelo.Estacionamiento;
import Vista.MenuPrincipalVista;
import java.awt.*;
import Vista.VLogin;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class CLogin {

    private VLogin vista;

    public CLogin(VLogin vista) {
        this.vista = vista;
        this.vista.addLoginListener(new LoginListener());
    }

    class LoginListener implements ActionListener {

        @Override//Esta es una clase que implementa ActionListener 
        public void actionPerformed(ActionEvent e) {
            String u = vista.getNombreUsuario(); // Obtiene el nombre de usuario del txt field
            String p = vista.getPass();// Obtiene contraseña del txt field
            if ("".equals(u) || "".equals(p)) { //Comparar que sea nulo para arrojar "ERROR"
                JOptionPane.showMessageDialog(null, "Dato(s) invalido(s)", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    BufferedReader archivo = new BufferedReader(new FileReader("loginS.txt"));//Apertura del archivo
                    String linea;//Lee linea completa del archivo
                    Boolean band = false;//Para evaluar datos correctos 
                    while ((linea = archivo.readLine()) != null) {
                        String[] split = linea.split(" "); //Split separa lineas de texto
                        if (u.equals(split[0]) && p.equals(split[1])) {
                            band = true;
                            vista.setVisible2(false);
                            //MenuPrincipal
                            Estacionamiento estacionamiento = new Estacionamiento("Todos Cabemos");     //Aqui instanciamos el estacionamiento y lo pasamos a MenuPrincipal
                            MenuPrincipalControl c1 = new MenuPrincipalControl(estacionamiento);
                            MenuPrincipalVista v1 = new MenuPrincipalVista(c1);
                            c1.setVista(v1);
                            v1.setVisible(true);
                            v1.setLocationRelativeTo(null);
                            v1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            break;
                        } else {
                            band = false;
                        }
                    }
                    if (!band) {
                        JOptionPane.showMessageDialog(null, "Dato(s) invalido(s)", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
    }
}
