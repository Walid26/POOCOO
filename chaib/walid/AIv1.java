package chaib.walid;

public class AIv1 extends AI {

    public AIv1(String name) {
        super(name);
    }

    public boolean launchMissileAt (Player ennemyPlayer) {
        String coord = generateCoord();
        while (getOwnShots().contains(coord)) {
            coord = generateCoord();
        }
        addOwnShots(coord);
        ennemyPlayer.isHitPlayer(coord);
        return ennemyPlayer.isHitPlayer(coord);
    }
}