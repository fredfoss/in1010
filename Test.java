import java.io.File;
import java.util.Scanner;

class Test {
    public static void main(String[] args) {

        String setning = "*Hei jeg heter Fredri*k";
        System.out.println(setning.contains("*"));
        System.out.println(setning.charAt(0) == '*');

        System.out.println(setning.replace("*", ""));
    }
}


 
