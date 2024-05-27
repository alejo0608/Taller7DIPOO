package uniandes.dpoo.taller7.interfaz3;

import javax.swing.*;
import java.awt.*;

public class LightsOutApp extends JFrame {
    
    public LightsOutApp() {
        // Configuraci�n de la ventana principal
        setTitle("Juego de LightsOut");
        setSize(800, 600); // Establece el tama�o de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Asegura que la aplicaci�n se cierre al salir
        setLocationRelativeTo(null); // Centra la ventana en la pantalla
        setLayout(new BorderLayout());
        
        // Creaci�n de los paneles
        GameBoardPanel gameBoardPanel = new GameBoardPanel();
        TopPanel topPanel = new TopPanel(gameBoardPanel);
        RightPanel rightPanel = new RightPanel();
        BottomPanel bottomPanel = new BottomPanel();
        
        // A�adir paneles
        add(topPanel, BorderLayout.NORTH);
        add(rightPanel, BorderLayout.EAST);
        add(bottomPanel, BorderLayout.SOUTH);
        add(gameBoardPanel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        // Creaci�n y visualizaci�n de la ventana principal
        LightsOutApp app = new LightsOutApp();
        app.setVisible(true);
    }
}

