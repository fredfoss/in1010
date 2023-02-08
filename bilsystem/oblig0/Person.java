// klasse Person
public class Person {

    private Bil3 bil;

    public Person(Bil3 bil) {
        this.bil = bil;
    }

    public void skrivUt() {
        System.out.println(bil.hentNummer());
    }
}
