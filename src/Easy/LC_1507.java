package Easy;

import java.util.HashMap;
import java.util.Map;

public class LC_1507 {
    public String reformatDate(String date) {
        Map<String, String> months = new HashMap<>();
        months.put("Jan", "01");
        months.put("Feb", "02");
        months.put("Mar", "03");
        months.put("Apr", "04");
        months.put("May", "05");
        months.put("Jun", "06");
        months.put("Jul", "07");
        months.put("Aug", "08");
        months.put("Sep", "09");
        months.put("Oct", "10");
        months.put("Nov", "11");
        months.put("Dec", "12");
        String[] split = date.split("[ ]");
        StringBuilder ans = new StringBuilder(), day = new StringBuilder();;
        ans.append(split[2]).append("-").append(months.get(split[1])).append("-");
        for (int i = 0; i < split[0].length(); i++) {
            char ch = split[0].charAt(i);
            if (Character.isDigit(ch)) {
                day.append(ch);
            } else {
                ans.append(day.length() == 2 ? day : "0" + day);
                break;
            }
        }
        return ans.toString();
    }
}
