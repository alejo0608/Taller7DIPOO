package uniandes.dpoo.taller7.interfaz1;

import javax.swing.JFrame;

public class VentanaPrincipal extends JFrame {

    public VentanaPrincipal() {
        setTitle("Juego de LightsOut");
        setSize(800, 600); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        VentanaPrincipal app = new VentanaPrincipal();
        app.setVisible(true);
    }
}
