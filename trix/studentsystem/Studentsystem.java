import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

class Studentsystem {

    protected static ArrayList<Emne> alleEmner = new ArrayList<Emne>();
    protected static ArrayList<Student> alleStudenter = new ArrayList<Student>();


    // Main metode
    public static void main(String[] args) {

        // Last ned data fra fil
        lastNedData();

        String input = null;
        Scanner scan = new Scanner(System.in);

        while (input != "Q") {
            skrivMeny();
            System.out.print("Angi ditt valg: ");
            input = scan.nextLine();
            switch (input) {
                // Print emnene med flest studenter
                case "1":
                    hentEmneMedFlestStudenter();
                    break;

                // Print studentene med flest emneqr
                case "2":
                    hentStudentMedFlestEmner();
                    break;

                // Skriv ut alle studenter i et emne
                case "3":
                    hentAlleStudenterIEmne(); 
                    break;

                // Skriv ut alle emner til en student
                case "4":
                    hentAlleEmnerTilStudent();
                    break;

                case "5":
                    leggStudentTilIEmne();
                    break;

                case "6":
                    fjernStudentFraEmne();
                    break;

                case "7":
                    leggTilNyStudent();
                    break;

                case "8":
                    for (Emne emne : alleEmner) {
                        System.out.println(emne.hentNavn());
                    }
                    break;
                case "9":
                    for (Student student : alleStudenter) {
                        System.out.println(student.hentNavn());
                    }
                    break;
                case "q":
                    System.exit(0);
                break;
            }
        }        
    }


    // Last ned data fra fil
    private static void lastNedData() {
        
        // Leser fil til variabel 'fil'
        String filnavn = "emnestudenter.txt";
        Scanner fil = null;
        try {
            fil = new Scanner(new File(filnavn));
        } catch (Exception e) {
            System.out.println("Kan ikke lese " + filnavn);
            System.exit(1);
        }

        // Oppretter emner, studenter og legger til i lister
        while (fil.hasNextLine()) {
            
            String linje = fil.nextLine().trim();

            if (linje.charAt(0) == '*') {
                String navnPaaEmne = linje.replace("*", "");
                Emne emne = new Emne(navnPaaEmne);
                alleEmner.add(emne);
            }

            else {
                String navnPaaStudent = linje;
                Emne sistEmne = alleEmner.get(alleEmner.size() - 1);

                boolean studentFins = false;
                for (Student student : alleStudenter) {

                    System.out.println(student.hentNavn() + "_" + navnPaaStudent + "_" + student.hentNavn().length() + "_" + navnPaaStudent.length());
                    // Hvis student finnes
                    String navn = student.hentNavn();
                    if (navn.equals(navnPaaStudent)) {
                        System.out.println("Finnes!");
                        studentFins = true;
                        sistEmne.leggTilStudent(student);
                        student.leggTilEmne(sistEmne);
                    }
                }

                // Hvis student ikke finnes
                if (!studentFins) {
                    Student student = new Student(navnPaaStudent, sistEmne);
                    alleStudenter.add(student);
                    sistEmne.leggTilStudent(student);
                    student.leggTilEmne(sistEmne);
                }
            }
        }
    }


    // Last opp data til fil
    private static void lastOppData() {

        String filnavn = "emnestudenter.txt";
        PrintWriter fil = null;
        try {
            fil = new PrintWriter(filnavn);
        } catch (Exception e) {
            System.out.println("Kan ikke lage filen " + filnavn);
            System.exit(1);
        }

        for (Emne emne : alleEmner) {
            fil.print("*" + emne.hentNavn());
            for (Student student : emne.hentStudenter()) {
                fil.print(student.hentNavn());
            }
        }
        // fil.close();
    }
    

