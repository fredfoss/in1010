import java.awt.*;
import javax.swing.*;

public class View extends JFrame {
  private Rutenett rutenett;
  private JButton startButton;
  private JButton stopButton;
  private JButton exitButton;
  private JPanel gridPanel;

  public View(Rutenett rutenett) {
    this.rutenett = rutenett;

    setTitle("Game of Life");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new BorderLayout());

    // Grid panel for rutenettet
    gridPanel = new JPanel();
    gridPanel.setLayout(new GridLayout(rutenett.antRader, rutenett.antKolonner, 1, 1));
    for (int i = 0; i < rutenett.antRader; i++) {
      for (int j = 0; j < rutenett.antKolonner; j++) {
        Celle celle = rutenett.hentCelle(i, j);
        JButton button = new JButton();
        button.setBackground(celle.erLevende() ? Color.WHITE : Color.BLACK);
        button.addActionListener(new CellListener(celle, button));
        gridPanel.add(button);
      }
    }
    add(gridPanel, BorderLayout.CENTER);

    // Button panel for start, stop, and exit buttons
    JPanel buttonPanel = new JPanel();
    startButton = new JButton("Start");
    startButton.addActionListener(new StartListener());
    buttonPanel.add(startButton);

    stopButton = new JButton("Stop");
    stopButton.addActionListener(new StopListener());
    buttonPanel.add(stopButton);

    exitButton = new JButton("Exit");
    exitButton.addActionListener(new ExitListener());
    buttonPanel.add(exitButton);

    add(buttonPanel, BorderLayout.SOUTH);

    pack();
    setVisible(true);
  }

  // Oppdaterer fargen på cellens knapp
  public void oppdaterCelleKnapp(Celle celle, JButton button) {
    button.setBackground(celle.erLevende() ? Color.WHITE : Color.BLACK);
  }

  // Lytter for celler i rutenettet
  private class CellListener implements ActionListener {
    private Celle celle;
    private JButton button;

    public CellListener(Celle celle, JButton button) {
      this.celle = celle;
      this.button = button;
    }

    public void actionPerformed(ActionEvent e) {
      celle.levende = !celle.erLevende();
      oppdaterCelleKnapp(celle, button);
    }
  }

  // Lytter for start-knapp
  private class StartListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      Controller.startSpill();
    }
  }

  // Lytter for stopp-knapp
  private class StopListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      Controller.stopSpill();
    }
  }

  // Lytter for avslutt-knapp
  private class ExitListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      System.exit(0);
    }
  }
}
