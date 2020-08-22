package basetest;

import org.junit.Assert;
import org.junit.Test;
import proj.Second;

public class SecondTests extends Assert {
    @Test
    public void basicTest() {
        Second.entranceFloorDeterminer(1, 1, 1);
        assertTrue(Second.getEntrance() == 1 && Second.getFloor() == 1);

        Second.entranceFloorDeterminer(9, 4, 1);
        assertTrue(Second.getEntrance() == 1 && Second.getFloor() == 1);

        Second.entranceFloorDeterminer(9, 4, 36);
        assertTrue(Second.getEntrance() == 1 && Second.getFloor() == 9);

        Second.entranceFloorDeterminer(9, 4, 37);
        assertTrue(Second.getEntrance() == 2 && Second.getFloor() == 1);

        Second.entranceFloorDeterminer(9, 4, 72);
        assertTrue(Second.getEntrance() == 2 && Second.getFloor() == 9);

        Second.entranceFloorDeterminer(9, 4, 83);
        assertTrue(Second.getEntrance() == 3 && Second.getFloor() == 3);
    }

    @Test
    public void firstParameterMinusTest() {
        boolean error = true;
        for (int i = 0; i < 100_000; i-= 1_000) {
            try{
                Second.entranceFloorDeterminer(9, 9, i);
                error = false;
            } catch (NumberFormatException n) {

            }
        }
        assertTrue(error);
    }

    @Test
    public void firstParameterPlusTest() {
        boolean works = true;
        for (int i = 1; i < 2_000_000_000; i+= 1_000) {
            try{
                Second.entranceFloorDeterminer(9, 9, i);
            } catch (NumberFormatException n) {
                works = false;
            }
        }
        assertTrue(works);
    }

    @Test
    public void secondParameterMinusTest() {
        boolean error = true;
        for (int i = 0; i < 100_000; i-= 1_000) {
            try{
                Second.entranceFloorDeterminer(9, i, 9);
                error = false;
            } catch (NumberFormatException n) {

            }
        }
        assertTrue(error);
    }

    @Test
    public void secondParameterPlusTest() {
        boolean works = true;
        for (int i = 1; i < 46_000; i+= 1_000) {
            try{
                Second.entranceFloorDeterminer(9, i, 9);
            } catch (NumberFormatException n) {
                works = false;
            }
        }
        assertTrue(works);
    }

    @Test
    public void thirdParameterMinusTest() {
        boolean error = true;
        for (int i = 0; i < 100_000; i-= 1_000) {
            try{
                Second.entranceFloorDeterminer(i, 9, 9);
                error = false;
            } catch (NumberFormatException n) {

            }
        }
        assertTrue(error);
    }

    @Test
    public void thirdParameterPlusTest() {
        boolean works = true;
        for (int i = 1; i < 46_000; i+= 1_000) {
            try{
                Second.entranceFloorDeterminer(i, 9, 9);
            } catch (NumberFormatException n) {
                works = false;
            }
        }
        assertTrue(works);
    }

    @Test
    public void maxValueTest() {
        Second.entranceFloorDeterminer(
                46340,
                46340,
                Integer.MAX_VALUE);
        assertTrue(Second.getEntrance() == 2 && Second.getFloor() == 2);
    }
}
