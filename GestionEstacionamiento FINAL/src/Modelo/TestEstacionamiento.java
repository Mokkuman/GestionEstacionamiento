/* Integrantes:
  Carmona D'amico Ramiro
  Hernandez de la Rosa Manuel
  Padilla Rosete Ricardo
  Santiago Porras David*/

package Modelo;

import javax.swing.*;
import Vista.*;
import Control.*;

public class TestEstacionamiento {
    public static void main(String[] args) {
        VLogin vl = new VLogin();
        Archivo.limpiar();
        CLogin cl = new CLogin(vl);
        
    }
}
