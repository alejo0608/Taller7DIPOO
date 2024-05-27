package uniandes.dpoo.taller7.interfaz3;

import javax.swing.*;
import java.awt.*;

public class GameBoardPanel extends JPanel {
    
    private int gridSize = 5; // Tamaño inicial del tablero 5x5
    
    public GameBoardPanel() {
        // Configura el panel según sea necesario
    }
    
    public void setGridSize(int size) {
        this.gridSize = size;
        repaint(); // Redibuja el tablero cuando cambia el tamaño
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.YELLOW); // Color de las celdas del tablero
        
        int cellSize = Math.min(getWidth(), getHeight()) / gridSize;
        
        for (int row = 0; row < gridSize; row++) {
            for (int col = 0; col < gridSize; col++) {
                int x = col * cellSize;
                int y = row * cellSize;
                g2d.fillRect(x, y, cellSize, cellSize);
                g2d.setColor(Color.BLACK);
                g2d.drawRect(x, y, cellSize, cellSize);
                g2d.setColor(Color.YELLOW);
            }
        }
    }
}
