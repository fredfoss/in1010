// Klassen Baathus
class Baathus {

    private Baat[] baathus;

    //Konstruktør
    public Baathus(int antallPlasser) {
        baathus = new Baat[antallPlasser];
    }

    // metode settInn legger til en ny båt i båthuset hvis det er plass
    public void settInn(Baat enBaat) {

        Boolean sattInn = false;
        
        // hvis plass, legger til baat i baathus
        for (int i = 0; i < baathus.length; i++) {
            if (!sattInn && baathus[i] == null) {
                baathus[i] = enBaat;
                sattInn = true;
            }
        }
       
        if (!sattInn) {
            System.out.println("Ikke flere plasser!");
        }
    }
    
    // metode skrivBaater skriver ut informasjon om alle baatene
    public void skrivBaater() {
        
        for (int i = 0; i < baathus.length; i++) {
            if (baathus[i] != null) {
                System.out.println(baathus[i].hentInfo());

            }
        }
    }
}
