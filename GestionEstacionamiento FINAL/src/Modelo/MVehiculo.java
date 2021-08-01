/* Integrantes:
  Carmona D'amico Ramiro
  Hernandez de la Rosa Manuel
  Padilla Rosete Ricardo
  Santiago Porras David*/

package Modelo;

public abstract class MVehiculo {
    protected String marca;
    protected String modelo;
    protected String color;
    protected String placas;
    protected int i;
    protected int j;
    protected Hora hora;
    //Hora de llegada
    public MVehiculo(int i, int j){
        marca = "";
        modelo = "";
        color = "";
        placas ="";
        this.i = i;
        this.j = j;
    } 
    
    public MVehiculo(String marca, String modelo, String color, String placas, Hora hora){
        this.marca  = marca;
        this.modelo = modelo;
        this.color  = color;
        this.placas = placas;
        this.hora = hora;
    }
    public void addPosicion(int i, int j){
        this.i=i;
        this.j=j;
    }
    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getColor() {
        return color;
    }

    public String getPlacas() {
        return placas;
    }
    
    public int getI(){
        return i;
    }
    
    public int getJ(){
        return j;
    }

    public int getHora() {
        return hora.getHora();
    }

    public void setHora(int hora) {
        this.hora.setHora(hora);
    }

    public int getMinuto() {
        return hora.getMinuto();
    }

    public void setMinuto(int minuto) {
        hora.setMinuto(minuto); 
    }
    
    public Hora getHoraClase(){
        return hora;
    }
    
}
