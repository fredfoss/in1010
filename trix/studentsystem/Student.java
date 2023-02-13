import java.util.ArrayList;

class Student {

    // Instansvariabler
    protected String navn;
    protected ArrayList<Emne> emner = new ArrayList<Emne>();

    // Konstruktoer
    public Student(String navn, Emne emne) {
        this.navn = navn;
        emner.add(emne);
    }

    // Hent navn
    public String hentNavn() {
        return navn;
    }

    public int hentAntallEmner() {
        return emner.size();
    }

    // Legg til emne 
    public void leggTilEmne(Emne emne) {
        emner.add(emne);
    }

    // Fjern emne
    public void fjernEmne(Emne emne) {
        emner.remove(emne);
    }

    // Hent liste med emner
    public ArrayList<Emne> hentEmner() {
        return emner;
    }

    // Sjekk om student har et emne
    public boolean harEmne(Emne emne) {
        return emner.contains(emne);
    }
}

