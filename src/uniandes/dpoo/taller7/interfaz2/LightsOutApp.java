package uniandes.dpoo.taller7.interfaz2;

import javax.swing.*;
import java.awt.*;

public class LightsOutApp extends JFrame {
    
    public LightsOutApp() {
        // Configuraci�n de la ventana principal
        setTitle("Juego de LightsOut");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 
        setLayout(new BorderLayout());
        
        // A�adir paneles
        add(new TopPanel(), BorderLayout.NORTH);
        add(new RightPanel(), BorderLayout.EAST);
        add(new BottomPanel(), BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        // Creaci�n y visualizaci�n de la ventana principal
        LightsOutApp app = new LightsOutApp();
        app.setVisible(true);
    }
}
