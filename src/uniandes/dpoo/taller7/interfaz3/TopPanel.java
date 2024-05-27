package uniandes.dpoo.taller7.interfaz3;

import javax.swing.*;
import java.awt.*;

public class TopPanel extends JPanel {
    
    private JComboBox<String> sizeComboBox;
    private GameBoardPanel gameBoardPanel;
    
    public TopPanel(GameBoardPanel gameBoardPanel) {
        this.gameBoardPanel = gameBoardPanel;
        setLayout(new FlowLayout(FlowLayout.LEFT));
        
        JLabel sizeLabel = new JLabel("Tamaño");
        sizeComboBox = new JComboBox<>(new String[] { "5x5", "6x6", "7x7" });
        sizeComboBox.addActionListener(e -> updateGridSize());
        
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
    
    private void updateGridSize() {
        String selectedSize = (String) sizeComboBox.getSelectedItem();
        if (selectedSize != null) {
            int size = Integer.parseInt(selectedSize.split("x")[0]);
            gameBoardPanel.setGridSize(size);
        }
    }
}

