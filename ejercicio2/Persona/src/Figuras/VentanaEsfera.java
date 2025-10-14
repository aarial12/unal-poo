package Figuras;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class VentanaEsfera extends JFrame implements ActionListener{

    private Container contenedor;
    private JLabel radio, volumen, superficie;
    private JTextField campoRadio;
    private JButton calcular;

    public VentanaEsfera() {
        inicio();
        setTitle("Esfera");
        setSize(280,180);
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

        volumen = new JLabel("Volumen:");
        volumen.setBounds(10, 80, 250, 25);
        contenedor.add(volumen);

        calcular = new JButton("Calcular");
        calcular.setBounds(10, 50, 100, 25);
        calcular.addActionListener(this);
        contenedor.add(calcular);

        superficie = new JLabel("Superficie:");
        superficie.setBounds(10, 110, 250, 25);
        contenedor.add(superficie);

    }

    public void actionPerformed(ActionEvent e) {
        boolean error = false;
        double radio = 0;

        try{
        
            radio = Double.parseDouble(campoRadio.getText());
            Esfera esfera = new Esfera(radio);
            volumen.setText("Volumen: " + String.format("%.2f", esfera.getVolumen()) + " CM3");            
            superficie.setText("Superficie: " + String.format("%.2f", esfera.getSuperficie()) + " CM2");
        
        }catch(Exception ex){
            error = true;
        }finally {
            if (error) {
                JOptionPane.showMessageDialog(null, "Error en los datos", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

}