package JzOffer.JzOffer_II;

public class JzOfferII_065 {

    /*
     * ����tire��
     * ������ÿһ��֦������ۼ�
     * */
    public int minimumLengthEncoding(String[] words) {
        int ans = 0;
        node prime = new node();
        for (String word : words) {
            char[] chars = word.toCharArray();
            node cur = prime;
            for (int i = chars.length - 1; i >= 0; i--) {
                int index = chars[i] - 'a';
                if (cur.children[index] == null) cur.children[index] = new node();
                if (cur.children[index].mark) {
                    ans -= chars.length - i + 1;
                    cur.children[index].mark = false;
                }
                cur = cur.children[index];
            }
            boolean hasChildren = false;
            for (node child : cur.children) {
                if (child != null) {
                    hasChildren = true;
                    break;
                }
            }
            if (!hasChildren) {//û���ӽڵ�ſ��Ա��Ϊ�˵�
                ans += 1 + chars.length;
                cur.mark = true;
            }
        }
        return ans;
    }

    private static class node {
        node[] children = new node[26];
        boolean mark = false;
    }
}
