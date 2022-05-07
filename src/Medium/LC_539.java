package Medium;

import java.util.Arrays;
import java.util.List;

public class LC_539 {
    public int findMinDifference(List<String> timePoints) {
        if (timePoints.size() > 1440) {
            return 0;
        }
        String[] temp = new String[timePoints.size()];
        int len = temp.length;
        for (int i = 0; i < len; i++) {
            temp[i] = timePoints.get(i);
        }
        Arrays.sort(temp);
        int min = ((temp[len - 1].charAt(0) - temp[0].charAt(0)) * 600) + ((temp[len - 1].charAt(1) - temp[0].charAt(1)) * 60) + ((temp[len - 1].charAt(3) - temp[0].charAt(3)) * 10) + (temp[len - 1].charAt(4) - temp[0].charAt(4));
        min = 1440 - min;
        for (int i = 0; i < temp.length - 1; i++) {
            if (temp[i].equals(temp[i + 1])) {
                return 0;
            } else {
                int current = ((temp[i + 1].charAt(0) - temp[i].charAt(0)) * 600) + ((temp[i + 1].charAt(1) - temp[i].charAt(1)) * 60) + ((temp[i + 1].charAt(3) - temp[i].charAt(3)) * 10) + (temp[i + 1].charAt(4) - temp[i].charAt(4));
                min = Math.min(current, min);
            }
        }
        return min;
    }
}
