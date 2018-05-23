package chaib.walid;

import java.util.concurrent.ThreadLocalRandom;

public class Game {
    public Player player1;
    public Player player2;
    public int nbRounds;
    public Player winner;
    public int firstPlayer;

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public int getNbRounds() {
        return nbRounds;
    }

    public void setNbRounds(int nbRounds) {
        this.nbRounds = nbRounds;
    }

    public Game(Player player1, Player player2, Player winner) {
        this.player1 = player1;
        this.player2 = player2;
        winner = null;
        nbRounds = 0;
        firstPlayer = (firstPlayer + 1) % 2;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public void initializeGame() {
        System.out.println("Setting " + player1.getName());
        player1.initializePlayer();
        System.out.println("Setting " + player2.getName());
        player2.initializePlayer();
        int randomInt = ThreadLocalRandom.current().nextInt(1, 3);
        if (randomInt == 1) {
            System.out.println("Player1 first");
            player1.setIsPlaying(true);
            player2.setIsPlaying(false);
        } else {
            System.out.println("Player 2 first");
            player1.setIsPlaying(true);
            player2.setIsPlaying(false);
        }
    }

    public boolean isOver() {
        if (player1.hasLost()) {
            setWinner(player2);
        } else if (player2.hasLost()) {
            setWinner(player1);
        }
        return player1.hasLost() || player2.hasLost();
    }

    public void swapRoles() {
        if (player1.getIsPlaying()) {
            player2.setIsPlaying(true);
            player1.setIsPlaying(false);
        } else {
            player1.setIsPlaying(true);
            player2.setIsPlaying(false);
        }
    }

    public Player getActivePlayer() {
        if (player1.getIsPlaying()) {
            return player1;
        } else {
            return player2;
        }
    }

    public Player getPassivePlayer() {
        if (player1.getIsPlaying()) {
            return player2;
        } else {
            return player1;
        }
    }

    public boolean newRound() {
        boolean isNew = false;
        if (player2.getIsPlaying()) {
            //nbRounds++;
            //isNew = true;
        }
        player1.updateAvailableShips();
        player2.updateAvailableShips();
        swapRoles();
        nbRounds++;
        return true;
    }
}
