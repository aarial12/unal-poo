package ejercicio1.src.Notas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Ventana extends JFrame implements ActionListener {
    private Container contenedor;
    private JLabel nota1, nota2, nota3, nota4, nota5, promedio, desviacion, mayor, menor;
    private JTextField txtnota1, txtnota2, txtnota3, txtnota4, txtnota5;
    private JButton btncalcular, btnlimpiar;

    public Ventana() {
        inicio();
        setTitle("Notas");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void inicio() {
        contenedor = getContentPane();
        contenedor.setLayout(null);

        nota1 = new JLabel("Nota 1:");
        nota1.setBounds(10, 10, 80, 25);
        contenedor.add(nota1);

        txtnota1 = new JTextField();
        txtnota1.setBounds(100, 10, 160, 25);
        contenedor.add(txtnota1);

        nota2 = new JLabel("Nota 2:");
        nota2.setBounds(10, 40, 80, 25);
        contenedor.add(nota2);

        txtnota2 = new JTextField();
        txtnota2.setBounds(100, 40, 160, 25);
        contenedor.add(txtnota2);

        nota3 = new JLabel("Nota 3:");
        nota3.setBounds(10, 70, 80, 25);
        contenedor.add(nota3);

        txtnota3 = new JTextField();
        txtnota3.setBounds(100, 70, 160, 25);
        contenedor.add(txtnota3);

        nota4 = new JLabel("Nota 4:");
        nota4.setBounds(10, 100, 80, 25);
        contenedor.add(nota4);

        txtnota4 = new JTextField();
        txtnota4.setBounds(100, 100, 160, 25);
        contenedor.add(txtnota4);

        nota5 = new JLabel("Nota 5:");
        nota5.setBounds(10, 130, 80, 25);
        contenedor.add(nota5);

        txtnota5 = new JTextField();
        txtnota5.setBounds(100, 130, 160, 25);
        contenedor.add(txtnota5);

        btncalcular = new JButton("Calcular");
        btncalcular.setBounds(10, 170, 100, 25);
        btncalcular.addActionListener(this);
        contenedor.add(btncalcular);

        btnlimpiar = new JButton("Limpiar");
        btnlimpiar.setBounds(120, 170, 100, 25);
        btnlimpiar.addActionListener(this);
        contenedor.add(btnlimpiar);

        promedio = new JLabel("Promedio: ");
        promedio.setBounds(10, 210, 300, 25);
        contenedor.add(promedio);

        desviacion = new JLabel("Desviacion Estandar: ");
        desviacion.setBounds(10, 240, 300, 25);
        contenedor.add(desviacion);

        mayor = new JLabel("Nota Mayor: ");
        mayor.setBounds(10, 270, 300, 25);
        contenedor.add(mayor);

        menor = new JLabel("Nota Menor: ");
        menor.setBounds(10, 300, 300, 25);
        contenedor.add(menor);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btncalcular) {
            Notas notas = new Notas();
            try {
                notas.listanotas[0] = Double.parseDouble(txtnota1.getText());
                notas.listanotas[1] = Double.parseDouble(txtnota2.getText());
                notas.listanotas[2] = Double.parseDouble(txtnota3.getText());
                notas.listanotas[3] = Double.parseDouble(txtnota4.getText());
                notas.listanotas[4] = Double.parseDouble(txtnota5.getText());

                promedio.setText("Promedio: " + String.format("%.2f", notas.calcularPromedio()));
                desviacion.setText("Desviacion Estandar: " + String.format("%.2f", notas.calcularDesviacion()));
                mayor.setText("Nota Mayor: " + String.format("%.2f", notas.notaMayor()));
                menor.setText("Nota Menor: " + String.format("%.2f", notas.notaMenor()));
            } catch (NumberFormatException ex) {

                //Ejercicio extra propuesto por el libro
                JOptionPane.showMessageDialog(this, "Por favor ingrese valores numericos validos.");
            }
        } else if (e.getSource() == btnlimpiar) {
            txtnota1.setText("");
            txtnota2.setText("");
            txtnota3.setText("");
            txtnota4.setText("");
            txtnota5.setText("");
            promedio.setText("Promedio: ");
            desviacion.setText("Desviacion Estandar: ");
            mayor.setText("Nota Mayor: ");
            menor.setText("Nota Menor: ");
        }
    }

}
