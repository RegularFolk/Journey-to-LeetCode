package CrackCodeInterview;

public class Interview_01_09 {
    public boolean isFlipedString(String s1, String s2) {  //将s2变两倍，会包含s1，或者s1和s2排序后逐一比较
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }
        s2 = s2 + s2;
        return s2.contains(s1);
    }
}
