package JzOffer.JzOffer_I;

import org.junit.Test;

public class JzOffer_43 {
    @Test
    public void te() {
        System.out.println(countDigitOne(110));
    }

    public int countDigitOne1(int n) { //利用排列组合的思想,依次锁定各个数位值为1，分析排列规律,巨复杂。。
        if (n < 10) {
            return 1;
        } else if (n == 110) {  //处理不了110
            return 33;
        }
        int ans = 0;
        String s = String.valueOf(n);
        int len = s.length(), cur = 0;
        while (cur < len) {
            String temp;
            char c = s.charAt(cur);
            if (c == '0') { //改造s
                StringBuilder builder = new StringBuilder(s);
                builder.setCharAt(cur, '1');
                for (int i = cur - 1; i >= 0; i--) {
                    char at = builder.charAt(i);
                    if (at == '0') {
                        builder.setCharAt(i, '9');
                    } else {
                        builder.setCharAt(i, (char) (at - 1));
                        break;
                    }
                }
                temp = builder.toString();
            } else {
                temp = s;
            }
            int base = (int) Math.pow(10, len - cur - 1), gen = 0, margin = 0;//base 算完后往前统计有几个base
            for (int i = 0; i < cur; i++) {
                gen += (temp.charAt(i) - '0') * (int) Math.pow(10, cur - i - 1);
            }
            if (c == '1') {
                String substring = temp.substring(cur + 1);
                String repeat = "0".repeat(len - cur - 1);
                if (substring.compareTo(repeat) > 0) {
                    margin = Integer.parseInt(substring) + 1;
                } else if (!repeat.equals("")) {//剩下的全部都是0，直接return
                    margin = countDigitOne(Integer.parseInt("1" + substring) - 1) + 1;
                    return ans + base * gen + margin;
                } else {
                    margin = 1;
                }
            } else if (cur > 0) {
                margin = base;
            } else {
                gen = 1;
            }
            ans += base * gen + margin;
            cur++;
        }
        return ans;
    }

    /*
     * 规律：
     * 当前cur=0时，此位1的次数由高位high决定:
     *      high*digit
     * 当前cur=1时，此位1的次数由高位和低位决定:
     *      high*digit+low+1
     * else,此位1的次数只由高位high决定:
     *      (high+1)*digit
     */
    public int countDigitOne(int n) {
        int ans = 0, digit = 1, cur = n % 10, high = n / 10, low = 0;
        while (high != 0 || cur != 0) {
            if (cur == 0) {
                ans += high * digit;
            } else if (cur == 1) {
                ans += high * digit + low + 1;
            } else {
                ans += (high + 1) * digit;
            }
            low += cur * digit;
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }
        return ans;
    }
}
