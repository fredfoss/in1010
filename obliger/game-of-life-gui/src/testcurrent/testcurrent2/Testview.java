import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Testview {
  public static void main(String[] args) {

    JFrame window;
    JPanel panel, console, grid;
    JButton[][] celles = new JButton[10][10]; // JButton[antallRader][antallKolonner]
    JLabel status;
    JButton startStopButton;
    JButton exitButton;

    /* Angi standard Swing-utseendet */
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
    console.setLayout(new FlowLayout()); // Changed layout to FlowLayout
    panel.add(console, BorderLayout.NORTH);

    status = new JLabel("Velg en rute eller noe");
    console.add(status); // Added status label to console panel

    startStopButton = new JButton("Start/Stop");
    startStopButton.addActionListener(new StartHandler());
    console.add(startStopButton); // Added startStopButton to console panel

    exitButton = new JButton("Avslutt");
    exitButton.addActionListener(new StopHandler());
    console.add(exitButton); // Added exitButton to console panel

    grid = new JPanel();
    grid.setLayout(new GridLayout(10, 10));
    for (int rx = 0; rx < 10; ++rx) {
      for (int kx = 0; kx < 10; ++kx) {
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
}
