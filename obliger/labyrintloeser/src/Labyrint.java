import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/** Labyrint-klassen */
public class Labyrint {

	// Instansvariabler
	private Rute[][] ruter;
	private int antRader;
	private int antKolonner;
	private int antHvite = 0;
	private int antSorte = 0;
	private int antAapninger = 0;
	private ArrayList<ArrayList<Rute>> utveier = new ArrayList<>();

	/** Konstruktoer */
	public Labyrint(File fil) throws FileNotFoundException {
		finnAntRaderOgKolonner(fil);
		opprettRuter(fil);
		kobleSammenNaboer();
	}

	/** Finn antall rader og kolonner */
	private void finnAntRaderOgKolonner(File fil) throws FileNotFoundException {
		Scanner scanner = new Scanner(fil);
		antRader = scanner.nextInt();
		antKolonner = scanner.nextInt();
		scanner.close();
	}

	/** Opprett alle hvite-, sorte- og aapningsruter */
	private void opprettRuter(File fil) throws FileNotFoundException {
		ruter = new Rute[antRader][antKolonner];
		Scanner scanner = new Scanner(fil);
		scanner.nextLine();

		// Iterer gjennom fil og sjekk om karakter er '#' eller '.'
		for (int rad = 0; rad < antRader; rad++) {
			String linje = scanner.nextLine();
			for (int kol = 0; kol < antKolonner; kol++) {
				char tegn = linje.charAt(kol);
				if (tegn == '#') {
					ruter[rad][kol] = new SortRute(this, rad, kol);
					antSorte++;
				} else if (tegn == '.') {
					antHvite++;
					if (rad == 0 || kol == 0 || rad == antRader - 1 || kol == antKolonner - 1) {
						ruter[rad][kol] = new Aapning(this, rad, kol);
						antAapninger++;
					} else {
						ruter[rad][kol] = new HvitRute(this, rad, kol);
					}
				}
			}
		}
		scanner.close();
	}

	/** Sett naboruter for alle rutene */
	private void kobleSammenNaboer() {
		for (int rad = 0; rad < antRader; rad++) {
			for (int kol = 0; kol < antKolonner; kol++) {
				Rute rute = ruter[rad][kol];
				// Sett nord-nabo
				if (rad > 0) {
					Rute nord = ruter[rad - 1][kol];
					rute.setNord(nord);
				}
				// Sett vest-nabo
				if (kol > 0) {
					Rute vest = ruter[rad][kol - 1];
					rute.setVest(vest);
				}
				// Sett syd-nabo
				if (rad < antRader - 1) {
					Rute syd = ruter[rad + 1][kol];
					rute.setSyd(syd);
				}
				// Sett oest-nabo
				if (kol < antKolonner - 1) {
					Rute oest = ruter[rad][kol + 1];
					rute.setOest(oest);
				}
			}
		}
	}

	/** Kall paa metoden finn til ruten i (rad, kol) */
	public ArrayList<ArrayList<Rute>> finnUtveiFra(int rad, int kol) {
		Rute startRute = ruter[rad][kol];
		startRute.setFoersteRute();
		ArrayList<Rute> tomSti = new ArrayList<>();
		startRute.finn(null, tomSti);
		return utveier;
	}

	/** Legg til utvei */
	public void addUtvei(ArrayList<Rute> utvei) {
		utveier.add(utvei);
	}

	/** Returner labyrinten med toString-metoden */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		// Legg til ekstra linjeskift hvis det er 10 eller flere kolonner
		if (antKolonner >= 10) {
			sb.append("\n");
		}

		// Legg til kolonnenumrene
		sb.append("   ");
		for (int kol = 0; kol < antKolonner; kol++) {
			int num = kol / 10;
			if (num > 0) {
				sb.append("\033[0;34m" + num + "\033[0m");
			} else {
				sb.append(" ");
			}
		}
		sb.append("\n");
		sb.append("   ");

		for (int kol = 0; kol < antKolonner; kol++) {
			sb.append("\033[0;34m" + kol % 10 + "\033[0m");
		}
		sb.append("\n");

		// Legg til radnumrene og ruteverdiene
		for (int rad = 0; rad < antRader; rad++) {
			// Legg til radnummeret
			int num = rad / 10;
			if (num > 0) {
				sb.append("\033[0;34m" + num + "\033[0m");
			} else {
				sb.append(" ");
			}
			sb.append("\033[0;34m" + rad % 10 + "\033[0m");
			sb.append(" ");
			// Legg til ruteverdiene
			for (int kol = 0; kol < antKolonner; kol++) {
				Rute rute = ruter[rad][kol];
				sb.append(rute.toString());
			}
			if (rad != antRader - 1) {
				sb.append("\n");
			}
		}
		return sb.toString();
	}

	/* Get-metoder */
	public int getAntRader() {
		return antRader;
	}

	public int getAntKolonner() {
		return antKolonner;
	}

	public int getAntHvite() {
		return antHvite;
	}

	public int getAntSorte() {
		return antSorte;
	}

	public int getAntAapninger() {
		return antAapninger;
	}
}
