class Tidspunkt implements Comparable<Tidspunkt> {

  private final int[] tid;

  public Tidspunkt(int aar, int mnd, int dag, int time, int min, int sek) {
    tid = new int[] {aar, mnd, dag, time, min, sek};
  }

  public int[] getTid() { return tid; }

  @Override
  public int compareTo(Tidspunkt annen) {
    int[] annenTid = annen.getTid();
    for (int i = 0; i < 6; i++) {
      if (tid[i] < annetTid[i]) {
        return -1;
      } else if (tid[i] < annetTid[i]) {
        return 1;
      }
    }
    return 0;
  }
}
