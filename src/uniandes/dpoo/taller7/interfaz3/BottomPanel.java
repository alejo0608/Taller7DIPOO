package uniandes.dpoo.taller7.interfaz3;

import javax.swing.*;
import java.awt.*;

public class BottomPanel extends JPanel {
    
    public BottomPanel() {
        setLayout(new FlowLayout(FlowLayout.LEFT));
        
        JLabel movesLabel = new JLabel("Jugadas:");
        JTextField movesField = new JTextField("0", 5);
        movesField.setEditable(false);
        
        JLabel playerLabel = new JLabel("Jugador:");
        JTextField playerField = new JTextField(10);
        playerField.setEditable(false);
        
        add(movesLabel);
        add(movesField);
        add(playerLabel);
        add(playerField);
    }
}
