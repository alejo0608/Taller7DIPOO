package uniandes.dpoo.taller7.interfaz4;

import javax.swing.*;

import uniandes.dpoo.taller7.modelo.RegistroTop10;
import uniandes.dpoo.taller7.modelo.Tablero;
import uniandes.dpoo.taller7.modelo.Top10;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RightPanel extends JPanel implements ActionListener {
    private JButton newButton;
    private JButton restartButton;
    private JButton top10Button;
    private JButton changePlayerButton;
    private Tablero tablero;
    private GameBoardPanel gameBoardPanel;
    private TopPanel topPanel;
    private BottomPanel bottomPanel;
    private Top10 top10;
    private String playerName;

    public RightPanel(Tablero tablero, GameBoardPanel gameBoardPanel, TopPanel topPanel, BottomPanel bottomPanel, Top10 top10) {
        this.tablero = tablero;
        this.gameBoardPanel = gameBoardPanel;
        this.topPanel = topPanel;
        this.bottomPanel = bottomPanel;
        this.top10 = top10;

        setLayout(new GridLayout(4, 1, 5, 5));
        setBackground(Color.LIGHT_GRAY);

        newButton = new JButton("NUEVO");
        restartButton = new JButton("REINICIAR");
        top10Button = new JButton("TOP-10");
        changePlayerButton = new JButton("CAMBIAR JUGADOR");

        newButton.setBackground(new Color(204, 229, 255));
        restartButton.setBackground(new Color(204, 229, 255));
        top10Button.setBackground(new Color(204, 229, 255));
        changePlayerButton.setBackground(new Color(204, 229, 255));

        newButton.addActionListener(this);
        restartButton.addActionListener(this);
        top10Button.addActionListener(this);
        changePlayerButton.addActionListener(this);

        add(newButton);
        add(restartButton);
        add(top10Button);
        add(changePlayerButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == newButton) {
            crearNuevoTablero();
        } else if (e.getSource() == restartButton) {
            reiniciarTablero();
        } else if (e.getSource() == top10Button) {
            mostrarTop10();
        } else if (e.getSource() == changePlayerButton) {
            cambiarJugador();
        }
    }

    private void crearNuevoTablero() {
        int size = topPanel.getSelectedSize();
        int dificultad = topPanel.getSelectedDifficulty();
        tablero = new Tablero(size);
        tablero.desordenar(dificultad);
        gameBoardPanel.setTablero(tablero);
        gameBoardPanel.repaint();
        bottomPanel.resetMoves(); // Resetea el contador de jugadas
    }

    private void reiniciarTablero() {
        tablero.reiniciar();
        gameBoardPanel.repaint();
        bottomPanel.resetMoves(); // Resetea el contador de jugadas
    }

    private void mostrarTop10() {
        JDialog top10Dialog = new JDialog((Frame) null, "Top 10 Puntajes", true);
        top10Dialog.setSize(500, 400);
        top10Dialog.setLocationRelativeTo(null);

        DefaultListModel<RegistroTop10> listModel = new DefaultListModel<>();
        for (RegistroTop10 registro : top10.darRegistros()) {
            listModel.addElement(registro);
        }

        JList<RegistroTop10> list = new JList<>(listModel);
        list.setCellRenderer(new Top10CellRenderer());

        JScrollPane scrollPane = new JScrollPane(list);

        // Crear panel de encabezados
        JPanel headerPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;

        JLabel rankHeader = new JLabel("Posición");
        JLabel nameHeader = new JLabel("Nombre");
        JLabel scoreHeader = new JLabel("Puntos");

        rankHeader.setFont(new Font("Serif", Font.BOLD, 20));
        nameHeader.setFont(new Font("Serif", Font.BOLD, 20));
        scoreHeader.setFont(new Font("Serif", Font.BOLD, 20));

        gbc.gridx = 0;
        gbc.weightx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        headerPanel.add(rankHeader, gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        headerPanel.add(nameHeader, gbc);

        gbc.gridx = 2;
        gbc.weightx = 1;
        gbc.anchor = GridBagConstraints.EAST;
        headerPanel.add(scoreHeader, gbc);

        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.add(headerPanel, BorderLayout.NORTH);
        contentPanel.add(scrollPane, BorderLayout.CENTER);

        top10Dialog.setContentPane(contentPanel);
        top10Dialog.setVisible(true);
    }

    private void cambiarJugador() {
        String nombre = JOptionPane.showInputDialog(this, "Ingrese el nombre del jugador:");
        if (nombre != null && !nombre.trim().isEmpty()) {
            playerName = nombre.trim().toUpperCase().replace(";", "").substring(0, Math.min(3, nombre.length()));
            bottomPanel.setPlayerName(playerName);
        }
    }
}


