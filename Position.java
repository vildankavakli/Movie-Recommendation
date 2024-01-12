package datastructuresproject3;

/**
 *
 * @author Techno
 */
public class Position {

    int row;
    int col;

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    @Override
    public boolean equals(Object o) {
        // Checks if two Position objects are equal based on their row and col values

        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position position = (Position) o;
        return row == position.row && col == position.col;
    }

    @Override
    public int hashCode() {
        // Computes a hash code value for a Position object based on its row and col values

        int result = row;
        result = 31 * result + col;
        return result;
    }

}