    // Print meny
    private static void skrivMeny() {

        System.out.println("Operasjoner:");
        System.out.println("    1 -- Finn emne med flest studenter");
        System.out.println("    2 -- Finn student med flest emner");
        System.out.println("    3 -- Skriv ut alle studenter i et emne");
        System.out.println("    4 -- Skriv ut alle emner til en student");
        System.out.println("    5 -- Legg student til i emne");
        System.out.println("    6 -- Fjern student fra emne");
        System.out.println("    7 -- Legg til ny student");
        System.out.println("    8 -- Legg til nytt emne");
        System.out.println("    9 -- Skriv ut alle unike studenter");
        System.out.println("    q -- Avslutt");
    }


    // Finn emne med flest studenter
    public static void hentEmneMedFlestStudenter() {
        ArrayList<Emne> emner = new ArrayList<Emne>();
        int i = 0;

        // Finner hoeyest antall studenter 'i'
        for (Emne emne : alleEmner) {
            if (emne.hentAntallStudenter() > i) {
                i = emne.hentAntallStudenter();
            }
        }

        // Legger alle emner med 'i' studenter til i 'emner'
        for (Emne emne : alleEmner) {
            if (emne.hentAntallStudenter() == i) {
                emner.add(emne);
            }
        }

        // Printer ut navn på alle emner i 'emner'
        for (Emne emne : emner) {
            System.out.println(emne.hentNavn());
        }
    }


    // Finn student med flest emner
    private static void hentStudentMedFlestEmner() {
        ArrayList<Student> studenter = new ArrayList<Student>();
        int i = 0;

        // Finner hoeyest antall emner 'i'
        for (Student student : alleStudenter) {
            if (student.hentAntallEmner() > i) {
                i = student.hentAntallEmner();
            }
        }

        // Legger alle studenter med 'i' emner til i 'studenter'
        for (Student student : alleStudenter) {
            if (student.hentAntallEmner() == i) {
                studenter.add(student);
            }
        }

        // Printer ut navn på alle studenter i 'studenter'
        for (Student student : studenter) {
            System.out.println(student.hentNavn());
        }
    }

    
    // Skriv ut alle studenter i et emne
    private static void hentAlleStudenterIEmne() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Emne: ");
        String navnPaaEmne = scan.nextLine();
        for (Emne emne : alleEmner) {
            if (emne.hentNavn() == navnPaaEmne) {
                for (Student student : emne.hentStudenter()) {
                    System.out.println(student.hentNavn());
                }
            }
        }
    }


    // Skriv ut alle emner til en student
    private static void hentAlleEmnerTilStudent() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Student: ");
        String navnPaaStudent = scan.nextLine();
        for (Student student : alleStudenter) {
            if (student.hentNavn() == navnPaaStudent) {
                for (Emne emne : student.hentEmner()) {
                    System.out.println(emne.hentNavn());
                }
            }
        }

    }


    // Legg student til i emne
    private static void leggStudentTilIEmne() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Student: ");
        String navnPaaStudent = scan.nextLine();

        System.out.print("Emne: ");
        String navnPaaEmne = scan.nextLine();

        for (Student student : alleStudenter) {
            for (Emne emne : alleEmner) {
                if (student.hentNavn() == navnPaaStudent) {
                    if (emne.hentNavn() == navnPaaEmne) {
                        student.leggTilEmne(emne);
                        emne.leggTilStudent(student);
                    }
                }
            }
        }
    }


    // Fjern student fra emne
    private static void fjernStudentFraEmne() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Student: ");
        String navnPaaStudent = scan.nextLine();

        System.out.print("Emne: ");
        String navnPaaEmne = scan.nextLine();

        for (Student student : alleStudenter) {
            for (Emne emne : alleEmner) {
                if (student.hentNavn() == navnPaaStudent) {
                    if (emne.hentNavn() == navnPaaEmne) {
                        student.fjernEmne(emne);
                        emne.fjernStudent(student);
                    }
                }
            }
        }
    }


    // Legg til ny student
    private static void leggTilNyStudent() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Student: ");
        String navnPaaStudent = scan.nextLine();

        System.out.print("Emne: ");
        String navnPaaEmne = scan.nextLine();

        //

    }
}
