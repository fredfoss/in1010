import java.io.File;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
      Pers pers1 = Pers("fredrik");
        Pers pers2 = Pers("dude");

        System.out.println(pers1.hentTeller());
        System.out.println(pers2.hentTeller());

    }
}


public class Pers {
    protected String navn;
    protected static int teller;
    
    public Pers(String navn) {
        this.navn = navn;
        teller++;
    }

    public int hentTeller() {
        return teller;
    }
}
 
