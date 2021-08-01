/* Integrantes:
  Carmona D'amico Ramiro
  Hernandez de la Rosa Manuel
  Padilla Rosete Ricardo
  Santiago Porras David*/

package Modelo;

public class Hora {
    private int h;
    private int m;
    
    public Hora(int h, int m){
        this.h=h;
        this.m=m;
    }
    
    public boolean comprobarHora(int hora){
        return hora>=0 && hora<24;
    }
    
    public boolean comprobarMinuto(int minuto){
        return minuto >=0 && minuto<60;
    }
    
    public int getHora(){
        return h;
    }
    
    public int getMinuto(){
        return m;
    }
    
    public void setHora(int h){
        this.h=h;
    }
    
    public void setMinuto(int m){
        this.m=m;
    }
    
    public int returnDiferenciaHoras(int h1, int m1, int h2, int m2){//Regresa la diferencia entre las horas, o regresa -1 si esta mal el formato
        boolean ban=false;
        if (h2 >= 0 && h2 < 24 && m2 >= 0 && m2 < 60) {
                    if (h2 >= h1) {
                        if (h2 > h1) {
                            if (m2 > m1) {
                                h2 -= h1;
                                m2 -= m1;
                            } else {
                                if (m2 < m1) {
                                    h2 = h2 - h1 - 1;
                                    m2 = m2 - m1 + 60;
                                } else {
                                    h2 -= h1;
                                    m2 = 0;
                                }
                            }
                            ban = true;
                        } else {
                            if (m2 == m1) {
                                ban = false;
                            } else {
                                if (m2 > m1) {
                                    h2 = 0;
                                    m2 -= m1;
                                    ban = true;
                                } else {
                                    ban = false;
                                }
                            }
                        }
                    } else {
                        ban = false;
                    }
                } else {
                    ban = false;
                }
        if(ban==true)
            return m2 + (h2 * 60);
        else 
            return -1;
    }
    
    public boolean compararHoras(int hora, int minuto){
        if(comprobarHora(hora)==true && comprobarMinuto(minuto)==true){
            if(h<hora){
                return true;
            }else{
                if(h==hora){
                    if(minuto<m)
                        return false;
                    else
                        return true;
                }else
                    return false;
            }
            
        }
        return false;
    }
    
}
