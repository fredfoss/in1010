class Hovedprogram {
    public static void main(String[] args) {
        Brev brevet = new Brev("Per Askeladden", "Espen Askeladden");
        brevet.skrivLinje("Hvordan går det?");
        brevet.skrivLinje("Jeg har det bare bra!");
        brevet.lesBrev();
    }
}
