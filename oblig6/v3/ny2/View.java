import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

// Klasse View
public class View extends JFrame {
  private static final long serialVersionUID = 1L;
  private final int CELLE_STORRELSE = 10;
  private Verden verden;
  private JPanel rutenettPanel;
  private JButton startStoppKnapp;
  private JButton avsluttKnapp;
  private Controller controller;

  // Konstruktor
  public View(Verden verden, Controller controller) {
    this.verden = verden;
    this.controller = controller;
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
        cellePanel.addMouseListener(
            new MouseAdapter() {
              @Override
              public void mouseClicked(MouseEvent e) {
                int rad = e.getY() / CELLE_STORRELSE;
                int kolonne = e.getX() / CELLE_STORRELSE;
                controller.celleKlikket(rad, kolonne);
              }
            });
        rutenettPanel.add(cellePanel);
      }
    }

    // Oppretter knapp-panel
    JPanel knappPanel = new JPanel();
    startStoppKnapp = new JButton("Start");
    startStoppKnapp.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            controller.startStoppSpill();
          }
        });
    avsluttKnapp = new JButton("Avslutt");
    avsluttKnapp.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            controller.avsluttSpill();
          }
        });
    knappPanel.add(startStoppKnapp);
    knappPanel.add(avsluttKnapp);

    // Legger til paneler i vindu
    add(rutenettPanel);
    add(knappPanel, "South");
    pack();
    setLocationRelativeTo(null);
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

  // Setter teksten på start/stopp-knappen
  public void setStartStoppTekst(String tekst) {
    startStoppKnapp.setText(tekst);
  }
}
