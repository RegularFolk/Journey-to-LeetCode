package AcWing.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AWUtils {

    static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    /**
     * һ��һ��int
     *
     * @return �����int
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
     * һ��һ��long
     *
     * @return �����long
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
     * һ��һ��float
     *
     * @return �����float
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
     * һ��һ��double
     *
     * @return �����double
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
     * һ����������int
     *
     * @return �����int������
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
     * �ֶ���������int��ÿ��һ��int
     *
     * @param n һ���м���
     * @return �����int����
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
     * һ��������һ��int����
     *
     * @param len ����ĳ���
     * @return ���������
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
     * һ��������һ��long����
     *
     * @param len ����ĳ���
     * @return ���������
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
     * һ�������int����
     *
     * @param ints Ҫ���������
     */
    public static void printArrayInline(int[] ints) {
        if (ints != null) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
        }
    }

    /**
     * һ�������char����
     *
     * @param chars Ҫ���������
     */
    public static void printArrayInline(char[] chars) {
        if (chars != null) {
            for (char c : chars) {
                System.out.print(c + " ");
            }
        }
    }

    /**
     * һ���������long����
     *
     * @param longs Ҫ���������
     */
    public static void printArrayInline(long[] longs) {
        if (longs != null) {
            for (long l : longs) {
                System.out.print(l + " ");
            }
        }
    }

    /**
     * һ�������String����
     *
     * @param strings Ҫ���������
     */
    public static void printArrayInline(String[] strings) {
        if (strings != null) {
            for (String s : strings) {
                System.out.print(s + " ");
            }
        }
    }

    /**
     * ��String�����������
     *
     * @param strings Ҫ���������
     */
    public static void printArrayLineByLine(String[] strings) {
        if (strings != null) {
            for (String s : strings) {
                System.out.println(s + " ");
            }
        }
    }

    /**
     * ��ӡint��ά���飬һ��һ��������
     *
     * @param arr ��Ҫ��ӡ��int��ά����
     */
    public static void printDoubleArray(int[][] arr) {
        for (int[] ints : arr) {
            printArrayInline(ints);
            System.out.println();
        }
    }

    /**
     * ����int�����е�����Ԫ��
     *
     * @param arr ����������
     * @param a   һ���±�
     * @param b   ��һ���±�
     */
    public static void swapArray(int[] arr, int a, int b) {
        if (a != b) {
            int temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
        }
    }

    /**
     * ����long�����е�����Ԫ��
     *
     * @param arr ����������
     * @param a   һ���±�
     * @param b   ��һ���±�
     */
    public static void swapArray(long[] arr, int a, int b) {
        if (a != b) {
            long temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
        }
    }

    /**
     * ����float�����е�����Ԫ��
     *
     * @param arr ����������
     * @param a   һ���±�
     * @param b   ��һ���±�
     */
    public static void swapArray(float[] arr, int a, int b) {
        if (a != b) {
            float temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
        }
    }

    /**
     * ����double�����е�����Ԫ��
     *
     * @param arr ����������
     * @param a   һ���±�
     * @param b   ��һ���±�
     */
    public static void swapArray(double[] arr, int a, int b) {
        if (a != b) {
            double temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
        }
    }

    /**
     * ����String�����е�����Ԫ��
     *
     * @param arr ����������
     * @param a   һ���±�
     * @param b   ��һ���±�
     */
    public static void swapArray(String[] arr, int a, int b) {
        if (a != b) {
            String temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
        }
    }

    /**
     * ����Object�����е�����Ԫ��
     *
     * @param arr ����������
     * @param a   һ���±�
     * @param b   ��һ���±�
     */
    public static void swapArray(Object[] arr, int a, int b) {
        if (a != b) {
            Object temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
        }
    }

}
