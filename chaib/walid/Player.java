package chaib.walid;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    private String name;
    private Ship carrier;
    private Ship battleship;
    private Ship cruiser;
    private Ship submarine;
    private Ship destroyer;
    private int nbAvailableShips;
    private ArrayList<String> shipTypeList;
    protected ArrayList<String> occupiedAreas;
    private ArrayList<String> ownShots;
    private ArrayList<String> opponentShots;
    private boolean isPlaying;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Ship getCarrier() {
        return carrier;
    }

    public ArrayList<String> getOwnShots() {
        return ownShots;
    }

    public ArrayList<String> getOpponentShots() {
        return opponentShots;
    }

    public void setCarrier(Ship carrier) {
        this.carrier = carrier;
    }

    public Ship getBattleship() {
        return battleship;
    }

    public void setBattleship(Ship battleship) {
        this.battleship = battleship;
    }

    public Ship getCruiser() {
        return cruiser;
    }

    public void setCruiser(Ship cruiser) {
        this.cruiser = cruiser;
    }

    public Ship getSubmarine() {
        return submarine;
    }

    public void setSubmarine(Ship submarine) {
        this.submarine = submarine;
    }

    public Ship getDestroyer() {
        return destroyer;
    }

    public void setDestroyer(Ship destroyer) {
        this.destroyer = destroyer;
    }

    public int getNbAvailableShips() {
        return nbAvailableShips;
    }

    public void setNbAvailableShips(int nbAvailableShips) {
        this.nbAvailableShips = nbAvailableShips;
    }

    public boolean getIsPlaying() {
        return isPlaying;
    }

    public void setIsPlaying(boolean isPlaying) {
        this.isPlaying = isPlaying;
    }

    public void addOwnShots(String ownShot) {
        ownShots.add(ownShot);
    }

    public void addOpponentShots(String opponentShot) {
        opponentShots.add(opponentShot);
    }

    public boolean hasLost() {
        return nbAvailableShips == 0;
    }

    public void updateAvailableShips() {
        if (carrier.isDestroyed() && shipTypeList.contains("carrier")) {
            setNbAvailableShips(getNbAvailableShips() -1);
            shipTypeList.remove("carrier");
        }
        if (battleship.isDestroyed() && shipTypeList.contains("battleship")) {
            setNbAvailableShips(getNbAvailableShips() -1);
            shipTypeList.remove("battleship");
        }
        if (cruiser.isDestroyed() && shipTypeList.contains("cruiser")) {
            setNbAvailableShips(getNbAvailableShips() -1);
            shipTypeList.remove("cruiser");
        }
        if (submarine.isDestroyed() && shipTypeList.contains("submarine")) {
            setNbAvailableShips(getNbAvailableShips() -1);
            shipTypeList.remove("submarine");
        }
        if (destroyer.isDestroyed() && shipTypeList.contains("carrier")) {
            setNbAvailableShips(getNbAvailableShips() -1);
            shipTypeList.remove("carrier");
        }
    }
    
    public boolean isHitPlayer (String missile) {
        if (!opponentShots.contains(missile)) {
            addOpponentShots(missile);
            if (carrier.isHit(missile) && shipTypeList.contains("carrier")) {
                carrier.damageShip(missile);
                if (carrier.isDestroyed() && shipTypeList.contains("carrier")) {
                    System.out.println("You sank my carrier");
                    setNbAvailableShips(getNbAvailableShips() - 1);
                    shipTypeList.remove("carrier");
                }
                return true;

            } else if (battleship.isHit(missile) && shipTypeList.contains("battleship")) {
                battleship.damageShip(missile);
                if (battleship.isDestroyed() && shipTypeList.contains("battleship")) {
                    System.out.println("You sank my battleship");
                    setNbAvailableShips(getNbAvailableShips() - 1);
                    shipTypeList.remove("battleship");
                }
                return true;

            } else if (cruiser.isHit(missile) && shipTypeList.contains("cruiser")) {
                cruiser.damageShip(missile);
                if (cruiser.isDestroyed() && shipTypeList.contains("cruiser")) {
                    System.out.println("You sank my cruiser");
                    setNbAvailableShips(getNbAvailableShips() - 1);
                    shipTypeList.remove("cruiser");
                }
                return true;

            } else if (destroyer.isHit(missile) && shipTypeList.contains("destroyer")) {
                destroyer.damageShip(missile);
                if (destroyer.isDestroyed() && shipTypeList.contains("destroyer")) {
                    System.out.println("You sank my destroyer");
                    setNbAvailableShips(getNbAvailableShips() - 1);
                    shipTypeList.remove("destroyer");
                }
                return true;

            } else if (submarine.isHit(missile) && shipTypeList.contains("submarine")) {
                submarine.damageShip(missile);
                if (submarine.isDestroyed() && shipTypeList.contains("submarine")) {
                    System.out.println("You sank my submarine");
                    setNbAvailableShips(getNbAvailableShips() - 1);
                    shipTypeList.remove("submarine");
                }
                return true;

            } else {
                return false;
            }
        } else {
            System.out.println("You already shot there");
            return false;
        }
    }

    public int launchMissile(String missile, Player playerReceiving) {
        if (!ownShots.contains(missile)) {
            addOwnShots(missile);
            if (playerReceiving.isHitPlayer(missile)) {
                return 1;
            } else
                return 0;
        } else {
            System.out.println("Missile already fired on this position");
            return -1;
        }
    }

    public Player(String name) {
        this.name = name;
        nbAvailableShips = 0;
        ownShots = new ArrayList<>();
        opponentShots = new ArrayList<>();
        occupiedAreas = new ArrayList<String>();
        shipTypeList = new ArrayList<String>();
        shipTypeList.add("carrier");
        shipTypeList.add("battleship");
        shipTypeList.add("cruiser");
        shipTypeList.add("submarine");
        shipTypeList.add("destroyer");
    }

    public void initializePlayer() {
        boolean bool = false;
        String type = "";
        Ship ship = null;
        ArrayList<String> shipTypeList = new ArrayList<String>();
        while (nbAvailableShips < 5) {
            do {
                Scanner scan = new Scanner(System.in);
                System.out.println("Enter the type of your ship");
                type = scan.nextLine();
                bool = ShipType.isLegitShipType(type);
                if (!bool) {
                    System.out.println("Not an acceptable type");
                }
                if (shipTypeList.contains(type))
                    System.out.println("You already have this type of ship");
            } while (!bool || shipTypeList.contains(type));
            do {
                Scanner scan = new Scanner(System.in);
                System.out.println("Enter the starting coordinate of your " + type);
                String startCoord = scan.nextLine();
                System.out.println("Enter the ending coordinate of your " + type);
                String endCoord = scan.nextLine();
                ship = new Ship(startCoord, endCoord);

            } while (!ship.isKindofShipType(ShipType.valueOf(type)) || !ship.isStraightShip() || isOverlapping(ship));
            if (ShipType.valueOf(type) == ShipType.carrier) {
                carrier = ship;
                nbAvailableShips++;
                getOccupiedAreas().addAll(carrier.occupiedCoordinates());
                shipTypeList.add(type);
                this.shipTypeList.add("carrier");
            } else if (ShipType.valueOf(type) == ShipType.battleship) {
                battleship = ship;
                nbAvailableShips++;
                getOccupiedAreas().addAll(battleship.occupiedCoordinates());
                shipTypeList.add(type);
                this.shipTypeList.add("battleship");
            } else if (ShipType.valueOf(type) == ShipType.submarine) {
                submarine = ship;
                nbAvailableShips++;
                getOccupiedAreas().addAll(submarine.occupiedCoordinates());
                shipTypeList.add(type);
                this.shipTypeList.add("submarine");
            } else if (ShipType.valueOf(type) == ShipType.cruiser) {
                cruiser = ship;
                nbAvailableShips++;
                getOccupiedAreas().addAll(cruiser.occupiedCoordinates());
                shipTypeList.add(type);
                this.shipTypeList.add("cruiser");
            } else if (ShipType.valueOf(type) == ShipType.destroyer) {
                destroyer = ship;
                nbAvailableShips++;
                getOccupiedAreas().addAll(destroyer.occupiedCoordinates());
                shipTypeList.add(type);
                this.shipTypeList.add("destroyer");
            }
        }
    }

    public boolean isOverlapping(Ship ship) {
        ArrayList<String> liste = ship.occupiedCoordinates();
        int i = 0;
        boolean bool = false;
        while (i < liste.size() && !bool) {
            bool = getOccupiedAreas().contains(liste.get(i));
            i++;
        }
        return bool;
    }

    public ArrayList<String> getOccupiedAreas() {
        return occupiedAreas;
    }

    public void setOccupiedAreas(ArrayList<String> occupiedAreas) {
        this.occupiedAreas = occupiedAreas;
    }
}