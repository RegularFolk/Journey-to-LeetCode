import org.junit.Test;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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

}
