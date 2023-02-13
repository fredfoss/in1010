import java.util.ArrayList;

class Emne { 

    // Instansvariabler
    protected String navn;
    protected ArrayList<Student> studenter = new ArrayList<Student>();

    // Konstruktoer
    public Emne(String navn) {
        this.navn = navn;
    }

    // Hent navn
    public String hentNavn() {
        return navn;
    }

    // Hent antall studenter
    public int hentAntallStudenter() {
        return studenter.size();
    }

    // Legg til student
    public void leggTilStudent(Student student) {
        studenter.add(student);
    }

    // Fjern student
    public void fjernStudent(Student student) {
        studenter.remove(student);
    }

    // Hent liste med studenter
    public ArrayList<Student> hentStudenter() {
        return studenter;
    }

    // Sjekk om student tar emne
    public boolean harStudent(Student student) {
        return studenter.contains(student);
    }
}
