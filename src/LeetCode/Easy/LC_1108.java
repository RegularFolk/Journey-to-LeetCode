package LeetCode.Easy;

public class LC_1108 {
    public String defangIPaddr(String address) {
        StringBuilder stringBuilder = new StringBuilder();
        String add = "[.]";
        for (int i = 0; i < address.length(); i++) {
            char c = address.charAt(i);
            if (c == '.') {
                stringBuilder.append(add);
            } else {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }
}
