import java.util.ArrayList;

/** Rute klasse */
public abstract class Rute {

	// Instansvariabler
	protected int rad;
	protected int kolonne;
	protected Labyrint labyrint;
	protected Rute nord;
	protected Rute syd;
	protected Rute vest;
	protected Rute oest;
	protected boolean besoekt = false;

	/** Konstruktoer */
	public Rute(Labyrint labyrint, int rad, int kolonne) {
		this.labyrint = labyrint;
		this.rad = rad;
		this.kolonne = kolonne;
	}

	/** Finn-metoden */
	public abstract void finn(Rute fra, ArrayList<Tuppel> foreloepigeKoordinater);

	public void setNord(Rute nord) {
		this.nord = nord;
	}

	public void setSyd(Rute syd) {
		this.syd = syd;
	}

	public void setVest(Rute vest) {
		this.vest = vest;
	}

	public void setOest(Rute oest) {
		this.oest = oest;
	}

	public boolean getBesoekt() {
		return besoekt;
	}
}
