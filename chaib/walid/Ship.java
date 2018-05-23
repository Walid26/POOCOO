package chaib.walid;

import java.util.ArrayList;

public class Ship {
    private String startCoord;
    private String endCoord;
    private int nbDamagedParts;
    private ArrayList<String> damagedParts;
    private ArrayList<String> occupiedCoordinates;

    public ArrayList<String> getOccupiedCoordinates() {
        return occupiedCoordinates;
    }

    public void setOccupiedCoordinates(ArrayList<String> occupiedCoordinates) {
        this.occupiedCoordinates = occupiedCoordinates;
    }

    public Ship(String startCoord, String endCoord) {
        this.startCoord = startCoord;
        this.endCoord = endCoord;
        nbDamagedParts = 0;
        damagedParts = new ArrayList<String>();
        occupiedCoordinates = occupiedCoordinates();
    }

    public Ship(Coordinates startCoord, Coordinates endCoord) {
        this.startCoord = startCoord.toStringCoordinates();
        this.endCoord = endCoord.toStringCoordinates();
        nbDamagedParts = 0;
        damagedParts = new ArrayList<String>();
        occupiedCoordinates = occupiedCoordinates();
    }

    public ArrayList<String> getDamagedParts() {
        return damagedParts;
    }

    public void setDamagedParts(ArrayList<String> damagedParts) {
        this.damagedParts = damagedParts;
    }

    public boolean isHorizontal() {
        Coordinates startShip = new Coordinates(this.startCoord);
        Coordinates endShip = new Coordinates(this.endCoord);
        return startShip.getLine() == endShip.getLine();
    }

    public boolean isVertical() {
        Coordinates startShip = new Coordinates(this.startCoord);
        Coordinates endShip = new Coordinates(this.endCoord);
        return startShip.getColumn() == endShip.getColumn();
    }

    public int getNbDamagedParts() {
        return nbDamagedParts;
    }

    public void setNbDamagedParts(int nbDamagedParts) {
        this.nbDamagedParts = nbDamagedParts;
    }

    public String getEndCoord() {
        return endCoord;
    }

    public void setEndCoord(String endCoord) {
        this.endCoord = endCoord;
    }

    public String getStartCoord() {
        return startCoord;
    }

    public void setStartCoord(String startCoord) {
        this.startCoord = startCoord;
    }

    public ArrayList<String> getdamagedParts() {
        return damagedParts;
    }

    public void addDamagedParts(String damagedPart) {
        damagedParts.add(damagedPart);
    }

    public boolean isHit (String missileCoord) {
        Coordinates coord = new Coordinates(missileCoord);
        Coordinates startCoord = new Coordinates(this.startCoord);
        Coordinates endCoord = new Coordinates(this.endCoord);
        Boolean bool = false;
        if (!damagedParts.contains(missileCoord)) {
            if (isHorizontal()) {
                if ((coord.getColumn() >= startCoord.getColumn() && coord.getColumn() <= endCoord.getColumn())) {
                    bool = true;
                }
            } else if (isVertical()) {
                if (coord.getLine() >= startCoord.getLine() && coord.getLine() <= endCoord.getLine()) {
                    bool = true;
                }
            }
        }
        return bool;
    }

    public boolean isDestroyed() {
        return nbDamagedParts == occupiedCoordinates.size();
    }

    public void damageShip(String missile) {
        if (!damagedParts.contains(missile)) {
            nbDamagedParts++;
            addDamagedParts(missile);
        }
    }

    public boolean isKindofShipType(ShipType type) {
        Coordinates startCoord = new Coordinates(this.startCoord);
        Coordinates endCoord = new Coordinates(this.endCoord);
        int shipLength = 0;
        if ((startCoord.isLegitCoordinates()) && (endCoord.isLegitCoordinates())) {
            if (this.isHorizontal()) {
                shipLength = Math.abs(startCoord.getColumn() - endCoord.getColumn()) + 1;
                System.out.println(" shipLength col" + shipLength);
            } else if (this.isVertical()) {
                shipLength = Math.abs(startCoord.getLine() - endCoord.getLine()) + 1;
                System.out.println(" shipLength " + shipLength);
            }
        }
        return shipLength == type.getLength();
    }

    public boolean isStraightShip() {
        return (isHorizontal() || isVertical());
    }

    public ArrayList<String> occupiedCoordinates() {
        ArrayList<String> occupiedCoordinates = new ArrayList<String>();
        Coordinates startCoord = new Coordinates(this.startCoord);
        Coordinates endCoord = new Coordinates(this.endCoord);
        if (isHorizontal()) {
            int shipSize = Math.abs(startCoord.getColumn() - endCoord.getColumn()) + 1;
            for (int i = 0; i < shipSize; i++) {
                Coordinates coord = startCoord;
                occupiedCoordinates.add(coord.toStringCoordinates());
                int column = startCoord.getColumn() + 1;
                coord.setColumn(column);
            }
        } else if (isVertical()) {
            int shipSize = Math.abs(startCoord.getLine() - endCoord.getLine()) + 1;
            for (int i = 0; i < shipSize; i++) {
                Coordinates coord = startCoord;
                occupiedCoordinates.add(coord.toStringCoordinates());
                int line = startCoord.getLine() + 1;
                coord.setLine(line);
            }
        }
        return occupiedCoordinates;
    }
}