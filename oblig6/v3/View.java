import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

// Klasse View
public class View extends JFrame implements ActionListener {
  private static final long serialVersionUID = 1L;
  private final int CELLE_STORRELSE = 10;
  private Verden verden;
  private JPanel rutenettPanel;
  private JButton startKnapp;
  private JButton stoppKnapp;
  private Timer timer;

  // Konstruktor
  public View(Verden verden) {
    this.verden = verden;
    setTitle("Game of Life");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setResizable(false);

    // Oppretter rutenett-panel
    rutenettPanel = new JPanel(new GridLayout(verden.antRader, verden.antKolonner));
    rutenettPanel.setPreferredSize(
        new Dimension(verden.antKolonner * CELLE_STORRELSE, verden.antRader * CELLE_STORRELSE));
    rutenettPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

    // Legger til celler i rutenett-panel
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
        rutenettPanel.add(cellePanel);
      }
    }

    // Oppretter knapp-panel
    JPanel knappPanel = new JPanel();
    startKnapp = new JButton("Start");
    startKnapp.addActionListener(this);
    stoppKnapp = new JButton("Stopp");
    stoppKnapp.addActionListener(this);
    stoppKnapp.setEnabled(false);
    knappPanel.add(startKnapp);
    knappPanel.add(stoppKnapp);

    // Legger til paneler i vindu
    add(rutenettPanel);
    add(knappPanel, "South");
    pack();
    setLocationRelativeTo(null);

    // Oppretter timer for oppdatering av rutenett
    timer = new Timer(100, this);
  }

  // Oppdaterer rutenett-panel med oppdatert verden
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
    if (e.getSource() == startKnapp) {
      startKnapp.setEnabled(false);
      stoppKnapp.setEnabled(true);
      timer.start();
    } else if (e.getSource() == stoppKnapp) {
      stoppKnapp.setEnabled(false);
      startKnapp.setEnabled(true);
      timer.stop();
    } else if (e.getSource() == timer) {
      verden.oppdatering();
      oppdaterRutenett();
    }
  }
}
