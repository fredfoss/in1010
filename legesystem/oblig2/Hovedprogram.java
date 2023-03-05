// Hovedprogram
class Hovedprogram {

    // Main-klasse
    public static void main(String[] args) {

        // Opprett objekter av de forskjellige klassene
        Lege lege = new Lege("mr. lege");
        Spesialist spesialist = new Spesialist("mr. spesialist", "minHemmeligeKode");
        
        Vanlig vanlig = new Vanlig("Ibux", 100, 5.2);
        Narkotisk narkotisk = new Narkotisk("Sterke saker", 100, 10.5, 15);
        Vanedannende vanedannende = new Vanedannende("vanedannende", 200, 5.1, 10);

        HvitResept hvitResept = new HvitResept(vanlig, lege, 4345, 3);
        MilResept milResept = new MilResept(narkotisk, lege, 4643);
        PResept pResept = new PResept(vanedannende, lege, 3555, 1);
        BlaaResept blaaResept = new BlaaResept(vanlig, lege, 3535, 2);

        // Print informasjon om de forskjellige objektene
        System.out.println(vanlig.toString());
        System.out.println(narkotisk.toString());
        System.out.println(vanedannende.toString());
        System.out.println(hvitResept.toString());
        System.out.println(milResept.toString());
        System.out.println(pResept.toString());
        System.out.println(blaaResept.toString());
        System.out.println(lege.toString());
        System.out.println(spesialist.toString());
    }
}
