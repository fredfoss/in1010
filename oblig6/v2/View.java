import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/** Controller */
public class View {
  // Sett variabler
  Controller controller;
  JFrame window;
  JPanel panel, console, grid;
  JButton[][] celles;
  JLabel status;
  JButton startStopButton, exitButton;

  // Stopp spillet
  class StopHandler implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      controller.endGame();
    }
  }

  // Hvilken celle du trykket på
  class GameSelector implements ActionListener {
    int rad, kol;

    GameSelector(int r, int k) {
      rad = r;
      kol = k;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      controller.userChoice(rad, kol);
    }
  }

  // View
  public View(Controller c, int antallRader, int antallKolonner) {
    controller = c;
    celles = new JButton[antallRader][antallKolonner];
    try {
      UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
    } catch (Exception e) {
      System.exit(9);
    }

    window = new JFrame("Game of Life");
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    panel = new JPanel();
    panel.setLayout(new BorderLayout());
    window.add(panel);

    console = new JPanel();
    console.setLayout(new FlowLayout());
    panel.add(console, BorderLayout.NORTH);

    status = new JLabel("Velg en rute eller noe");
    console.add(status);

    // Start/stop knapp
    startStopButton = new JButton("Start/Stop");
    startStopButton.addActionListener(new StartHandler());
    console.add(startStopButton);

    // Avslutt knapp
    exitButton = new JButton("Avslutt");
    exitButton.addActionListener(new StopHandler());
    console.add(exitButton);

    grid = new JPanel();
    grid.setLayout(new GridLayout(antallRader, antallKolonner));
    for (int rx = 0; rx < antallRader; ++rx) {
      for (int kx = 0; kx < antallKolonner; ++kx) {
        JButton b = new JButton(" ");
        celles[rx][kx] = b;
        b.setFont(new Font(Font.MONOSPACED, Font.BOLD, 30));
        b.addActionListener(new GameSelector(rx, kx));
        grid.add(b);
      }
    }
    panel.add(grid, BorderLayout.CENTER);

    window.pack();
    window.setSize(400, 400);
    window.setLocationRelativeTo(null);
    window.setVisible(true);

    status.setText("Antall levende:  " + 69 + "  ");
  }

  private static class StopHandler implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      System.exit(0);
    }
  }

  private static class StartHandler implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      // Do something when the Start button is clicked
    }
  }

  private static class GameSelector implements ActionListener {
    private int row;
    private int col;

    public GameSelector(int row, int col) {
      this.row = row;
      this.col = col;
    }

    public void actionPerformed(ActionEvent e) {
      // Do something with the selected cell
    }
  }

  void markChoise(int r, int k, char c) {
    celles[r][k].setText(Character.toString(c));
  }

  void showStatus(String text) {
    status.setText(text);
  }
}
