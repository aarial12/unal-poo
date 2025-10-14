package Figuras;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class VentanaPiramide extends JFrame implements ActionListener{

    private Container contenedor;
    private JLabel radio, altura, apotema, volumen, superficie;
    private JTextField campoRadio, campoAltura, campoApotema;
    private JButton calcular;

    public VentanaPiramide() {
        inicio();
        setTitle("Piramide");
        setSize(280,250);
        setLocationRelativeTo(null);
        setResizable(false);  
    }

    private void inicio() {
        contenedor = getContentPane();
        contenedor.setLayout(null);

        radio = new JLabel("Altura:");
        radio.setBounds(10, 10, 80, 25);
        contenedor.add(radio);

        campoRadio = new JTextField();
        campoRadio.setBounds(100, 10, 160, 25);
        contenedor.add(campoRadio);

        altura = new JLabel("Base:");
        altura.setBounds(10, 40, 80, 25);
        contenedor.add(altura);

        campoAltura = new JTextField();
        campoAltura.setBounds(100, 40, 160, 25);
        contenedor.add(campoAltura);

        apotema = new JLabel("Apotema:");
        apotema.setBounds(10, 70, 80, 25);
        contenedor.add(apotema);

        campoApotema = new JTextField();
        campoApotema.setBounds(100, 70, 160, 25);
        contenedor.add(campoApotema);

        calcular = new JButton("Calcular");
        calcular.setBounds(10, 110, 100, 25);
        calcular.addActionListener(this);
        contenedor.add(calcular);

        volumen = new JLabel("Volumen:");
        volumen.setBounds(10, 150, 250, 25);
        contenedor.add(volumen);

        superficie = new JLabel("Superficie:");
        superficie.setBounds(10, 180, 250, 25);
        contenedor.add(superficie);

    }

    public void actionPerformed(ActionEvent e) {
        boolean error = false;
        double radio, altura, apotema = 0;

        try{
        
            radio = Double.parseDouble(campoRadio.getText());
            altura = Double.parseDouble(campoAltura.getText());
            apotema = Double.parseDouble(campoApotema.getText());
            Piramide piramide = new Piramide(radio, altura, apotema);
            volumen.setText("Volumen: " + String.format("%.2f", piramide.getVolumen()) + " CM3");
            superficie.setText("Superficie: " + String.format("%.2f", piramide.getSuperficie()) + " CM2");
        
        }catch(Exception ex){
            error = true;
        }finally {
            if (error) {
                JOptionPane.showMessageDialog(null, "Error en los datos", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

}

