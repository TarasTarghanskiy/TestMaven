package proj;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

public class Fourth {
//    private static Map<Integer, BigInteger> map = new LinkedHashMap<>();

    public static BigInteger fibonacci(BigInteger n) {
        if (n.compareTo(BigInteger.ZERO) < 0) throw new NumberFormatException("n >= 0");
        try {
            return notRecursive1(n);
        } catch (OutOfMemoryError outOfMemoryError) {
            System.out.println(outOfMemoryError.getMessage());
        }
        return BigInteger.valueOf(-1);
    }

    public static BigInteger fibonacci(int n) {
        if (n < 0) throw new NumberFormatException("n >= 0");
        try {
            return notRecursive(n);
        } catch (OutOfMemoryError outOfMemoryError) {
            System.out.println(outOfMemoryError.getMessage());
        }
        return BigInteger.valueOf(-1);
    }

    private static BigInteger notRecursive1(BigInteger n) {
        if (n.compareTo(BigInteger.ONE) == 0) return BigInteger.ONE;
        Map<BigInteger, BigInteger> map = new LinkedHashMap<>();
        map.put(n, BigInteger.ONE);
        BigInteger result = BigInteger.ZERO;
        while (map.size() > 0) {
//            System.out.println("for number " + map.entrySet().stream().max((a, b) -> a.getKey().compareTo(b.getKey()) > 0 ? 1 : 0).get().getKey());
            for (Map.Entry<BigInteger, BigInteger> integer :  map.entrySet().stream().sorted((a, b) -> a.getKey().compareTo(b.getKey()) > 0 ? 1 : 0).collect(Collectors.toList())) {
                map.remove(integer.getKey());
                BigInteger f = integer.getKey().subtract(BigInteger.ONE);
                BigInteger s = integer.getKey().subtract(BigInteger.TWO);
                if (f.compareTo(BigInteger.ONE) > 0) {
                    if (map.containsKey(f)) map.put(f, map.get(f).add(integer.getValue()));
                    else map.put(f, integer.getValue());
                } else if (f.compareTo(BigInteger.ONE) == 0) {
                    result = result.add(integer.getValue());
                }
                if (s.compareTo(BigInteger.ONE) > 0) {
                    if (map.containsKey(s)) map.put(s, map.get(s).add(integer.getValue()));
                    else map.put(s, integer.getValue());
                } else if (s.compareTo(BigInteger.ONE) == 0) {
                    result = result.add(integer.getValue());
                }
            }
        }
        return result;
    }

    private static BigInteger notRecursive(int n) {
        if (n == 1) return BigInteger.ONE;
        Map<Integer, BigInteger> map = new LinkedHashMap<>();
        map.put(n, BigInteger.ONE);
        BigInteger result = BigInteger.ZERO;
        while (map.size() > 0) {
//            System.out.println("for number " + map.entrySet().stream().max((a, b) -> a.getKey() > b.getKey() ? 1 : 0).get().getKey());
//            System.out.println(map.size());
            for (Map.Entry<Integer, BigInteger> integer :  map.entrySet().stream().sorted((a, b) -> a.getKey() > b.getKey() ? 1 : 0).collect(Collectors.toList())) {
                map.remove(integer.getKey());
                int f = integer.getKey() - 1;
                int s = integer.getKey() - 2;
                if (f > 1) {
                    if (map.containsKey(f)) map.put(f, map.get(f).add(integer.getValue()));
                    else map.put(f, integer.getValue());
                } else if (f == 1) {
                    result = result.add(integer.getValue());
                }
                if (s > 1) {
                    if (map.containsKey(s)) map.put(s, map.get(s).add(integer.getValue()));
                    else map.put(s, integer.getValue());
                } else if (s == 1) {
                    result = result.add(integer.getValue());
                }
            }
        }
        return result;
    }
}
