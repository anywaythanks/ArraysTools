package arraysTools;


/**
 * A class for performing mathematical operations with arrays.
 *
 * @author anywaythanks
 * @version 0.1
 */
public class Calculator {
    /**
     * @param array массив, глубину которого нужно подсчитать.
     * @return глубина массива.
     */
    public static int calculateDeepArray(Object array) {
        return stringTools.Calculator.calculateQuantitySymbol(array.getClass().getTypeName(), "[");
    }

    /**
     * @param array is a simple (all nested arrays at the same depth have the same size) array.
     * @return the dimensions of the array.
     */
    public static int[] calculateLengthsEvenArray(Object array) {
        return calculateLengthsEvenArray(array, 0, new int[calculateDeepArray(array)]);
    }

    private static int[] calculateLengthsEvenArray(Object array, int deep, int[] lengths) {
        if (array instanceof boolean[]) {
            lengths[deep] = ((boolean[]) array).length;
            return lengths;
        } else if (array instanceof char[]) {
            lengths[deep] = ((char[]) array).length;
            return lengths;
        } else if (array instanceof short[]) {
            lengths[deep] = ((short[]) array).length;
            return lengths;
        } else if (array instanceof int[]) {
            lengths[deep] = ((int[]) array).length;
            return lengths;
        } else if (array instanceof long[]) {
            lengths[deep] = ((long[]) array).length;
            return lengths;
        } else if (array instanceof float[]) {
            lengths[deep] = ((float[]) array).length;
            return lengths;
        } else if (array instanceof double[]) {
            lengths[deep] = ((double[]) array).length;
            return lengths;
        } else {
            if (array.getClass().isArray()) {
                lengths[deep] = ((Object[]) array).length;
                if (lengths[deep] > 0) {
                    return calculateLengthsEvenArray(((Object[]) array)[0], deep + 1, lengths);
                }
            }
            return lengths;
        }
    }

}
