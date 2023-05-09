import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameOfLifeGUI extends JFrame {

  private static final int CELL_SIZE = 10;
  private static final Color DEAD_COLOR = Color.WHITE;
  private static final Color ALIVE_COLOR = Color.BLACK;

  private final Rutenett rutenett;
  private final JButton startButton;
  private final JButton stopButton;
  private final JButton resetButton;
  private final JPanel gridPanel;

  public GameOfLifeGUI(Rutenett rutenett) {
    this.rutenett = rutenett;

    // Oppsett av vinduet
    setTitle("Game of Life");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Oppsett av knapper
    startButton = new JButton("Start");
    stopButton = new JButton("Stop");
    resetButton = new JButton("Reset");

    // Oppsett av grid panel
    gridPanel = new JPanel(new GridLayout(rutenett.antRader, rutenett.antKolonner));
    gridPanel.setPreferredSize(
        new Dimension(rutenett.antKolonner * CELL_SIZE, rutenett.antRader * CELL_SIZE));

    // Legg til knapper og grid panel til vinduet
    add(startButton, BorderLayout.NORTH);
    add(stopButton, BorderLayout.SOUTH);
    add(resetButton, BorderLayout.WEST);
    add(gridPanel, BorderLayout.CENTER);

    // Legg til lyttere til knappene
    startButton.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            // Start spillet
          }
        });

    stopButton.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            // Stopp spillet
          }
        });

    resetButton.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            // Reset spillet
          }
        });

    // Tegn rutene i grid panel
    for (int i = 0; i < rutenett.antRader; i++) {
      for (int j = 0; j < rutenett.antKolonner; j++) {
        JPanel cellPanel =
            new JPanel() {
              @Override
              public void paintComponent(Graphics g) {
                super.paintComponent(g);

                // Tegn ruten
                if (rutenett.hentCelle(i, j).erLevende()) {
                  g.setColor(ALIVE_COLOR);
                } else {
                  g.setColor(DEAD_COLOR);
                }
                g.fillRect(0, 0, getWidth(), getHeight());
              }
            };

        cellPanel.setPreferredSize(new Dimension(CELL_SIZE, CELL_SIZE));
        gridPanel.add(cellPanel);
      }
    }

    // Oppdater visningen
    pack();
    setVisible(true);
  }

  public void oppdater() {
    // Oppdater rutene i grid panel
    for (int i = 0; i < rutenett.antRader; i++) {
      for (int j = 0; j < rutenett.antKolonner; j++) {
        JPanel cellPanel = (JPanel) gridPanel.getComponent(i * rutenett.antKolonner + j);
        cellPanel.repaint();
      }
    }
  }
}
