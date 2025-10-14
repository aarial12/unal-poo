package ejercicio1.src.Notas;

public class Notas {
    double[] listanotas;

    public Notas() {
        listanotas = new double[5];
    }

    double calcularPromedio() {
        double suma = 0.0;
        for (int i = 0; i < listanotas.length; i++) {
            suma += listanotas[i];
        }

        return (suma / listanotas.length);
    }

    double calcularDesviacion() {
        double promedio = calcularPromedio();
        double sumatoria = 0;
        for (int i = 0; i < listanotas.length; i++) {
            sumatoria += Math.pow((listanotas[i] - promedio), 2);
        }
        return Math.sqrt(sumatoria / listanotas.length);
    }

    double notaMayor() {
        double mayor = listanotas[0];
        for (int i = 1; i < listanotas.length; i++) {
            if (listanotas[i] > mayor) {
                mayor = listanotas[i];
            }
        }
        return mayor;
    }

    double notaMenor() {
        double menor = listanotas[0];
        for (int i = 1; i < listanotas.length; i++) {
            if (listanotas[i] < menor) {
                menor = listanotas[i];
            }
        }
        return menor;
    }

}

