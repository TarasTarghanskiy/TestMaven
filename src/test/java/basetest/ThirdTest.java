package basetest;

import org.junit.Assert;
import org.junit.Test;
import proj.Third;

public class ThirdTest extends Assert {

    @Test
    public void basicTest() {
        assertEquals(1, Third.nod(1, 1, 1, 1));

        assertEquals(3, Third.nod(3, 9, 12, 15));

        assertEquals(2, Third.nod(6, 56, 742, 400));

        assertEquals(1_000, Third.nod(10_000, 1_000_000, 100_000, 1_000));

        assertEquals(5, Third.nod(5437645, 23425, 53535, 1235325));

        int maxim = Integer.MAX_VALUE;

        assertEquals(1, Third.nod(
                maxim,
                maxim,
                maxim,
                maxim
        ));

        assertEquals(1, Third.nod(6234235, 562354, 7422345, 4003453));
    }


    @Test(expected = NumberFormatException.class)
    public void firstMinusTest1() {
        Third.nod(-1, 1, 1, 1);
    }

    @Test(expected = NumberFormatException.class)
    public void secondMinusTest1() {
        Third.nod(Integer.MIN_VALUE, 1, 1, 1);
    }

    @Test(expected = NumberFormatException.class)
    public void nullTest() {
        Third.nod(0, 1, 1, 1);
    }



    @Test(expected = NumberFormatException.class)
    public void firstMinusTest2() {
        Third.nod(1, -1, 1, 1);
    }

    @Test(expected = NumberFormatException.class)
    public void secondMinusTest2() {
        Third.nod(1, Integer.MIN_VALUE, 1, 1);
    }


    @Test(expected = NumberFormatException.class)
    public void firstMinusTest3() {
        Third.nod(1, 1, -1, 1);
    }

    @Test(expected = NumberFormatException.class)
    public void secondMinusTest3() {
        Third.nod(1, 1, Integer.MIN_VALUE, 1);
    }


    @Test(expected = NumberFormatException.class)
    public void firstMinusTest4() {
        Third.nod(1, 1, 1, -1);
    }

    @Test(expected = NumberFormatException.class)
    public void secondMinusTest4() {
        Third.nod(1, 1, 1, Integer.MIN_VALUE);
    }

    @Test(expected = NumberFormatException.class)
    public void nullTest2() {
        Third.nod(1, 0, 1, 1);
    }


    @Test(expected = NumberFormatException.class)
    public void nullTest3() {
        Third.nod(1, 1, 0, 1);
    }


    @Test(expected = NumberFormatException.class)
    public void nullTest4() {
        Third.nod(1, 1, 1, 0);
    }
}
