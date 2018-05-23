package chaib.walid;

import java.util.ArrayList;
import java.util.Stack;
import java.util.concurrent.ThreadLocalRandom;

public class AI extends Player {
    public AI (String name) {
        super (name);
        // TODO Auto-generated constructor stub
    }

    public void initializeAI () {
        ArrayList<String> shipName = new ArrayList<String>();
        ArrayList<Integer> shipLength = new ArrayList<Integer>();
        shipLength.add(2);
        shipName.add("destroyer");
        shipLength.add(3);
        shipName.add("submarine");
        shipLength.add(3);
        shipName.add("cruiser");
        shipLength.add(4);
        shipName.add("battleship");
        shipLength.add(5);
        shipName.add("carrier");
        int randomLine = 0, randomColumn = 0, randomInt = 0;
        Coordinates startCoord = null, endCoord = null;
        Ship ship = null;
        while ((!shipName.isEmpty()) || (!shipLength.isEmpty())) {
            do {
            randomLine = ThreadLocalRandom.current().nextInt(1, 11);
            randomColumn = ThreadLocalRandom.current().nextInt(1, 11);
            randomInt = ThreadLocalRandom.current().nextInt(1, 3);
            startCoord = new Coordinates (randomLine, randomColumn);
            if (randomInt == 1) {
                endCoord = new Coordinates (randomLine, randomColumn + shipLength.get(0) - 1);
            }
            else if (randomInt == 2) {
                endCoord = new Coordinates (randomLine + shipLength.get(0) - 1, randomColumn);
            }
            ship = new Ship (startCoord, endCoord);
      } while (!startCoord.isLegitCoordinates() || !endCoord.isLegitCoordinates() || isOverlapping(ship));
            if (shipLength.get(0) == 5) {
                setCarrier(ship);
                setNbAvailableShips(getNbAvailableShips() + 1);
                occupiedAreas.addAll(ship.occupiedCoordinates());
                shipName.remove("carrier");
                shipLength.remove((Integer)5);
                }
            else if (shipLength.get(0) == 4) {
                setBattleship(ship);
                setNbAvailableShips(getNbAvailableShips() + 1);
                occupiedAreas.addAll(ship.occupiedCoordinates());
                shipName.remove("battleship");
                shipLength.remove((Integer)4);
            }
            else if (shipLength.get(0) == 3 && shipName.contains("cruiser")) {
                setCruiser(ship);
                setNbAvailableShips(getNbAvailableShips() + 1);
                occupiedAreas.addAll(ship.occupiedCoordinates());
                shipName.remove("cruiser");
                shipLength.remove((Integer)3);
            }
            else if (shipLength.get(0) == 3 && !shipName.contains("cruiser")) {
                setSubmarine(ship);
                setNbAvailableShips(getNbAvailableShips() + 1);
                occupiedAreas.addAll(ship.occupiedCoordinates());
                shipName.remove("submarine");
                shipLength.remove((Integer)3);
            }
            else if (shipLength.get(0) == 2) {
                setDestroyer(ship);
                setNbAvailableShips(getNbAvailableShips() + 1);
                occupiedAreas.addAll(ship.occupiedCoordinates());
                shipName.remove("destroyer");
                shipLength.remove((Integer)2);
            }
        }
    }

    public String generateCoord () {
        Coordinates coord = null;
        do {
        int randomLine = ThreadLocalRandom.current().nextInt(1, 11);
        int randomColumn = ThreadLocalRandom.current().nextInt(1, 11);
        coord = new Coordinates (randomLine, randomColumn);
        } while (!coord.isLegitCoordinates());
        return coord.toStringCoordinates();
    }
}
