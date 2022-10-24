package Leet.Medium;

public class LC_299 {
    public static void main(String[] args) {
        System.out.println(getHint("1807", "7810"));
    }

    public static String getHint(String secret, String guess) {
        int[] countS = new int[10];
        int[] countG = new int[10];
        int bull = 0;
        int cow = 0;
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bull++;
            } else {
                countS[secret.charAt(i) - '0']++;
                countG[guess.charAt(i) - '0']++;
            }
        }
        for (int i = 0; i < 10; i++) {
            cow += Math.min(countS[i], countG[i]);
        }
        return bull + "A" + cow + "B";
    }
}
