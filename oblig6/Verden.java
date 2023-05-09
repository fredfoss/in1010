// Klasse Verden
public class Verden {
    Rutenett rutenett;
    int antRader;
    int antKolonner;
    int genNr = 0;

    // Konstruktoer oppretter, fyller og kobler sammen et rutenett med celler
    public Verden(int antRader, int antKolonner) {
        this.antRader = antRader;
        this.antKolonner = antKolonner;
        rutenett = new Rutenett(antRader, antKolonner);
        rutenett.fyllMedTilfeldigeCeller();
        rutenett.kobleAlleCeller();
    }

    // Tegn rutenett og print info i terminalvindu
    public void tegn() {
        // clearer terminalvindu
        System.out.println();
        System.out.print("\033[H\033[2J");  
        System.out.flush();

        System.out.println("Generasjon nr. " + genNr + ":");
        rutenett.tegnRutenett();
        System.out.println("Det er " + rutenett.antallLevende() + " levende celler.");
        
    }

    // Oppdaterer rutenettet
    public void oppdatering() {
        // Teller levende naboer for hver celle
        for (int i = 0; i < antRader; i++) {
            for (int j = 0; j < antKolonner; j++) {
                Celle celle = rutenett.hentCelle(i, j);
                celle.tellLevendeNaboer();
            }
        }

        // Oppdaterer status for hver celle
        for (int i = 0; i < antRader; i++) {
            for (int j = 0; j < antKolonner; j++) {
                Celle celle = rutenett.hentCelle(i, j);
                celle.oppdaterStatus();
            }
        }

        genNr++;
    }
} 
