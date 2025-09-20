package metty1337.simulation;

import metty1337.simulation.environment.PropertiesStorage;

public class Coordinates {
    private int column;
    private int row;

    public Coordinates(int column, int row) {
        setColumn(column);
        setRow(row);
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        if (isColumnOutOfBounds(column)) {
            throw new IllegalArgumentException("Column out of bounds");
        } else {
            this.column = column;
        }
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        if (isRowOutOfBounds(row)) {
            throw new IllegalArgumentException("Row out of bounds");
        } else {
            this.row = row;
        }
    }

    private boolean isColumnOutOfBounds(int column) {
        return column < 0 || column > PropertiesStorage.WIDTH;
    }

    private boolean isRowOutOfBounds(int row) {
        return row < 0 || row > PropertiesStorage.HEIGHT;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Coordinates that = (Coordinates) o;
        return column == that.column && row == that.row;
    }

    @Override
    public int hashCode() {
        int result = column;
        result = 31 * result + row;
        return result;
    }
}
