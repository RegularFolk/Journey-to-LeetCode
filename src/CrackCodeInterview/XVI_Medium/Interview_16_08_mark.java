package CrackCodeInterview.XVI_Medium;

import org.junit.Test;

import java.util.LinkedList;

public class Interview_16_08_mark {
    String[] smalls = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
            "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] bigs = {"", "Thousand", "Million", "Billion"};
    String hundred = "Hundred";
    String negative = "Negative";

    /*
     * 繁琐,每三位之间处理
     * */
    public String numberToWords(int num) {
        if (num == 0) return smalls[0];
        else if (num < 0) return negative + " " + numberToWords(num * -1);
        LinkedList<String> list = new LinkedList<>();
        int count = 0;
        while (num > 0) {
            if (num % 1000 != 0) {
                String chunk = convert(num % 1000) + " " + bigs[count];
                list.addFirst(chunk);
            }
            num /= 1000;
            count++;
        }
        StringBuilder builder = new StringBuilder();
        for (String s : list) {
            builder.append(s).append(" ");
        }
        return builder.toString().trim();
    }

    /*
     * 将三位数转为字符串
     * */
    private String convert(int num) {
        StringBuilder builder = new StringBuilder();
        if (num >= 100) {
            builder.append(smalls[num / 100]).append(" ").append(hundred).append(" ");
            num %= 100;
        }
        if (num >= 10 && num <= 19) {
            builder.append(smalls[num]).append(" ");
        } else if (num >= 20) {
            builder.append(tens[num / 10]).append(" ");
            num %= 10;
        }
        if (num >= 1 && num <= 9) {
            builder.append(smalls[num]).append(" ");
        }
        builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }


    @Test
    public void x() {
        System.out.println(Integer.MAX_VALUE);
    }
}
