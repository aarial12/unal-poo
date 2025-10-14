package Figuras;

public class Piramide extends FiguraGeometrica{
    private double apotema;
    private double altura;
    private double base;

    public Piramide(double apotema, double altura, double base){
        this.apotema = apotema;
        this.altura = altura;
        this.base = base;
        this.setVolumen(calcularVolumen());
        this.setSuperficie(calcularSuperficie());
    }

    public double calcularVolumen(){
        return ((Math.pow(base, 2) * altura) / 3);
    }

    public double calcularSuperficie(){
        double areaA = Math.pow(base, 2);
        double areaB = 2 * base * apotema;
        return areaA + areaB;
    }

}
