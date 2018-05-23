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
        int hasHit;
        while (!game.isOver()) {
            System.out.println("Get ready " + game.getActivePlayer().getName());
            do {
                System.out.println("Enter a missile coordinate: ");
                missileCoordinates = scan.nextLine();
                hasHit = game.getActivePlayer().launchMissile(missileCoordinates, game.getPassivePlayer());
                if (hasHit == 1) {
                    System.out.println("Your missile touched the opponent ! Continue like this !");
                } else if (hasHit == 0) {
                    System.out.println("Your missile plunged in water. Better luck next time !");
                }
            } while (hasHit == -1);
            if (game.newRound())
                System.out.println(game.toString());
        }
        System.out.println("Game is over!");
        System.out.println("Congratulations " + game.getWinner().getName() + ", you win with "
                + game.getWinner().getNbAvailableShips() + " ships left!");
        scan.close();
    }
}