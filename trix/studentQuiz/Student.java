class Student {

    String navn;
    int totalScore;
    int antallQuizer;

    public Student(String navn, int totalScore, int antallQuizer) {
        this.navn = navn;
        this.totalScore = totalScore;
        this.antallQuizer = antallQuizer;
    }

    public String hentNavn() {
        return navn;
    }

    public void leggTilQuizScore(int score) {
        totalScore += score;
        antallQuizer++;
    }

    public int hentTotalScore() {
        return totalScore;
    }

    public float hentGjennomsnittligScore() {
        return totalScore / antallQuizer;
    }
}
