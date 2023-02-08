// klassen Rektangel
class Rektangel {

    double lengde;
    double bredde;

    // Konstruktør
    public Rektangel(double l, double b) {
        lengde = l;
        bredde = b;
    }
        
    // Oek lengden som angitt
    public void oekLengde(int okning) {
        lengde += okning;
    }

    // Oek bredden som angitt
    public void oekBredde(int okning) {
        bredde += okning;
    }

    // Beregn mitt areal
    public double areal() {
        return lengde*bredde;
    }

    // Beregn min omkrets
    public double omkrets() {
        return (bredde + lengde)*2;
    }

    // Reduser lengden som angitt
    public void reduserLengde(int redusering) {
        lengde -= redusering;
    }

    // Reduser bredden som angitt
    public void reduserBredde(int redusering) {
        bredde -= redusering;
    }
}