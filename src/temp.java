import java.util.*;

public class temp {

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        double a = sc.nextInt();
//        double b = sc.nextInt();
//        int l = sc.nextInt();
//        int a1 = 0, b1 = 0;
//        double sub = Integer.MAX_VALUE;
//        double comp = a / b;
//
//        for (int i = 1; i < l; i++) {
//            for (int j = 1; j < l; j++) {
//                double div = (double) i / (double) j;
//                if (div >= comp && ((div - comp) <= sub)) {
//                    a1 = i;
//                    b1 = j;
//                    sub = (div - comp);
//                }
//            }
//        }
//
//        System.out.println(a1 + " " + b1);
//    }


//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        List<Integer> arr1 = new ArrayList<>();
//        List<Integer> arr2 = new ArrayList<>();
//        String line = sc.nextLine();
//        String[] split = line.split("[ ]");
//        for (String s : split) {
//            arr1.add(Integer.valueOf(s));
//        }
//
//        line = sc.nextLine();
//        split = line.split("[ ]");
//        for (String s : split) {
//            arr2.add(Integer.valueOf(s));
//        }
//
//        arr1.addAll(arr2);
//        Collections.sort(arr1);
//
//        for (Integer i : arr1) {
//            System.out.println(i);
//        }
//
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt(), m = sc.nextInt(), cnt = 0;
//        for (int i = 1; i < n; i++) {
//            for (int j = 1; j < m; j++) {
//                if ((i + j) % 5 == 0) {
//                    cnt++;
//                }
//            }
//        }
//        System.out.println(cnt);
//    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int ans = 0, l = 0;
        int[] lights = new int[n];

        String s;

        while ((s = sc.nextLine()) != null && !s.equals("")) {
            int idx = Integer.parseInt(s);
            lights[idx] = (lights[idx] + 1) % 4;
        }

        for (int i = 0; i < 4; i++) {
            int cnt = 0;
            for (int light : lights) {
                if (light == i) {
                    cnt++;
                }
            }
            if (cnt > ans) {
                ans = cnt;
                l = i;
            }
        }

        String color = l == 0 ? "white" : l == 1 ? "red" : l == 2 ? "yellow" : "blue";

        System.out.println(color + " " + ans);
    }

}
