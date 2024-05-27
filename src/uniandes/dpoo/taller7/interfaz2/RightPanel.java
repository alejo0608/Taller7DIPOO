package uniandes.dpoo.taller7.interfaz2;

import javax.swing.*;
import java.awt.*;

public class RightPanel extends JPanel {
    
    public RightPanel() {
        setLayout(new GridLayout(4, 1, 5, 5));
        
        JButton newButton = new JButton("NUEVO");
        JButton restartButton = new JButton("REINICIAR");
        JButton top10Button = new JButton("TOP-10");
        JButton changePlayerButton = new JButton("CAMBIAR JUGADOR");
        
        add(newButton);
        add(restartButton);
        add(top10Button);
        add(changePlayerButton);
    }
}
