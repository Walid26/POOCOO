package chaib.walid;

import java.util.Scanner;

public class Battleship {

    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Chose battleship mode : AIvsAI or PlayervsPlayer");
        String response = scan.nextLine();
        if (response == "AIvsAI") {
            MainAIvsAI.main(args);
        }
        else if (response == "PlayervsPlayer") {
            Main.main(args);
        }
        else {
            while (!(response == "AIvsAI") && !(response == "AIvsAI")) {
                System.out.println("Chose battleship mode : AIvsAI or PlayervsPlayer");
                response = scan.nextLine();
            }
        }
        
    }
}
