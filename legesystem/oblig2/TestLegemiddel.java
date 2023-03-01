class TestLegemiddel {

    private static boolean testLegemiddelId(Legemiddel legemiddel, int forventetLegemiddelId) {
        return legemiddel.id == forventetLegemiddelId;
    }

    public static void main(String[] args) {

        Vanlig legemiddel1 = new Vanlig("yo", 100, 10.3);
        System.out.println(testLegemiddelId(legemiddel1, 0));
         
        Vanlig legemiddel2 = new Vanlig("ya", 100, 4.32);
        System.out.println(testLegemiddelId(legemiddel2, 1));

        Narkotisk legemiddel3 = new Narkotisk("yi", 100, 1.0, 1000);
        System.out.println(testLegemiddelId(legemiddel3, 2));
    }
}
