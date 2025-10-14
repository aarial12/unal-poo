package Figuras;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class VentanaPrincipal extends JFrame implements ActionListener{

    private Container contenedor;
    private JLabel titulo;
    private JButton cilindro, esfera, piramide;

    public VentanaPrincipal() {
        inicio();
        setTitle("Figuras Geometricas");
        setSize(300,200);
        setLocationRelativeTo(null);
        setResizable(false);  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void inicio() {
        contenedor = getContentPane();
        contenedor.setLayout(null);

        titulo = new JLabel("Seleccione una figura:");
        titulo.setBounds(10, 10, 200, 25);
        contenedor.add(titulo);

        cilindro = new JButton("Cilindro");
        cilindro.setBounds(10, 50, 100, 25);
        cilindro.addActionListener(this);
        contenedor.add(cilindro);

        esfera = new JButton("Esfera");
        esfera.setBounds(150, 50, 100, 25);
        esfera.addActionListener(this);
        contenedor.add(esfera);

        piramide = new JButton("Piramide");
        piramide.setBounds(10, 90, 100, 25);
        piramide.addActionListener(this);
        contenedor.add(piramide);

    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == cilindro){
            VentanaCilindro vc = new VentanaCilindro();
            vc.setVisible(true);
        }
        if(e.getSource() == esfera){
            VentanaEsfera ve = new VentanaEsfera();
            ve.setVisible(true);
        }
        if(e.getSource() == piramide){
            VentanaPiramide vp = new VentanaPiramide();
            vp.setVisible(true);
        }
    }
}
