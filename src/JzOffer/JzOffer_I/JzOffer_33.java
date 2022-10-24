package JzOffer.JzOffer_I;

public class JzOffer_33 {
    public boolean verifyPostorder(int[] postorder) {
        return postorder == null || postorder.length == 0 || check(postorder, postorder.length - 1, 0);
    }

    private boolean check(int[] postorder, int last, int head) {
        if (last <= head) {
            return true;
        }
        int mark = -1;
        boolean left = false, right = true;
        if (postorder[last - 1] < postorder[last]) { //右子树
            mark = last - 1;
            right = false;
            left = true;
        }
        for (int i = last - 1; i >= head; i--) { //左子树
            if (!left && postorder[i] < postorder[last]) {
                mark = i;
                left = true;
            }
            if (left && postorder[i] > postorder[last]) {
                return false;
            }
        }
        if (left && right) {
            return check(postorder, mark, head) && check(postorder, last - 1, mark + 1);
        } else if (left) {
            return check(postorder, mark, head);
        } else {
            return check(postorder, last - 1, head);
        }
    }
}
