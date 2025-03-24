import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int count3 = 0, count5 = 0;

        while (N >= 0) {
            if (N % 5 == 0) {
                count5 = N / 5;
                System.out.println(count5 + count3);
                return;
            }
            N -= 3;
            count3++;
        }
        System.out.println(-1);
    }
}