// Klasse TestBaathus
class TestBaathus {
    public static void main(String[] args) {
        Baathus baathus = new Baathus(3);

        Baat Elias = new Baat("Nissan");
        Baat Oscar = new Baat("Toyota");
        Baat Martin = new Baat("Toyota");
        Baat Fredrik = new Baat("Ferrari");

        baathus.settInn(Elias);
        baathus.settInn(Oscar);
        baathus.settInn(Martin);
        baathus.settInn(Fredrik);

        baathus.skrivBaater();
    }
}
