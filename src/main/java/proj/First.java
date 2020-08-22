package proj;

import java.math.BigInteger;
import java.util.Map;

public class First {

    public static BigInteger first;
    public static BigInteger second;

    public static void setNumbers(BigInteger a, BigInteger b) {
        first = a;
        second = b;
    }

    public static void reverse() {
        first = first.add(second);
        second = first.subtract(second);
        first = first.subtract(second);
    }

    public static boolean check(BigInteger a, BigInteger b) {
        return a.compareTo(first) == 0 && b.compareTo(second) == 0;
    }

    public static void show() {
        System.out.println(first + " = " + second);
    }
}
