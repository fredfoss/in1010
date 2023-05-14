import java.io.*;
import java.util.*;

class CDSamling {
  public static void main(String[] args) {

    ArrayList<CDAlbum> cdsamling = lesOgSorter(args[0]);

    for (CDAlbum a : cdsamling) {
      System.out.println(a);
    }

    skrivTilFil(cdsamling, args[1]);
  }

  public static ArrayList<CDAlbum> lesOgSorter(String filnavn) {

    File f = new File(filnavn);
    Scanner fscan = null;
    try {
      fscan = new Scanner(f);
    } catch (FileNotFoundException e) {
      System.out.println("Fant ikke filen!");
      return null;
    }

    ArrayList<CDAlbum> liste = new ArrayList<CDAlbum>();

    while (fscan.hasNextLine()) {
      String[] linje = fscan.nextLine().split(",");

      CDAlbum nytt = new CDAlbum(linje[0], linje[1], linje[2]);

      boolean sattInn = false;
      int teller = 0;

      while (teller < liste.size() && !sattInn) {
        if (nytt.compareTo(liste.get(teller)) < 0) {
          liste.add(teller, nytt);
          sattInn = true;
        }
        teller++;
      }

      if (!sattInn) {
        liste.add(nytt);
      }
    }
    return liste;
  }

  public static void skrivTilFil(ArrayList<CDAlbum> liste, String utfil) {

    File f = new File(utfil);
    try {
      PrintWriter pw = new PrintWriter(f);

      for (CDAlbum cd : liste) {
        pw.append(cd.toString() + "\n");
      }
      pw.close();

    } catch (FileNotFoundException e) {
      System.out.println(e.getMessage());
    }
  }
}










import java.io.*;
import java.util.Scanner;

class Skattekart {
    private char[][] skattekart;
    private int hoyde;
    private int bredde;
    private boolean funnet = false;

    private Skattekart(char[][] kart, int rader, int kolonner) {
        skattekart = kart;
        this.hoyde = rader;
        this.bredde = kolonner;
    }

    static Skattekart lesInn(File f) throws FileNotFoundException {
        Scanner sc = new Scanner(f);

        String[] str = sc.nextLine().split(" ");
        int antR = Integer.parseInt(str[0]);
        int antK = Integer.parseInt(str[1]);

        char[][] kart = new char[antR][antK];

        for (int rad = 0; rad < antR; rad++) {
            String linje = sc.nextLine();

            for (int kol = 0; kol < antK; kol++) {
                kart[rad][kol] = linje.charAt(kol);
            }
        }

        Skattekart sk = new Skattekart(kart, antR, antK);

        return sk;
    }

    public void skrivUt() {
        for (int i = 0; i < skattekart.length; i++) {
            for (int j = 0; j < skattekart[i].length; j++) {
                if (funnet) {
                    System.out.print(skattekart[i][j]);
                } else {
                    System.out.print("X");
                }
            }
            System.out.println();
        }
    }

    public boolean sjekk(int kol, int rad) {
        if (skattekart[rad][kol] == 'X') {
            funnet = true;
        }
        return funnet;
    }
}








import java.io.*;
import java.util.Scanner;

class Hovedprogram {

    public static void main(String[] args) {
        Skattekart skattekart = null;

        try {
            File fil = new File(args[0]);
            skattekart = Skattekart.lesInn(fil);

        } catch (FileNotFoundException e) {
            System.out.println("Fant ikke filen!");
        }

        skattekart.skrivUt();
        Scanner brukerinput = new Scanner(System.in);

        System.out.println("\nFinn skatten! Gjett koordinater paa formatet (kol rad) (a for aa avslutte):");
        String inn = brukerinput.nextLine();

        int antForsoek = 0;

        while (!inn.equals("a")) {
            String[] l = inn.split(" ");

            try {
                int kol = Integer.parseInt(l[0]);
                int rad = Integer.parseInt(l[1]);

                if (skattekart.sjekk(kol, rad)) {
                    System.out.println("\nDu fant skatten!");
                    inn = "a";

                } else {
                    antForsoek ++;
                    System.out.println("\nIngen skatt der! Gjett igjen:");
                    inn = brukerinput.nextLine();
                }

                skattekart.skrivUt();

            } catch (NumberFormatException e) {

                System.out.println("UGYLDIGE KOORDINATER!");
            }
        }
    }
}
