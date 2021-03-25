package arraysTools;

import java.awt.*;
/**
 * A class to simplify searching for indexes of an array.
 *
 * @author anywaythanks
 * @version 0.1
 */
public class Coordination {
    /**
     * Converting the coordinates of the array to the cell index.
     *
     * @param x         is the first coordinate of the array.
     * @param y         is the second coordinate of the array.
     * @param sizeArray size array.
     * @return array index.
     */
    public static int indexCells(int x, int y, int sizeArray) {
        return sizeArray * x + y;
    }

    /**
     * Converting the cell index to array coordinates.
     *
     * @param index     is the index of the cell.
     * @param sizeArray maximum possible size of the array string.
     * @return the coordinates of the array.
     */
    public static Point coordinateMassive(int index, int sizeArray) {
        return new Point(index / sizeArray, index % sizeArray);
    }
}
