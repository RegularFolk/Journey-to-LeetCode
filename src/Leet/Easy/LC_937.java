package Leet.Easy;

import java.util.Arrays;

public class LC_937 {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (o1, o2) -> {
            String[] split1 = o1.split("[ ]");
            String[] split2 = o2.split("[ ]");
            boolean digit1 = Character.isDigit(split1[1].charAt(0));
            boolean digit2 = Character.isDigit(split2[1].charAt(0));
            if (digit1 && digit2) {
                return 0;
            } else if (digit1 || digit2) {
                return digit1 ? 1 : -1;
            } else { //两者都不是数字
                String flag1 = split1[0];
                String flag2 = split2[0];
                String[] rest1 = Arrays.copyOfRange(split1, 1, split1.length);
                String[] rest2 = Arrays.copyOfRange(split2, 1, split2.length);
                for (int i = 0; i < rest1.length && i < rest2.length; i++) {
                    int i1 = rest1[i].compareTo(rest2[i]);
                    if (i1 != 0) {
                        return i1;
                    }
                }
                if (rest1.length != rest2.length) {
                    return rest1.length > rest2.length ? 1 : -1;
                }
                //如果还相等
                return flag1.compareTo(flag2);
            }
        });
        return logs;
    }
}
