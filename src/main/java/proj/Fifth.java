package proj;

import java.util.LinkedHashMap;
import java.util.Map;

public class Fifth {

    private static Map<Integer, Integer> calendar = new LinkedHashMap<>();

    static {
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
    }

    public static int dayOfWeek(int newYearDay, int searchingDay, int searchingMonth) {
        if (newYearDay < 1 || newYearDay > 7) throw new NumberFormatException("new year day must be in range 1-7");
        if (searchingMonth < 1 || searchingMonth > 12)
            throw new NumberFormatException("searching month must be in range 1-12");
        if (searchingDay < 1 || searchingDay > calendar.get(searchingMonth))
            throw new NumberFormatException("searching day must be in range 1-" + calendar.get(searchingMonth));

        int dayCount = calendar.entrySet().stream()
                .filter(a -> a.getKey() < searchingMonth)
                .map(Map.Entry::getValue)
                .reduce(0, Integer::sum) + searchingDay + newYearDay - 1;
        return dayCount % 7 == 0 ? 7 : dayCount % 7;
    }
}
