// klasse Bil3
public class Bil3 {

    private String bilnummer;

    public Bil3(String bilnummer) {
        this.bilnummer = bilnummer;
    }
    
    public void skrivUt() {
        System.out.println(bilnummer);
    }

    public String hentNummer() {
        return bilnummer;
    }
}
