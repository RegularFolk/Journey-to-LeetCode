package Easy;

import java.util.HashSet;
import java.util.Set;

public class LC_929 {
    public int numUniqueEmails(String[] emails) {
        Set<String> locals = new HashSet<>(), domain = new HashSet<>();
        int ans = 0;
        for (String email : emails) {
            String[] split = email.split("[@]");
            StringBuilder local = new StringBuilder();
            for (int i = 0; i < split[0].length(); i++) {
                char c = split[0].charAt(i);
                if (c == '+') {
                    break;
                } else if (c != '.') {
                    local.append(c);
                }
            }
            if (!locals.contains(local.toString()) || !domain.contains(split[1])) {
                locals.add(local.toString());
                domain.add(split[1]);
                ans++;
            }
        }
        return ans;
    }
}
