package uniandes.dpoo.taller7.interfaz4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

public class TopPanel extends JPanel {
    private JComboBox<String> sizeComboBox;
    private ButtonGroup difficultyGroup;
    private GameBoardPanel gameBoardPanel;

    public TopPanel(GameBoardPanel gameBoardPanel) {
        this.gameBoardPanel = gameBoardPanel;
        setLayout(new FlowLayout(FlowLayout.LEFT));
        setBackground(new Color(0, 122, 204)); // Color de fondo

        JLabel sizeLabel = new JLabel("Tamaño");
        sizeLabel.setForeground(Color.WHITE); // Color del texto

        sizeComboBox = new JComboBox<>(new String[]{"5x5", "6x6", "7x7"});
        sizeComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateGridSize();
            }
        });

        JLabel difficultyLabel = new JLabel("Dificultad");
        difficultyLabel.setForeground(Color.WHITE); // Color del texto

        JRadioButton easyRadioButton = new JRadioButton("Facil");
        easyRadioButton.setForeground(Color.WHITE);
        JRadioButton mediumRadioButton = new JRadioButton("Medio");
        mediumRadioButton.setForeground(Color.WHITE);
        JRadioButton hardRadioButton = new JRadioButton("Difícil");
        hardRadioButton.setForeground(Color.WHITE);

        difficultyGroup = new ButtonGroup();
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

    public int getSelectedSize() {
        String selectedSize = (String) sizeComboBox.getSelectedItem();
        return Integer.parseInt(selectedSize.split("x")[0]);
    }

    public int getSelectedDifficulty() {
        for (Enumeration<AbstractButton> buttons = difficultyGroup.getElements(); buttons.hasMoreElements(); ) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                switch (button.getText()) {
                    case "Fácil":
                        return 10; 
                    case "Medio":
                        return 20; 
                    case "Difícil":
                        return 30; 
                }
            }
        }
        return 10; // Por defecto, retornar facil
    }
}




