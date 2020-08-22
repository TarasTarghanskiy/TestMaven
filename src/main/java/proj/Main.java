package proj;

import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.IntStream;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {

//        First.reverse(1, 2);
//        Second.entranceFloorDeterminer(9, 4, 1);
//        Second.entranceFloorDeterminer(9, 4, 36);
//        Second.entranceFloorDeterminer(9, 4, 37);
//        Second.entranceFloorDeterminer(9, 4, 72);
//        Fourth fourth = new Fourth();
//        fourth.fibonacci(9999);
//        Third.nod(15, 75, 35, 25);
//        Fifth.dayOfWeek(3, 17, 7);

        int task = -1;
        while (task != 0) {
            try{
                task = enter("enter task number\n1) number swap\n2) find floor and entrance\n3) GCD for four numbers\n4) Fibonacci int\n5) find day of week\n4) Fibonacci BigInteger\n0) exit");
                switch (task) {
                    case 1:
                        First.setNumbers(enterBigInteger("enter first number"), enterBigInteger("enter second number"));
                        First.show();
                        First.reverse();
                        First.show();
                        break;
                    case 2:
                        Second.entranceFloorDeterminer(enter("enter max floor", 1), enter("enter flat per floor count", 1), enter("enter flat count", 1));
                        break;
                    case 3:
                        System.out.println("answer" + Third.nod(
                                enter("enter first number", 1),
                                enter("enter second number", 1),
                                enter("enter third number", 1),
                                enter("enter fourth number", 1)
                        ));
                        break;
                    case 4:
                        Fourth.fibonacci(enter("enter number", 0));
                        break;
                    case 5:
                        System.out.println("day of week " +
                                Fifth.dayOfWeek(
                                        enter("enter day of week of new year", 1, 7),
                                        enter("enter day", 1, 31),
                                        enter("enter month", 1, 12))
                        );
                        break;
                    case 6:
                        Fourth.fibonacci(enterBigInteger("enter number"));
                        break;
                }
            }catch (NumberFormatException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    private static int enter(String s) {
        return enter(s, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static int enter(String s, int border) {
        return enter(s, border, Integer.MAX_VALUE);
    }

    private static int enter(String s, int border, int up) {
        while (true) {
            int t;
            try {
                System.out.println(s);
                t = Integer.parseInt(br.readLine());
                if (t < border || t > up) throw new NumberFormatException();
                return t;
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NumberFormatException e) {
                System.err.println("number must be in range " + border + " | " + up);
            }
        }
    }

    private static BigInteger enterBigInteger(String s) {
        while (true) {
            BigInteger t;
            try {
                System.out.println(s);
                t = new BigInteger(br.readLine());
                return t;
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NumberFormatException e) {
                System.err.println("wrong number");
            }
        }
    }
}
