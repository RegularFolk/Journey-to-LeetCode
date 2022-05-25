package Easy;

import java.util.HashSet;
import java.util.Set;

public class LC_961 {
    public int repeatedNTimes(int[] nums) {
        Set<Integer> hash = new HashSet<>();
        for (int num : nums) {
            if (hash.contains(num)) {
                return num;
            } else {
                hash.add(num);
            }
        }
        return -1;
    }
}
