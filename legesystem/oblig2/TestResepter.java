// Test av Resepter
class TestResepter {

    private static boolean testReseptFarge(Resept resept, String forventetFarge) {
        return resept.farge() == forventetFarge;
    }

    private static boolean testReseptPris(Resept resept, int forventetPris) {
        return resept.prisAaBetale() == forventetPris;
    }

    public static void main(String[] args) {

        Narkotisk legemiddel1 = new Narkotisk("drugzz", 100, 1.0, 1000);
        Lege lege1 = new Lege("lege");

        HvitResept resept1 = new HvitResept(legemiddel1, lege1, 123, 1);
        System.out.println(testReseptFarge(resept1, "hvit"));
        System.out.println(testReseptPris(resept1, 100));

        MilResept resept2 = new MilResept(legemiddel1, lege1, 321);
        System.out.println(testReseptFarge(resept2, "hvit"));
        System.out.println(testReseptPris(resept2, 0));
        
        PResept resept3 = new PResept(legemiddel1, lege1, 321, 2);
        System.out.println(testReseptFarge(resept3, "hvit"));
        System.out.println(testReseptPris(resept3, 0));

        BlaaResept resept4 = new BlaaResept(legemiddel1, lege1, 321, 2);
        System.out.println(testReseptFarge(resept4, "blaa"));
        System.out.println(testReseptPris(resept4, 25));
    }
}

