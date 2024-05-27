package uniandes.dpoo.taller7.interfaz4;

import javax.imageio.ImageIO;
import javax.swing.*;

import uniandes.dpoo.taller7.modelo.Tablero;
import uniandes.dpoo.taller7.modelo.Top10;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class GameBoardPanel extends JPanel {
    private int gridSize = 5; 
    private ImageIcon lightIcon;
    private Tablero tablero; 
    private BottomPanel bottomPanel;
    private Top10 top10;
    private static final String IMAGE_PATH = "juegoTaller7.jpg";

    public GameBoardPanel(Tablero tablero, BottomPanel bottomPanel, Top10 top10) {
        this.tablero = tablero;
        this.bottomPanel = bottomPanel;
        this.top10 = top10;

        // Cargar el icono de la luz desde el classpath
        InputStream imageUrl = getClass().getClassLoader().getResourceAsStream(IMAGE_PATH);
        if (imageUrl != null) {
            try {
                lightIcon = new ImageIcon(ImageIO.read(imageUrl));
            } catch (IOException e) {
                e.printStackTrace();
                System.err.println("No se pudo cargar la imagen desde: " + imageUrl);
            }
        } else {
            System.err.println("No se pudo encontrar la imagen en: " + IMAGE_PATH);
        }

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                handleMouseClick(e);
            }
        });
    }

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }

    public void setGridSize(int size) {
        this.gridSize = size;
        tablero = new Tablero(size); 
        repaint(); // Redibuja el tablero cuando cambia el tamaño
    }

    private void handleMouseClick(MouseEvent e) {
        int cellSize = Math.min(getWidth(), getHeight()) / gridSize;
        int row = e.getY() / cellSize;
        int col = e.getX() / cellSize;

        if (row < gridSize && col < gridSize) {
            tablero.jugar(row, col);
            bottomPanel.updateMoves(tablero.darJugadas()); // Actualiza el contador de jugadas
            repaint();

            if (tablero.tableroIluminado()) {
                int score = tablero.calcularPuntaje();
                JOptionPane.showMessageDialog(this, "¡Has ganado el juego! Puntaje: " + score);
                String playerName = bottomPanel.getPlayerName();
                if (top10.esTop10(score)) {
                    top10.agregarRegistro(playerName, score);
                }
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(255, 255, 153)); // Color de las celdas del tablero
        
        int cellSize = Math.min(getWidth(), getHeight()) / gridSize;

        for (int row = 0; row < gridSize; row++) {
            for (int col = 0; col < gridSize; col++) {
                int x = col * cellSize;
                int y = row * cellSize;
                g2d.fillRect(x, y, cellSize, cellSize);
                g2d.setColor(Color.BLACK);
                g2d.drawRect(x, y, cellSize, cellSize);
                g2d.setColor(new Color(255, 255, 153));
                
                // Dibujar el icono en el centro de la celda
                if (tablero.darTablero()[row][col] && lightIcon != null) {
                    Image scaledImage = lightIcon.getImage().getScaledInstance(cellSize, cellSize, Image.SCALE_SMOOTH);
                    ImageIcon scaledIcon = new ImageIcon(scaledImage);
                    scaledIcon.paintIcon(this, g2d, x, y);
                }
            }
        }
    }
}

