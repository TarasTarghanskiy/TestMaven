package proj;

import java.util.stream.IntStream;

public class Third {

    public static int nod(int n1, int n2, int n3, int n4) {
        if (n1 < 1 || n2 < 1 || n3 < 1 || n4 < 1) throw new NumberFormatException("all numbers must be bigger than 0");
        int min = IntStream.of(n1, n2, n3, n4).min().getAsInt();
        if (n1 % min == 0 && n2 % min == 0 && n3 % min == 0 && n4 % min == 0) {
            return min;
        }
        return euclid(euclid(n1, n2), euclid(n3, n4));

//        while (min > 0) {
//            if (n1 % min == 0 && n2 % min == 0 && n3 % min == 0 && n4 % min == 0) {
//                System.out.println(" answer " + min);
//                return;
//            }
//            min--;
//        }
    }

    private static int euclid(int a, int b) {
        while (true) {
            int num = a % b;
            if (num != 0) {
                a = b;
                b = num;
            } else {
                return b;
            }
        }
    }
}
