package Leet.Easy;

public class LC_1678 {
    public String interpret(String command) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < command.length(); i++) {
            char charAt = command.charAt(i);
            if (charAt == '(') {
                if (command.charAt(i + 1) == ')') {
                    stringBuilder.append('o');
                } else {
                    while (command.charAt(i + 1) != ')') {
                        stringBuilder.append(command.charAt(i + 1));
                        i++;
                    }
                }
                i++;
            } else {
                stringBuilder.append(charAt);
            }
        }
        return stringBuilder.toString();
    }
}
