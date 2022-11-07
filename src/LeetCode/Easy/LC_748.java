package LeetCode.Easy;

import java.util.Arrays;

public class LC_748 {
    public static void main(String[] args) {
        String licensePlate = "AN87005";
        String[] words = new String[]{"participant","individual","start","exist","above","already","easy","attack","player","important"};
        System.out.println(shortestCompletingWord(licensePlate, words));
    }

    public static String shortestCompletingWord(String licensePlate, String[] words) {
        int[] fre = new int[26];
        int count = 0;
        String ans = "";
        for (int i = 0; i < licensePlate.length(); i++) {
            char temp = licensePlate.charAt(i);
            if (Character.isLetter(temp)) {
                temp = Character.toLowerCase(temp);
                fre[temp - 'a']++;
                count++;
            }
        }
        for (String word : words) {
            if (word.length() >= count) {
                int thisCount = 0;
                int[] clone = Arrays.copyOf(fre, 26);
                for (int j = 0; j < word.length(); j++) {
                    char thisChar = word.charAt(j);
                    if (Character.isLetter(thisChar)) {
                        thisChar = Character.toLowerCase(thisChar);
                        if (clone[thisChar - 'a'] > 0) {
                            thisCount++;
                            clone[thisChar - 'a']--;
                            if (thisCount == count) {
                                ans = ans.length() == 0 ? word : ans.length() > word.length() ? word : ans;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return ans;
    }
}
