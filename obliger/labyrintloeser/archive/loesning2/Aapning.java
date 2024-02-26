import java.util.ArrayList;

public class Aapning extends HvitRute {

	/** Konstruktoer */
	public Aapning(Labyrint labyrint, int rad, int kolonne) {
		super(labyrint, rad, kolonne);
	}

	/** Finn-metoden */
	@Override
	public void finn(Rute fra, ArrayList<Tuppel> sti) {
		System.out.println("(" + rad + "," + kolonne + ")");

		ArrayList<Tuppel> nySti = new ArrayList<>(sti);
		Tuppel nyTuppel = new Tuppel(rad, kolonne);
		nySti.add(nyTuppel);
		labyrint.addUtvei(nySti);
	}
}
