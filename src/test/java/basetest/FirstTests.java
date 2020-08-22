package basetest;

import org.junit.Assert;
import org.junit.Test;
import proj.First;

import java.math.BigInteger;

public class FirstTests extends Assert {

    @Test
    public void zeroTest() {
        BigInteger a = BigInteger.valueOf(0);
        BigInteger b = BigInteger.valueOf(0);
        First.setNumbers(a, b);
        First.reverse();
        assertTrue(First.check(b, a));
    }

    @Test
    public void oneZeroTest() {
        BigInteger a = BigInteger.valueOf(0);
        BigInteger b = BigInteger.valueOf(-1);
        First.setNumbers(a, b);
        First.reverse();
        assertTrue(First.check(b, a));


        a = BigInteger.valueOf(0);
        b = BigInteger.valueOf(1);
        First.setNumbers(a, b);
        First.reverse();
        assertTrue(First.check(b, a));
    }

    @Test
    public void minusPlusTest() {
        BigInteger a = BigInteger.valueOf(999723999);
        BigInteger b = BigInteger.valueOf(-999009999);
        First.setNumbers(a, b);
        First.reverse();
        assertTrue(First.check(b, a));
    }

    @Test
    public void plusPlusTest() {
        BigInteger a = BigInteger.valueOf(999997999);
        BigInteger b = BigInteger.valueOf(993499999);
        First.setNumbers(a, b);
        First.reverse();
        assertTrue(First.check(b, a));
    }

    @Test
    public void minusMinusTest() {
        BigInteger a = BigInteger.valueOf(-999999999);
        BigInteger b = BigInteger.valueOf(-999989999);
        First.setNumbers(a, b);
        First.reverse();
        assertTrue(First.check(b, a));
    }

    @Test
    public void veryBigNumbersTest() {
        BigInteger a = new BigInteger("999999999999999999");
        BigInteger b = new BigInteger("999999999999999999999");
        First.setNumbers(a, b);
        First.reverse();
        assertTrue(First.check(b, a));
    }
}
