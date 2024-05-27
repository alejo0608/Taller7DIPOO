package uniandes.dpoo.taller7.interfaz2;

import javax.swing.*;
import java.awt.*;

public class TopPanel extends JPanel {
    
    public TopPanel() {
        setLayout(new FlowLayout(FlowLayout.LEFT));
        
        JLabel sizeLabel = new JLabel("Tamaño");
        JComboBox<String> sizeComboBox = new JComboBox<>(new String[] { "5x5", "6x6", "7x7" });
        
        JLabel difficultyLabel = new JLabel("Dificultad");
        JRadioButton easyRadioButton = new JRadioButton("Fácil");
        JRadioButton mediumRadioButton = new JRadioButton("Medio");
        JRadioButton hardRadioButton = new JRadioButton("Difícil");
        
        ButtonGroup difficultyGroup = new ButtonGroup();
        difficultyGroup.add(easyRadioButton);
        difficultyGroup.add(mediumRadioButton);
        difficultyGroup.add(hardRadioButton);
        
        add(sizeLabel);
        add(sizeComboBox);
        add(difficultyLabel);
        add(easyRadioButton);
        add(mediumRadioButton);
        add(hardRadioButton);
    }
}
