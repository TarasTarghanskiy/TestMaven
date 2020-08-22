package proj;

public class Second {

    private static int floor;
    private static int entrance;


    public static void entranceFloorDeterminer(int maxFloor, int flatPerFloorCount, int flatNumber) {
        if (maxFloor < 1 || flatPerFloorCount < 1 || flatNumber < 1)
            throw new NumberFormatException("max floor, flat per floor count and flat number - all must be bigger than 0");
        if (maxFloor > 46340 || flatPerFloorCount > 46340)
            throw new NumberFormatException("max floor and flat per floor must be lower than 46340");
        int flatPerEntranceCount = maxFloor * flatPerFloorCount; // WARNING

        int d = flatNumber % flatPerEntranceCount;

        if (d == 0) {
            floor = maxFloor;
            entrance = flatNumber / flatPerEntranceCount;
        } else {
            if (d % flatPerFloorCount == 0)
                floor = (d / flatPerFloorCount);
            else
                floor = 1 + (d / flatPerFloorCount);
            entrance = 1 + (flatNumber / flatPerEntranceCount);
        }
    }

    public static void show() {
        System.out.println("entrance " + entrance + " floor " + floor);
    }

    public static int getFloor() {
        return floor;
    }

    public static int getEntrance() {
        return entrance;
    }
}
