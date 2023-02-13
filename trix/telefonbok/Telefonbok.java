import java.util.HashMap;
import java.util.Scanner;

class Telefonbok {
    public static void main(String[] args) {
        // Opprett HashMap objekt telefonbok
        HashMap<String, String> telefonbok = new HashMap<String, String>();

        // Legg til keys og values (navn og tlfnr)
        telefonbok.put("Arne", "22334455");
        telefonbok.put("Lisa", "95959595");
        telefonbok.put("Jonas", "97959795");
        telefonbok.put("Peder", "12345678");

        Scanner scanner = new Scanner(System.in);

        String input = null;
        while (input != "") {
            System.out.println("\n[Navn på person/'enter' for avslutte]:");
            input = scanner.nextLine();

            if (input != "") {
                if (telefonbok.containsKey(input)) {
                    System.out.println("Tlfnr: " + telefonbok.get(input));
                }
                else {
                    System.out.println("Fant ikke person.");
                }

            }
        }
    }
}
