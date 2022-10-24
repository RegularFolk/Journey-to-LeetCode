package Leet.Easy;

import java.util.HashSet;
import java.util.Set;

public class LC_6171 {
    /*
     * �����ͣ���setά���ѳ��ֹ���
     * */
    public boolean findSubarrays(int[] nums) {
        Set<Long> set = new HashSet<>();
        for (int i = 1; i < nums.length; i++) {
            long add = nums[i - 1] + nums[i];
            if (set.contains(add)) return true;
            set.add(add);
        }
        return false;
    }
}
