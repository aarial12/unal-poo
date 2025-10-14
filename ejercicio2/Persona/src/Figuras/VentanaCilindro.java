package Figuras;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class VentanaCilindro extends JFrame implements ActionListener{

    private Container contenedor;
    private JLabel radio, altura, volumen, superficie;
    private JTextField campoRadio, campoAltura;
    private JButton calcular;

    public VentanaCilindro() {
        inicio();
        setTitle("Cilindro");
        setSize(280,210);
        setLocationRelativeTo(null);
        setResizable(false);  
    }

    private void inicio() {
        contenedor = getContentPane();
        contenedor.setLayout(null);

        radio = new JLabel("Radio:");
        radio.setBounds(10, 10, 80, 25);
        contenedor.add(radio);

        campoRadio = new JTextField();
        campoRadio.setBounds(100, 10, 160, 25);
        contenedor.add(campoRadio);

        altura = new JLabel("Altura:");
        altura.setBounds(10, 40, 80, 25);
        contenedor.add(altura);

        campoAltura = new JTextField();
        campoAltura.setBounds(100, 40, 160, 25);
        contenedor.add(campoAltura);

        calcular = new JButton("Calcular");
        calcular.setBounds(10, 80, 100, 25);
        calcular.addActionListener(this);
        contenedor.add(calcular);

        volumen = new JLabel("Volumen:");
        volumen.setBounds(10, 120, 250, 25);
        contenedor.add(volumen);

        superficie = new JLabel("Superficie:");
        superficie.setBounds(10, 150, 250, 25);
        contenedor.add(superficie);

    }

    public void actionPerformed(ActionEvent e) {
        boolean error = false;
        double radio, altura = 0;

        try{
        
            radio = Double.parseDouble(campoRadio.getText());
            altura = Double.parseDouble(campoAltura.getText());
            Cilindro cilindro = new Cilindro(radio, altura);
            volumen.setText("Volumen: " + String.format("%.2f", cilindro.getVolumen()) + " CM3");
            superficie.setText("Superficie: " + String.format("%.2f", cilindro.getSuperficie()) + " CM2");
        
        }catch(Exception ex){
            error = true;
        }finally {
            if (error) {
                JOptionPane.showMessageDialog(null, "Error en los datos", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

}
