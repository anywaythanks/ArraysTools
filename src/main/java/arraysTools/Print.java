package arraysTools;

import java.io.PrintStream;

/**
 * Class for output.
 *
 * @author anywaythanks
 * @version 1.0
 */
public class Print {
    public static void println(Object o) {
        print(o);
        System.out.println();
    }

    public static void println(PrintStream out, Object o) {
        print(out, o);
        out.println();
    }

    public static void println(String separator, Object o) {
        print(separator, o);
        System.out.println();
    }

    public static void println(PrintStream out, String separator, Object o) {
        print(out, separator, o);
        out.println();
    }

    public static void print(Object o) {
        print(System.out, "\t", o);
    }

    public static void print(String separator, Object o) {
        print(System.out, separator, o);
    }

    public static void print(PrintStream out, Object o) {
        print(out, "\t", o);
    }

    public static void print(PrintStream out, String separator, Object o) {
        massive(o, out, separator);
    }

    /**
     * Output an array.
     *
     * @param array array.
     */
    private static void massive(Object array, PrintStream out, String separator) {
        if (array instanceof boolean[]) {
            for (boolean p : ((boolean[]) array))
                massive(p, out, separator);
            out.println();
        } else if (array instanceof char[]) {
            for (char p : ((char[]) array))
                massive(p, out, separator);
            out.println();
        } else if (array instanceof short[]) {
            for (short p : ((short[]) array))
                massive(p, out, separator);
            out.println();
        } else if (array instanceof int[]) {
            for (int p : ((int[]) array))
                massive(p, out, separator);
            out.println();
        } else if (array instanceof long[]) {
            for (long p : ((long[]) array))
                massive(p, out, separator);
            out.println();
        } else if (array instanceof float[]) {
            for (float p : ((float[]) array))
                massive(p, out, separator);
            out.println();
        } else if (array instanceof double[]) {
            for (double p : ((double[]) array))
                massive(p, out, separator);
            out.println();
        } else {
            if (array.getClass().isArray()) {
                for (Object p : ((Object[]) array))
                    massive(p, out, separator);
                out.println();
            } else
                out.print(array.toString() + separator);
        }
    }
}