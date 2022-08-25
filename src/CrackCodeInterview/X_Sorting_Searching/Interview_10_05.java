package CrackCodeInterview.X_Sorting_Searching;

public class Interview_10_05 {
    /*
     * 大体上二分，通过get方法获取各个不为空的left，right和mid
     * 取mid时若定位到空，则取左右最近的非空
     * 局部会退化成线性搜索
     * */
    public int findString(String[] words, String s) {
        return binFind(words, s, getLeft(words, 0), getRight(words, words.length - 1));
    }

    private int binFind(String[] words, String tar, int left, int right) {
        while (left <= right) {
            int mid = getMid(words, left, right);
            if (mid != -1) {
                int compare = words[mid].compareTo(tar);
                if (compare == 0) {
                    return mid;
                } else if (compare > 0) {
                    right = getRight(words, mid - 1);
                } else {
                    left = getLeft(words, mid + 1);
                }
            } else {
                return -1;
            }
        }
        return -1;
    }

    private int getMid(String[] words, int left, int right) {
        int mid = (left + right) >> 1;
        if (!words[mid].equals("")) {
            return mid;
        }
        int cl = mid - 1, cr = mid + 1;
        while (cl >= left || cr <= right) {
            if (!words[cl].equals("")) {
                return cl;
            }
            if (!words[cr].equals("")) {
                return cr;
            }
            cl--;
            cr++;
        }
        return -1;
    }

    private int getRight(String[] words, int index) {
        while (index >= 0 && words[index].equals("")) {
            index--;
        }
        return index;
    }

    private int getLeft(String[] words, int index) {
        while (index < words.length && words[index].equals("")) {
            index++;
        }
        return index;
    }
}
