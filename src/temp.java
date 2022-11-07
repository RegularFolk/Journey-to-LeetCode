import org.junit.Test;

import java.io.*;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.*;
import java.util.concurrent.*;

public class temp {

    @Test
    public void write() {
        try {
            FileOutputStream fos = new FileOutputStream("test.txt");
            fos.write("Hello IO,123456789".getBytes());
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void read() {
        try {
            FileInputStream fis = new FileInputStream("test.txt");
            int available = fis.available();
            System.out.println("available = " + available);
            int read;
            while ((read = fis.read()) != -1) {
                System.out.println("read = " + (char) read);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void fileReader() {
        try {
            FileReader fileReader = new FileReader("test.txt");
            int read;
            String encoding = fileReader.getEncoding();
            System.out.println("encoding = " + encoding);
            while ((read = fileReader.read()) != -1) {
                System.out.println("(char)read = " + (char) read);
            }
            fileReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void reader() {
        try {
            Reader reader = new FileReader("test.txt");
            int i;
            while ((i = reader.read()) != -1) {
                System.out.println("i = " + (char) i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void bufferedRead() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("test.txt"));
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("test.txt")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void referenceQueue() {
        int _1M = 1024 * 1024;
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        Thread thread = new Thread(() -> {
            try {
                int cnt = 0;
                WeakReference<byte[]> k;
                while ((k = (WeakReference) referenceQueue.remove()) != null) {//referenceQueue的阻塞是自旋阻塞
                    System.out.println((cnt++) + "回收了:" + k);//每当一个对象被回收，其对应的引用就会进入referenceQueue，这一步将进入队列的取出引用取出
                }
            } catch (InterruptedException e) {
                // 结束循环
            }
        });
        thread.setDaemon(true);
        thread.start();

        Object value = new Object();
        Map<Object, Object> map = new HashMap<>();
        for (int i = 0; i < 10000; i++) {
            byte[] bytes = new byte[_1M];
            WeakReference<byte[]> weakReference = new WeakReference<byte[]>(bytes, referenceQueue);
            map.put(weakReference, value);
        }
        System.out.println("map.size->" + map.size());
    }

    @Test
    public void threadPoll() {
        ArrayBlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(10);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 20, 5000, TimeUnit.SECONDS, workQueue, new ThreadPoolExecutor.AbortPolicy());
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
    }

}
