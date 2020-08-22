package basetest;

import org.junit.Assert;
import org.junit.Test;
import proj.Fifth;

import java.util.LinkedHashMap;
import java.util.Map;

public class FifthTest extends Assert {

    @Test
    public void basicTest() {
        Map<Integer, Integer> calendar = new LinkedHashMap<>();

        calendar.put(1, 31);
        calendar.put(2, 28);
        calendar.put(3, 31);
        calendar.put(4, 30);
        calendar.put(5, 31);
        calendar.put(6, 30);
        calendar.put(7, 31);
        calendar.put(8, 31);
        calendar.put(9, 30);
        calendar.put(10, 31);
        calendar.put(11, 30);
        calendar.put(12, 31);

        int dayOfWeek = 2;
        for (Map.Entry<Integer, Integer> entry : calendar.entrySet()) {
            for (int i = 1; i <= entry.getValue(); i++) {
                assertEquals(dayOfWeek, Fifth.dayOfWeek(2, i, entry.getKey()));
                dayOfWeek = dayOfWeek != 7 ? dayOfWeek + 1 : 1;
            }
        }

        dayOfWeek = 1;
        for (Map.Entry<Integer, Integer> entry : calendar.entrySet()) {
            for (int i = 1; i <= entry.getValue(); i++) {
                assertEquals(dayOfWeek, Fifth.dayOfWeek(1, i, entry.getKey()));
                dayOfWeek = dayOfWeek != 7 ? dayOfWeek + 1 : 1;
            }
        }
    }

    @Test()
    public void newYearDayBadTest() {
        boolean pass = true;
        for (int i = 8; i < 1000; i++) {
            try {
                Fifth.dayOfWeek(i, 1, 1);
                pass = false;
            } catch (NumberFormatException n) {

            }
        }
        for (int i = 0; i > -10000; i -= 1) {
            try {
                Fifth.dayOfWeek(i, 1, 1);
                pass = false;
            } catch (NumberFormatException n) {

            }
        }
        assertTrue(pass);
    }

    @Test()
    public void searchingDayBadTest() {
        Map<Integer, Integer> calendar = new LinkedHashMap<>();

        calendar.put(1, 31);
        calendar.put(2, 28);
        calendar.put(3, 31);
        calendar.put(4, 30);
        calendar.put(5, 31);
        calendar.put(6, 30);
        calendar.put(7, 31);
        calendar.put(8, 31);
        calendar.put(9, 30);
        calendar.put(10, 31);
        calendar.put(11, 30);
        calendar.put(12, 31);

        boolean pass = true;
        for (Map.Entry<Integer, Integer> entry : calendar.entrySet()) {
            for (int i = entry.getValue() + 1; i < 1000; i++) {
                try {
                    Fifth.dayOfWeek(1, i, entry.getKey());
                    pass = false;
                } catch (NumberFormatException n) {

                }
            }
        }
        for (int i = 0; i > -10000; i -= 1) {
            try {
                Fifth.dayOfWeek(1, i, 1);
                pass = false;
            } catch (NumberFormatException n) {

            }
        }
        assertTrue(pass);
    }

    @Test()
    public void searchingMonthBadTest() {
        boolean pass = true;
        for (int i = 13; i < 1000; i++) {
            try {
                Fifth.dayOfWeek(1, 1, i);
                pass = false;
            } catch (NumberFormatException n) {

            }
        }
        for (int i = 0; i > -10000; i -= 1) {
            try {
                Fifth.dayOfWeek(1, 1, i);
                pass = false;
            } catch (NumberFormatException n) {

            }
        }
        assertTrue(pass);
    }
}
