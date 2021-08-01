/* Integrantes:
  Carmona D'amico Ramiro
  Hernandez de la Rosa Manuel
  Padilla Rosete Ricardo
  Santiago Porras David*/

package Vista;

import Control.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class VLogin extends JFrame{
    private JFrame      frame;
    private JLabel      lblLogin,lblUser,lblPass;
    private JTextField  txtUser;
    private JPasswordField passField;       //Como un JTextField pero con los métodos apropiados para encriptar la contrasenna,etc
    private JButton     btnLogin;
    private JPanel      pan0,pan1,pan2,pan3;
    
    CLogin controlador;
    public VLogin(){
        buildVentana();
    }
    public void iniComponents(){ //Diseñando los componentes de la GUI
        pan0 = new JPanel();    pan1= new JPanel();    pan2= new JPanel();
        pan3 = new JPanel();
        //Poniendo mi imagen en mi pan0
        Icon usr = new ImageIcon("login2.png");
        lblLogin = new JLabel("",usr,SwingConstants.LEFT);
        lblLogin.setToolTipText("Imagen de login");
        pan0.add(lblLogin);
        //Poniendo las demas cosas PAN1
        lblUser = new JLabel("username");
        txtUser = new JTextField("",10);
        pan1.add(lblUser);
        pan1.add(txtUser);

        //Poniendo_todo en mi pan2
        lblPass = new JLabel("password");
        passField = new JPasswordField("",10);

        pan2.add(lblPass);
        pan2.add(passField);
        //Poniendo_todo en mi pan3
        btnLogin = new JButton("Login");
      
        pan3.add(btnLogin);
    }
    public void buildVentana(){
        iniComponents();
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.add(pan0,BorderLayout.NORTH);
        frame.add(pan1);
        frame.add(pan2);
        frame.add(pan3,BorderLayout.EAST);
        frame.pack();
        frame.setTitle("Login");
        frame.setResizable(false);
        frame.setSize(300,300);
        frame.setLocationRelativeTo(null);//ponerlo al centro
    }
    public void addLoginListener(ActionListener listenLogin){ //para saber si el boton esta presionado
        btnLogin.addActionListener(listenLogin);
    }
    public String getNombreUsuario(){
        return txtUser.getText();
    }
    public String getPass(){
        String pass = new String(passField.getPassword());
        return pass;
    }
    
    public void setVisible2(boolean op){
        frame.setVisible(op);
    }
}