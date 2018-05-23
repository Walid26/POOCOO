package chaib.walid;

public class AIv0 extends AI {

    public AIv0 (String name) {
        super(name);
        // TODO Auto-generated constructor stub
    }

    public boolean launchMissileAt (Player ennemyPlayer) {
        String coord = generateCoord();
        addOwnShots(coord);
        ennemyPlayer.isHitPlayer(coord);
        return ennemyPlayer.isHitPlayer(coord);
    }
}