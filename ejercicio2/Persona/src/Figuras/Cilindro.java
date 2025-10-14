package Figuras;

public class Cilindro extends FiguraGeometrica{

    private double radio;
    private double altura;

    public Cilindro(double radio, double altura){
        this.radio = radio;
        this.altura = altura;
        this.setVolumen(calcularVolumen());
        this.setSuperficie(calcularSuperficie());
    }

    public double calcularVolumen(){
        return (Math.PI * Math.pow(this.radio, 2) * this.altura);
    }

    public double calcularSuperficie(){
        double areaA = 2 * Math.PI * radio * altura;
        double areaB = 2 * Math.PI * Math.pow(radio, 2);
        return areaA + areaB;
    }

}
