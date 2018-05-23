package chaib.walid;

import java.util.Scanner;

public class Main {

    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        String playerName;
        String missileCoordinates;
        System.out.println("Player 1, enter your name : ");
        playerName = scan.nextLine();
        Player player1 = new Player(playerName);
        System.out.println("Player 2, enter your name : ");
        playerName = scan.nextLine();
        Player player2 = new Player(playerName);
        Game game = new Game(player1, player2, null);
        game.initializeGame();
        while (!game.isOver()) {
            System.out.println("Get ready " + game.getActivePlayer().getName());
            do {
                System.out.println("Enter a missile coordinate : ");
                missileCoordinates = scan.nextLine();
        }
        System.out.println("Winner : " + game.getWinner().getName());
        scan.close();
    }
}
