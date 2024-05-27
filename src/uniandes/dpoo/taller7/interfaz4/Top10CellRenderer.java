package uniandes.dpoo.taller7.interfaz4;

import uniandes.dpoo.taller7.modelo.RegistroTop10;

import javax.swing.*;
import java.awt.*;

public class Top10CellRenderer extends JPanel implements ListCellRenderer<RegistroTop10> {
    private JLabel rankLabel;
    private JLabel nameLabel;
    private JLabel scoreLabel;

    public Top10CellRenderer() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;

        rankLabel = new JLabel();
        nameLabel = new JLabel();
        scoreLabel = new JLabel();

        rankLabel.setFont(new Font("Serif", Font.BOLD, 16));
        nameLabel.setFont(new Font("Serif", Font.BOLD, 16));
        scoreLabel.setFont(new Font("Serif", Font.BOLD, 16));

        gbc.gridx = 0;
        gbc.weightx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(rankLabel, gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        add(nameLabel, gbc);

        gbc.gridx = 2;
        gbc.weightx = 1;
        gbc.anchor = GridBagConstraints.EAST;
        add(scoreLabel, gbc);
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends RegistroTop10> list, RegistroTop10 value, int index, boolean isSelected, boolean cellHasFocus) {
        rankLabel.setText(String.format("#%d", index + 1));
        nameLabel.setText(value.darNombre());
        scoreLabel.setText(String.format("%d puntos", value.darPuntos()));

        // Cambiar color según la posición
        if (index < 3) {
            rankLabel.setForeground(new Color(64, 145, 108)); // Verde oscuro
            nameLabel.setForeground(new Color(64, 145, 108)); // Verde oscuro
            scoreLabel.setForeground(new Color(64, 145, 108)); // Verde oscuro
        } else {
            rankLabel.setForeground(Color.BLACK);
            nameLabel.setForeground(Color.BLACK);
            scoreLabel.setForeground(Color.BLACK);
        }

        if (isSelected) {
        	setBackground(new Color(255, 253, 208));
        } else {
            setBackground(list.getBackground());
        }

        return this;
    }
}










