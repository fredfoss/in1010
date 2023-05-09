import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GameOfLifeView {
  private GameOfLifeModel model;
  private JFrame frame;
  private JPanel panel;
  private JButton[][] buttons;
  private JButton startButton;
  private JButton stopButton;
  private JButton quitButton;

  public GameOfLifeView(GameOfLifeModel model) {
    this.model = model;
    frame = new JFrame("Game of Life");
    panel = new JPanel(new GridLayout(model.getRutenett().length, model.getRutenett()[0].length));
    buttons = new JButton[model.getRutenett().length][model.getRutenett()[0].length];
    startButton = new JButton("Start");
    stopButton = new JButton("Stop");
    quitButton = new JButton("Quit");

    for (int i = 0; i < model.getRutenett().length; i++) {
      for (int j = 0; j < model.getRutenett()[0].length; j++) {
        buttons[i][j] = new JButton();
        buttons[i][j].setBackground(Color.BLACK);
        buttons[i][j].setOpaque(true);
        buttons[i][j].setBorderPainted(false);
        buttons[i][j].addActionListener(new CellButtonListener(i, j));
        panel.add(buttons[i][j]);
      }
    }

    startButton.addActionListener(new StartButtonListener());
    stopButton.addActionListener(new StopButtonListener());
    quitButton.addActionListener(new QuitButtonListener());

    JPanel buttonPanel = new JPanel(new FlowLayout());
    buttonPanel.add(startButton);
    buttonPanel.add(stopButton);
    buttonPanel.add(quitButton);

    frame.add(panel, BorderLayout.CENTER);
    frame.add(buttonPanel, BorderLayout.SOUTH);
    frame.pack();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }

  public void updateView() {
    for (int i = 0; i < model.getRutenett().length; i++) {
      for (int j = 0; j < model.getRutenett()[0].length; j++) {
        if (model.getRutenett()[i][j].erLevende()) {
          buttons[i][j].setBackground(Color.WHITE);
        } else {
          buttons[i][j].setBackground(Color.BLACK);
        }
      }
    }
  }

  private class CellButtonListener implements ActionListener {
    private int rad;
    private int kolonne;

    public CellButtonListener(int rad, int kolonne) {
      this.rad = rad;
      this.kolonne = kolonne;
    }

    public void actionPerformed(ActionEvent e) {
      model.endreCelleStatus(rad, kolonne);
      updateView();
    }
  }

  private class StartButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      // Start the game
    }
  }

  private class StopButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      // Stop the game
    }
  }

  private class QuitButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      System.exit(0);
    }
  }
}
