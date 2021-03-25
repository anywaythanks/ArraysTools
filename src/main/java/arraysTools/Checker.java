package arraysTools;

import java.util.Arrays;
/**
 * A class for checking some things in arrays.
 *
 * @author anywaythanks
 * @version 0.1
 */
public class Checker {

    /**
     * @param array the array to be checked for simplicity (all nested arrays at the same depth have the same size)
     * @return whether the array is simple
     */
    public static boolean isEvenArray(Object array) {
        int[] result = new int[Calculator.calculateDeepArray(array)];
        Arrays.fill(result, -1);
        return isEvenArray(array, 0, result);
    }

    /**
     * @param array                    an array to check for a size mismatch error.
     * @param referenceDimensionsArray correct array sizes
     */
    public static void checkEvenArrayException(Object array, int... referenceDimensionsArray) {
        if (Calculator.calculateDeepArray(array) != referenceDimensionsArray.length) {
            throw new IllegalArgumentException("The array has the wrong depth.");
        } else if (!isEvenArray(array)) {
            throw new IllegalArgumentException("The array is not even.");
        } else if (!Arrays.equals(Calculator.calculateLengthsEvenArray(array), referenceDimensionsArray)) {
            throw new IllegalArgumentException("The array is not sized correctly.");
        }
    }

    /**
     * Function for object detection.
     *
     * @param containedObject the object to look for in the array.
     * @param array           an array in which to look for an object.
     * @return if there is a matching object in the array, then true, otherwise false.
     */
    public static boolean isContainedArray(Object containedObject, Object... array) {
        for (Object object : array)
            if (object.equals(containedObject))
                return true;
        return false;
    }


    private static boolean isEvenArray(Object array, int deep, int[] lengths) {
        if (array == null) {
            return false;
        } else if (array instanceof boolean[]) {
            if (lengths[deep] == -1) {
                lengths[deep] = ((boolean[]) array).length;
            } else return lengths[deep] == ((boolean[]) array).length;
        } else if (array instanceof char[]) {
            if (lengths[deep] == -1) {
                lengths[deep] = ((char[]) array).length;
            } else return lengths[deep] == ((char[]) array).length;
        } else if (array instanceof short[]) {
            if (lengths[deep] == -1) {
                lengths[deep] = ((short[]) array).length;
            } else return lengths[deep] == ((short[]) array).length;
        } else if (array instanceof int[]) {
            if (lengths[deep] == -1) {
                lengths[deep] = ((int[]) array).length;
            } else return lengths[deep] == ((int[]) array).length;
        } else if (array instanceof long[]) {
            if (lengths[deep] == -1) {
                lengths[deep] = ((long[]) array).length;
            } else return lengths[deep] == ((long[]) array).length;
        } else if (array instanceof float[]) {
            if (lengths[deep] == -1) {
                lengths[deep] = ((float[]) array).length;
            } else return lengths[deep] == ((float[]) array).length;
        } else if (array instanceof double[]) {
            if (lengths[deep] == -1) {
                lengths[deep] = ((double[]) array).length;
            } else return lengths[deep] == ((double[]) array).length;
        } else if (array.getClass().isArray()) {
            if (lengths[deep] == -1) {
                lengths[deep] = ((Object[]) array).length;
            } else if (lengths[deep] != ((Object[]) array).length) {
                return false;
            }
            if (lengths[deep] > 0) {
                if (lengths[deep] == -1) {
                    lengths[deep] = ((Object[]) array).length;
                } else if (lengths[deep] != ((Object[]) array).length) {
                    return false;
                }
                ++deep;
                if (deep != 1) {
                    for (Object array1 : ((Object[]) array)) {
                        if (array1.getClass().isArray()) {
                            isEvenArray(array1, deep, lengths);
                        }
                    }
                } else {
                    boolean res = true;
                    for (Object array1 : ((Object[]) array)) {
                        if (!isEvenArray(array1, deep, lengths)) {
                            res = false;
                        }
                    }
                    return res;
                }
            }
        }
        return true;
    }
}
