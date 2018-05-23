package chaib.walid;

public class MainAIvsAI {

    public static void main(String[] args) {
            AIv1 ai1 = new AIv1("AI Level Medium");
            AIv0 ai2 = new AIv0("AI Level Beginner");
            Game game = new Game(ai1, ai2, null);

            ai1.initializeAI();
            System.out.println(ai1.getBattleship().getOccupiedCoordinates());
            System.out.println(ai1.getDestroyer().getOccupiedCoordinates());
            System.out.println(ai1.getCarrier().getOccupiedCoordinates());
            System.out.println(ai1.getCruiser().getOccupiedCoordinates());
            System.out.println(ai1.getSubmarine().getOccupiedCoordinates());

            ai2.initializeAI();
            System.out.println(ai2.getBattleship().getOccupiedCoordinates());
            System.out.println(ai2.getDestroyer().getOccupiedCoordinates());
            System.out.println(ai2.getCarrier().getOccupiedCoordinates());
            System.out.println(ai2.getCruiser().getOccupiedCoordinates());
            System.out.println(ai2.getSubmarine().getOccupiedCoordinates());

            while (!game.isOver()) {
                for (int j = 1; j <= 2; j++) {
                    if (ai1.getIsPlaying()) {
                        ai1.launchMissileAt(ai2);
                    } else if (ai2.getIsPlaying()) {
                        ai2.launchMissileAt(ai1);
                    }
                    game.swapRoles();
                }
                game.newRound();
                System.out.println("round " + game.getNbRounds());
                System.out.println("joueur1 " + ai1.getNbAvailableShips());
                System.out.println("joueur2 " + ai2.getNbAvailableShips());

            }
            System.out.println("the winner is " + game.getWinner().getName());
    }
}
