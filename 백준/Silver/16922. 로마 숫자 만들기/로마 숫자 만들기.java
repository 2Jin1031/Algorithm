import java.io.*;
import java.util.*;

public class Main {

    private static int[][] arr = new int[9][9];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        int N = Integer.parseInt(br.readLine());
        boolean[] possible = new boolean[1001];

        for (int a = 0; a <= N; a++) {
            for (int b = 0; a + b <= N; b++) {
                for (int c = 0; a + b + c <= N; c++) {
                    int d = N - (a + b + c);
                    int sum = a * 1 + b * 5 + c * 10 + d * 50;
                    possible[sum] = true;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < possible.length; i++) {
            if (possible[i]) {
                count++;
            }
        }
    
        System.out.println(count);
     }
}