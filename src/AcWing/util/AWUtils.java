package AcWing.util;

import java.io.*;
import java.util.*;

public class AWUtils {

    static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

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
            throw new RuntimeException("输入失败！");
        }

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
            throw new RuntimeException("输入失败！");
        }

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
            throw new RuntimeException("输入失败！");
        }

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
            throw new RuntimeException("输入失败！");
        }
    }

    /**
     * 一行输入一个String
     *
     * @return 输入的String
     */
    public static String stringInput() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("字符串输入失败！");
        }
    }

    /**
     * 一行内输入多个int
     *
     * @return 输入的int的数组
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
            throw new RuntimeException("输入失败！");
        }

    }

    /**
     * 一行内输入多个int，输入多行
     *
     * @param n 行数
     * @return 输入的int二维数组
     */
    public static int[][] intsArrayInput(int n) {
        int[][] arrs = new int[n][];
        for (int i = 0; i < n; i++) {
            arrs[i] = intsInput();
        }
        return arrs;
    }

    /**
     * 分多行输入多个int，每行一个int
     *
     * @param n 一共有几行
     * @return 输入的int数组
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
            throw new RuntimeException("输入失败！");
        }
    }

    /**
     * 一行内输入一个int数组
     *
     * @param len 输入的长度
     * @return 输入的数组
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
            throw new RuntimeException("输入失败！");
        }
    }

    /**
     * 一行内输入一个long数组
     *
     * @param len 输入的长度
     * @return 输入的数组
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
            throw new RuntimeException("输入失败！");
        }
    }

    /**
     * 分行输入String数组
     *
     * @param len 数组长度
     * @return 输入的String数组
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
     * 一行内输出int数组
     *
     * @param ints 要输出的数组
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
     * 逐行输出int数组
     *
     * @param ints 需要输出的int数组
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
     * 一行内输出char数组
     *
     * @param chars 要输出的数组
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
     * 一行内输出的long数组
     *
     * @param longs 要输出的数组
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
     * 一行内输出String数组
     *
     * @param strings 要输出的数组
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
     * 将String数组逐行输出
     *
     * @param strings 要输出的数组
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
     * 一行内打印list
     *
     * @param list 需要打印的list
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
     * 逐行打印list
     *
     * @param list 需要打印的list
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
