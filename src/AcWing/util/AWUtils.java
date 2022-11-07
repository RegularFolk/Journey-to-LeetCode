package AcWing.util;

import java.io.*;
import java.util.*;

public class AWUtils {

    static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

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
            throw new RuntimeException("����ʧ�ܣ�");
        }

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
            throw new RuntimeException("����ʧ�ܣ�");
        }

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
            throw new RuntimeException("����ʧ�ܣ�");
        }

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
            throw new RuntimeException("����ʧ�ܣ�");
        }
    }

    /**
     * һ������һ��String
     *
     * @return �����String
     */
    public static String stringInput() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("�ַ�������ʧ�ܣ�");
        }
    }

    /**
     * һ����������int
     *
     * @return �����int������
     */
    public static int[] intsInput() {
        int[] arr;
        String[] strs;
        try {
            strs = reader.readLine().split(" ");
            arr = new int[strs.length];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(strs[i]);
            }
            return arr;
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("����ʧ�ܣ�");
        }

    }

    /**
     * һ����������int���������
     *
     * @param n ����
     * @return �����int��ά����
     */
    public static int[][] intsArrayInput(int n) {
        int[][] arrs = new int[n][];
        for (int i = 0; i < n; i++) {
            arrs[i] = intsInput();
        }
        return arrs;
    }

    /**
     * �ֶ���������int��ÿ��һ��int
     *
     * @param n һ���м���
     * @return �����int����
     */
    public static int[] intsInputByLine(int n) {
        int[] arr;
        try {
            arr = new int[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(reader.readLine());
            }
            return arr;
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("����ʧ�ܣ�");
        }
    }

    /**
     * һ��������һ��int����
     *
     * @param len ����ĳ���
     * @return ���������
     */
    public static int[] intArrayInput(int len) {
        try {
            int[] arr = new int[len];
            String[] strs;
            strs = reader.readLine().split(" ");
            for (int i = 0; i < len; i++) {
                arr[i] = Integer.parseInt(strs[i]);
            }
            return arr;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("����ʧ�ܣ�");
        }
    }

    /**
     * һ��������һ��long����
     *
     * @param len ����ĳ���
     * @return ���������
     */
    public static long[] longArrayInput(int len) {
        try {
            long[] arr = new long[len];
            String[] strs;
            strs = reader.readLine().split(" ");
            for (int i = 0; i < len; i++) {
                arr[i] = Integer.parseInt(strs[i]);
            }
            return arr;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("����ʧ�ܣ�");
        }
    }

    /**
     * ��������String����
     *
     * @param len ���鳤��
     * @return �����String����
     */
    public static String[] stringArrayInput(int len) {
        try {
            String[] input = new String[len];
            for (int i = 0; i < input.length; i++) {
                input[i] = reader.readLine();
            }
            return input;
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }


    /**
     * һ�������int����
     *
     * @param ints Ҫ���������
     */
    public static void printArrayInline(int[] ints) {
        try {
            if (ints != null) {
                for (int anInt : ints) {
                    writer.write(anInt + " ");
                    writer.flush();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * �������int����
     *
     * @param ints ��Ҫ�����int����
     */
    public static void printArrayByLine(int[] ints) {
        try {
            if (ints != null) {
                for (int anInt : ints) {
                    writer.write(anInt + "\n");
                }
                writer.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * һ�������char����
     *
     * @param chars Ҫ���������
     */
    public static void printArrayInline(char[] chars) {
        try {
            if (chars != null) {
                for (char c : chars) {
                    writer.write(c + " ");
                }
                writer.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * һ���������long����
     *
     * @param longs Ҫ���������
     */
    public static void printArrayInline(long[] longs) {
        try {
            if (longs != null) {
                for (long l : longs) {
                    writer.write(l + " ");
                }
                writer.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * һ�������String����
     *
     * @param strings Ҫ���������
     */
    public static void printArrayInline(String[] strings) {
        try {
            if (strings != null) {
                for (String s : strings) {
                    writer.write(s + " ");
                }
                writer.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * ��String�����������
     *
     * @param strings Ҫ���������
     */
    public static void printArrayByLine(String[] strings) {
        try {
            if (strings != null) {
                for (String s : strings) {
                    writer.write(s);
                    writer.newLine();
                }
                writer.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
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
     * һ���ڴ�ӡlist
     *
     * @param list ��Ҫ��ӡ��list
     */
    public static void printListInLint(List<?> list) {
        try {
            for (Object o : list) {
                writer.write(o + " ");
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * ���д�ӡlist
     *
     * @param list ��Ҫ��ӡ��list
     */
    public static void printListByLine(List<?> list) {
        try {
            for (Object o : list) {
                writer.write(o + "\n");
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
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
