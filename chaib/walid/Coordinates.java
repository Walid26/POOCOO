package chaib.walid;

public class Coordinates {
    public int line;
    public int column;
    private final static char initialChar = 'A';

    public Coordinates(String coord) {
        column = coord.charAt(0) - initialChar + 1;
        String line = coord.substring(1, 2);
        this.line = Integer.parseInt(line);
    }

    public Coordinates(int line, int column) {
        this.line = line;
        this.column = column;
    }

    public int getLine() {
        return line;
    }

    public int getColumn() {
        return column;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public boolean isLegitCoordinates() {
        try {
            if (this.getLine() <= 10 && this.getLine() >= 1 && this.getColumn() >= 1 && this.getColumn() <= 10)
                return true;
        } catch (Exception e) {
        }
        return false;
    }

    public String toStringCoordinates() {
        String coord = new String();
        coord = coord + (char) (column + initialChar - 1) + line;
        return coord;
    }
}