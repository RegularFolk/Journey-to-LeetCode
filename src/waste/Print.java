package waste;

import java.util.concurrent.CompletableFuture;

@SuppressWarnings("all")
public class Print {
    static class Mark {
        volatile int num = 1; //volatile保证线程之间的可见性
        volatile boolean flag1 = true;
        volatile boolean flag2 = false;
        volatile boolean flag3 = false;
    }

    //三个线程交替打印1~200
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Mark mark = new Mark();
        CompletableFuture<Void> thread1 = CompletableFuture.runAsync(() -> {
            while (mark.num <= 100) {
                while (!mark.flag1) ;
                System.out.println("Thread1 : " + mark.num);
                mark.num++;
                mark.flag2 = true;
                mark.flag1 = false;
            }
        });

        Mark mark1 = (Mark) Class.forName("waste.Print.Mark").newInstance();
        CompletableFuture<Void> thread2 = CompletableFuture.runAsync(() -> {
            while (mark.num <= 100) {
                while (!mark.flag2) ;
                System.out.println("Thread2 : " + mark.num);
                mark.num++;
                mark.flag3 = true;
                mark.flag2 = false;
            }
        });
        CompletableFuture<Void> thread3 = CompletableFuture.runAsync(() -> {
            while (mark.num <= 100) {
                while (!mark.flag3) ;
                System.out.println("Thread3 : " + mark.num);
                mark.num++;
                mark.flag1 = true;
                mark.flag3 = false;
            }
        });
        CompletableFuture.allOf(thread1, thread2, thread3).join();
    }
}
