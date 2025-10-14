package Figuras;

public class Esfera extends FiguraGeometrica{
    private double radio;

    public Esfera(double radio){
        this.radio = radio;
        this.setVolumen(calcularVolumen());
        this.setSuperficie(calcularSuperficie());
    }

    public double calcularVolumen(){
        return (1.3333 * Math.PI * Math.pow(this.radio, 3));
    }

    public double calcularSuperficie(){
        return (4 * Math.PI * Math.pow(radio, 2));
    }
}
