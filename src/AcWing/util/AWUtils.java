package AcWing.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AWUtils {

    static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    /**
     * 一行一个int
     *
     * @return 输入的int
     */
    public static int intInput() {
        try {
            return Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }

    /**
     * 一行一个long
     *
     * @return 输入的long
     */
    public static long longInput() {
        try {
            return Long.parseLong(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }

    /**
     * 一行一个float
     *
     * @return 输入的float
     */
    public static float floatInput() {
        try {
            return Float.parseFloat(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }

    /**
     * 一行一个double
     *
     * @return 输入的double
     */
    public static double doubleInput() {
        try {
            return Double.parseDouble(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }

    /**
     * 一行内输入多个int
     *
     * @return 输入的int的数组
     */
    public static int[] intsInput() {
        int[] arr = null;
        String[] strs;
        try {
            strs = reader.readLine().split(" ");
            arr = new int[strs.length];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(strs[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arr;
    }

    /**
     * 分多行输入多个int，每行一个int
     *
     * @param n 一共有几行
     * @return 输入的int数组
     */
    public static int[] intsInputLineByLine(int n) {
        int[] arr = null;
        try {
            arr = new int[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(reader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arr;
    }

    /**
     * 一行内输入一个int数组
     *
     * @param len 输入的长度
     * @return 输入的数组
     */
    public static int[] intArrayInput(int len) {
        int[] arr = new int[len];
        if (len > 0) {
            String[] strs = new String[0];
            try {
                strs = reader.readLine().split(" ");
            } catch (IOException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < len; i++) {
                arr[i] = Integer.parseInt(strs[i]);
            }
        }
        return arr;
    }

    /**
     * 一行内输入一个long数组
     *
     * @param len 输入的长度
     * @return 输入的数组
     */
    public static long[] longArrayInput(int len) {
        long[] arr = new long[len];
        if (len > 0) {
            String[] strs = new String[0];
            try {
                strs = reader.readLine().split(" ");
            } catch (IOException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < len; i++) {
                arr[i] = Integer.parseInt(strs[i]);
            }
        }
        return arr;
    }

    /**
     * 一行内输出int数组
     *
     * @param ints 要输出的数组
     */
    public static void printArrayInline(int[] ints) {
        if (ints != null) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
        }
    }

    /**
     * 一行内输出char数组
     *
     * @param chars 要输出的数组
     */
    public static void printArrayInline(char[] chars) {
        if (chars != null) {
            for (char c : chars) {
                System.out.print(c + " ");
            }
        }
    }

    /**
     * 一行内输出的long数组
     *
     * @param longs 要输出的数组
     */
    public static void printArrayInline(long[] longs) {
        if (longs != null) {
            for (long l : longs) {
                System.out.print(l + " ");
            }
        }
    }

    /**
     * 一行内输出String数组
     *
     * @param strings 要输出的数组
     */
    public static void printArrayInline(String[] strings) {
        if (strings != null) {
            for (String s : strings) {
                System.out.print(s + " ");
            }
        }
    }

    /**
     * 将String数组逐行输出
     *
     * @param strings 要输出的数组
     */
    public static void printArrayLineByLine(String[] strings) {
        if (strings != null) {
            for (String s : strings) {
                System.out.println(s + " ");
            }
        }
    }

    /**
     * 打印int二维数组，一行一个子数组
     *
     * @param arr 需要打印的int二维数组
     */
    public static void printDoubleArray(int[][] arr) {
        for (int[] ints : arr) {
            printArrayInline(ints);
            System.out.println();
        }
    }

    /**
     * 交换int数组中的两个元素
     *
     * @param arr 交换的数组
     * @param a   一个下标
     * @param b   另一个下标
     */
    public static void swapArray(int[] arr, int a, int b) {
        if (a != b) {
            int temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
        }
    }

    /**
     * 交换long数组中的两个元素
     *
     * @param arr 交换的数组
     * @param a   一个下标
     * @param b   另一个下标
     */
    public static void swapArray(long[] arr, int a, int b) {
        if (a != b) {
            long temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
        }
    }

    /**
     * 交换float数组中的两个元素
     *
     * @param arr 交换的数组
     * @param a   一个下标
     * @param b   另一个下标
     */
    public static void swapArray(float[] arr, int a, int b) {
        if (a != b) {
            float temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
        }
    }

    /**
     * 交换double数组中的两个元素
     *
     * @param arr 交换的数组
     * @param a   一个下标
     * @param b   另一个下标
     */
    public static void swapArray(double[] arr, int a, int b) {
        if (a != b) {
            double temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
        }
    }

    /**
     * 交换String数组中的两个元素
     *
     * @param arr 交换的数组
     * @param a   一个下标
     * @param b   另一个下标
     */
    public static void swapArray(String[] arr, int a, int b) {
        if (a != b) {
            String temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
        }
    }

    /**
     * 交换Object数组中的两个元素
     *
     * @param arr 交换的数组
     * @param a   一个下标
     * @param b   另一个下标
     */
    public static void swapArray(Object[] arr, int a, int b) {
        if (a != b) {
            Object temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
        }
    }

}
