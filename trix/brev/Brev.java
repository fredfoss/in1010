import java.util.ArrayList;

class Brev {
    
    String avsender;
    String mottaker;
    ArrayList<String> linjer = new ArrayList<String>();

    public Brev(String avsender, String mottaker) {
        this.avsender = avsender;
        this.mottaker = mottaker;
    }

    public void skrivLinje(String linje) {
        linjer.add(linje);
    }

    public void lesBrev() {
        System.out.println("Hei, " + mottaker + "\n");
        for (String i : linjer) {
            System.out.println(i);
        }
        System.out.println("\nHilsen fra,\n" + avsender);
    }
}
