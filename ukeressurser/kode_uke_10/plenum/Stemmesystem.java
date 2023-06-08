import java.util.ArrayDeque;
import java.util.Deque;

public class Stemmesystem {
  private Deque<Parti> stemmer = new ArrayDeque<>(); // stabel

  public void leggTilStemme(Parti parti) {
    stemmer.push(parti);
  }

  public Parti taUtStemme() {
    return stemmer.pop();
  }

  public boolean tomtForStemmer() {
    return stemmer.isEmpty();
  }
}
