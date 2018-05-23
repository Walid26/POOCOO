package chaib.walid;

import java.util.Stack;

public class AIv2 extends AI {
    Stack<String> next = new Stack<String>();

    public AIv2(String name) {
        super(name);
    }

    public boolean launchMissileAt (Player ennemyPlayer) {
        if (!next.empty()) {
            addOwnShots(next.peek());
            ennemyPlayer.isHitPlayer(next.peek());
            return ennemyPlayer.isHitPlayer(next.pop());
        }
        else {
            String coord = generateCoord();
            while (getOwnShots().contains(coord)) {
                coord = generateCoord();
            }
            if (ennemyPlayer.isHitPlayer(coord)) {
                proximateCoords(coord);
            }
            ennemyPlayer.isHitPlayer(coord);
            return ennemyPlayer.isHitPlayer(coord);
        }
    }

    public void proximateCoords (String coordinate) {
        Coordinates coord = new Coordinates (coordinate);
        Coordinates coord1 = new Coordinates (coord.getLine() + 1,coord.getColumn());
        Coordinates coord2 = new Coordinates (coord.getLine(),coord.getColumn() +1);
        Coordinates coord3 = new Coordinates (coord.getLine() - 1,coord.getColumn());
        Coordinates coord4 = new Coordinates (coord.getLine(), coord.getColumn() - 1);
        if (coord1.isLegitCoordinates() && !getOwnShots().contains(coord1.toStringCoordinates())) {
            next.push(coord1.toStringCoordinates());
        }
        if (coord2.isLegitCoordinates() && !getOwnShots().contains(coord2.toStringCoordinates())) {
            next.push(coord2.toStringCoordinates());
        }
        if (coord3.isLegitCoordinates() && !getOwnShots().contains(coord3.toStringCoordinates())) {
            next.push(coord3.toStringCoordinates());
        }
        if (coord4.isLegitCoordinates() && !getOwnShots().contains(coord4.toStringCoordinates())) {
            next.push(coord4.toStringCoordinates());
        }
    }
}