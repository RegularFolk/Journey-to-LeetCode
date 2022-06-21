package JzOffer;

import java.util.HashMap;
import java.util.Map;

/**
 * Unsolved
 */
public class JzOffer_114 {
    public static void main(String[] args) {
        System.out.println(alienOrder(new String[]{"wrt", "wrf", "er", "ett", "rftt"}));
    }

    public static String alienOrder(String[] words) {
        Map<Character, Integer> map = new HashMap<>();
        int lens = words.length, thisLen, maxLen = 0, startUp, seq = 0;//记录最大遍历过的字符串长度
        StringBuilder ans = new StringBuilder();

        return ans.toString();
    }
    /*for (int i = 0; i < lens - 1; i++) { //选择起点字符串
            //比较起点长度和最大长度
            thisLen = words[i].length();
            if (thisLen <= maxLen) {//若小,跳过该起点字符串
                continue;
            } else { //若大，则设置对逐个字符串遍历的起点.更新maxLen
                startUp = maxLen;
                maxLen = thisLen;
            }
            for (int j = i; j < lens - 1; j++) { //从起点字符串开始往后
                int cur = j + 1;
                while (words[cur].length() <= startUp) {
                    cur++;
                }
                if (cur > lens - 1) { //说明只存在起点字符串一个长度大于起点下标

                }
            }
        }*/
    /*for (int i = 0; i < lens - 1; i++) {
            thisLen = words[i].length();
            if (thisLen <= maxLen) { //如果包含该长度说明已经被全部遍历过了
                continue;
            } else {
                useLen = maxLen == 0 ? 0 : thisLen - maxLen - 1;
                maxLen = thisLen;
            }
            for (int k = i; k < lens - 1; k++) {
                for (int j = useLen; j < thisLen; j++) { //对逐个字符进行比较
                    if (words[k + 1].length() >= j + 1) {
                        char c1 = words[k].charAt(j);
                        char c2 = words[k + 1].charAt(j);
                        if (c1 != c2) {
                            Integer s1 = map.getOrDefault(c1, 0);
                            Integer s2 = map.getOrDefault(c2, 0);
                            if (s1 == 0 && s2 == 0) { //新来的两位
                                map.put(c1, ++seq);
                                map.put(c2, ++seq);
                                ans.append(c1).append(c2);
                            } else if (s1 == 0 || s2 < s1) { //前者为零但是后者不为零,或者后者比前者序号小
                                return "";
                            } else if (s2 == 0) {
                                map.put(c2, ++seq);
                                ans.append(c2);
                            }
                        }
                    } else {
                        break;
                    }
                }
            }
        }*/
    /*for (int a = 0; a < lens - 1; a++) {
            thisLen = words[a].length();
            if (thisLen <= maxLen) {
                continue;
            } else {
                useLen = thisLen - maxLen;
                maxLen = thisLen;
            }
            for (int i = a; i < lens - 1; i++) {

            }
        }*/
}
