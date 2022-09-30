package Easy;

import java.util.Arrays;

public class LC_6188 {
    /*
    * ≈≈–Ú
    * */
    public String[] sortPeople(String[] names, int[] heights) {
        String[][] nh = new String[names.length][2];
        for (int i = 0; i < names.length; i++) {
            nh[i][0] = names[i];
            nh[i][1] = String.valueOf(heights[i]);
        }
        Arrays.sort(nh, (a, b) -> Integer.parseInt(b[1]) - Integer.parseInt(a[1]));
        String[] ans = new String[names.length];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = nh[i][0];
        }
        return ans;
    }
}
