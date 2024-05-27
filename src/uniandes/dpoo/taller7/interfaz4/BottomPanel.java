package uniandes.dpoo.taller7.interfaz4;

import javax.swing.*;
import java.awt.*;

public class BottomPanel extends JPanel {
    private JTextField movesField;
    private JTextField playerField;

    public BottomPanel() {
        setLayout(new FlowLayout(FlowLayout.LEFT));
        setBackground(new Color(204, 204, 255));

        JLabel movesLabel = new JLabel("Jugadas:");
        movesField = new JTextField("0", 5);
        movesField.setEditable(false);

        JLabel playerLabel = new JLabel("Jugador:");
        playerField = new JTextField(10);
        playerField.setEditable(false);

        add(movesLabel);
        add(movesField);
        add(playerLabel);
        add(playerField);
    }

    public void setPlayerName(String name) {
        playerField.setText(name);
    }

    public String getPlayerName() {
        return playerField.getText();
    }

    public void resetMoves() {
        movesField.setText("0");
    }

    public void updateMoves(int moves) {
        movesField.setText(String.valueOf(moves));
    }
}


