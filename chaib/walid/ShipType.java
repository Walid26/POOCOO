package chaib.walid;

public enum ShipType {
    carrier("carrier", 5), battleship("battleship", 4), cruiser("cruiser", 3), submarine("submarine",
            3), destroyer("destroyer", 2);
    private String name;
    private int length;

    private ShipType(String name, int length) {
        this.name = name;
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public int getLength() {
        return length;
    }

    public static boolean isLegitShipType(String type) {
        try {
            ShipType.valueOf(type);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}