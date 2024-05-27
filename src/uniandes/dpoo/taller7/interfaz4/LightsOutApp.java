package uniandes.dpoo.taller7.interfaz4;

import javax.swing.*;

import com.formdev.flatlaf.FlatLightLaf;

import uniandes.dpoo.taller7.modelo.Tablero;
import uniandes.dpoo.taller7.modelo.Top10;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class LightsOutApp extends JFrame {
    private Tablero tablero;
    private GameBoardPanel gameBoardPanel;
    private TopPanel topPanel;
    private BottomPanel bottomPanel;
    private Top10 top10;
    private Top10Manager top10Manager;

    public LightsOutApp() {
        // Configuración de la ventana principal
        setTitle("LightsOut");
        setSize(800, 600); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 
        setLayout(new BorderLayout());

        // Inicialización de la lógica del tablero
        tablero = new Tablero(5);
        bottomPanel = new BottomPanel();
        top10 = new Top10();
        top10Manager = new Top10Manager(top10);
        gameBoardPanel = new GameBoardPanel(tablero, bottomPanel, top10);
        
        // Cargar los registros al inicio
        top10Manager.loadTop10();

        // Creación de los paneles
        topPanel = new TopPanel(gameBoardPanel);
        RightPanel rightPanel = new RightPanel(tablero, gameBoardPanel, topPanel, bottomPanel, top10);

        // Añadir paneles
        add(topPanel, BorderLayout.NORTH);
        add(rightPanel, BorderLayout.EAST);
        add(bottomPanel, BorderLayout.SOUTH);
        add(gameBoardPanel, BorderLayout.CENTER);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                top10Manager.saveTop10();
            }
        });

    }

    public static void main(String[] args) {
        FlatLightLaf.install();
        LightsOutApp app = new LightsOutApp();
        app.setVisible(true);
    }
}






