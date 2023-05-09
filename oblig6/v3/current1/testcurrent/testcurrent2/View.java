import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// Klasse View
public class View extends JFrame implements ActionListener {
  private static final long serialVersionUID = 1L;
  private final int CELLE_STORRELSE = 10;
  private Verden verden;
  private JPanel rutenettPanel;
  private JButton startStoppKnapp;
  private JButton avsluttKnapp;
  private Timer timer;
  private int tidsintervall;

  // Konstruktor
  public View(Verden verden, int tidsintervall) {
    this.verden = verden;
    this.tidsintervall = tidsintervall;
    setTitle("Game of Life");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setResizable(false);

    // Opprett rutenett-panel
    rutenettPanel = new JPanel(new GridLayout(verden.antRader, verden.antKolonner));
    rutenettPanel.setPreferredSize(
        new Dimension(verden.antKolonner * CELLE_STORRELSE, verden.antRader * CELLE_STORRELSE));
    rutenettPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

    // Legg til celler i rutenett-panel
    for (int i = 0; i < verden.antRader; i++) {
      for (int j = 0; j < verden.antKolonner; j++) {
        Celle celle = verden.rutenett.hentCelle(i, j);
        JPanel cellePanel = new JPanel();
        cellePanel.setPreferredSize(new Dimension(CELLE_STORRELSE, CELLE_STORRELSE));
        cellePanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        if (celle.erLevende()) {
          cellePanel.setBackground(Color.BLACK);
        } else {
          cellePanel.setBackground(Color.WHITE);
        }
        // Legg til MouseListener på cellePanelet
        cellePanel.addMouseListener(
            new MouseAdapter() {
              @Override
              public void mouseClicked(MouseEvent e) {
                int rad = e.getY() / CELLE_STORRELSE;
                int kolonne = e.getX() / CELLE_STORRELSE;
                Celle celle = verden.rutenett.hentCelle(rad, kolonne);
                celle.toggleStatus();
                if (celle.erLevende()) {
                  ((JPanel) e.getSource()).setBackground(Color.BLACK);
                } else {
                  ((JPanel) e.getSource()).setBackground(Color.WHITE);
                }
              }
            });
        rutenettPanel.add(cellePanel);
      }
    }

    // Opprett knapp-panel
    JPanel knappPanel = new JPanel();
    startStoppKnapp = new JButton("Start");
    startStoppKnapp.addActionListener(this);
    avsluttKnapp = new JButton("Avslutt");
    avsluttKnapp.addActionListener(this);
    knappPanel.add(startStoppKnapp);
    knappPanel.add(avsluttKnapp);

    // Legg til paneler i vindu
    add(rutenettPanel);
    add(knappPanel, "South");
    pack();
    setLocationRelativeTo(null);

    // Opprett timer for oppdatering av rutenett
    timer = new Timer(tidsintervall, this);
    timer.setInitialDelay(0);
  }

  // Oppdater rutenett-panel med oppdatert verden
  public void oppdaterRutenett() {
    for (int i = 0; i < verden.antRader; i++) {
      for (int j = 0; j < verden.antKolonner; j++) {
        Celle celle = verden.rutenett.hentCelle(i, j);
        JPanel cellePanel = (JPanel) rutenettPanel.getComponent(i * verden.antKolonner + j);
        if (celle.erLevende()) {
          cellePanel.setBackground(Color.BLACK);
        } else {
          cellePanel.setBackground(Color.WHITE);
        }
      }
    }
  }

  // ActionListener metode for knappetrykk og timer
  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == startStoppKnapp) {
      if (timer.isRunning()) {
        timer.stop();
        startStoppKnapp.setText("Start");
      } else {
        timer.start();
        startStoppKnapp.setText("Stopp");
      }
    } else if (e.getSource() == avsluttKnapp) {
      System.exit(0);
    } else if (e.getSource() == timer) {
      verden.oppdatering();
      oppdaterRutenett();
    }
  }
}
