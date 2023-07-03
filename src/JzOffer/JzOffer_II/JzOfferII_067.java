package JzOffer.JzOffer_II;


public class JzOfferII_067 {
    /*
     * 将数值转为二进制，利用二进制构建tire树
     * 对于每一个值，寻找尽可能与之二进制下相反的值
     * */
    public int findMaximumXOR(int[] nums) {
        prime = new node();
        byte[][] vals = new byte[nums.length][32];
        for (int i = 0; i < nums.length; i++) {
            vals[i] = toBinary(nums[i]);
            insert(vals[i]);
        }
        int max = 0;
        for (int i = 0; i < vals.length; i++) {
            int diff = getDiff(vals[i]);
            max = Math.max(max, diff ^ nums[i]);
        }
        return max;
    }

    private int getDiff(byte[] val) {
        node cur = prime;
        int ans = 0;
        for (byte b : val) {
            if (cur.children[1 - b] != null) cur = cur.children[1 - b];
            else cur = cur.children[b];
            ans = (ans << 1) + cur.val;
        }
        return ans;
    }

    private void insert(byte[] vals) {
        node cur = prime;
        for (byte val : vals) {
            if (cur.children[val] == null) cur.children[val] = new node();
            cur = cur.children[val];
            cur.val = val;
        }
    }

    private byte[] toBinary(int num) {
        byte[] bytes = new byte[32];
        for (int i = 31; i >= 0; i--) {
            bytes[i] = (byte) (num & 1);
            num >>= 1;
        }
        return bytes;
    }

    private static node prime;

    private static class node {
        node[] children = new node[2];
        byte val = 0;
    }


}
