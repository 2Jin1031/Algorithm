import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());

        Set<Integer> set;
        boolean[] arr;
        for (int i = 0; i < N; i++) {
            arr = new boolean[10];
            set = new HashSet<>();
            
            int input = Integer.parseInt(br.readLine());

            int num;
            for (int j = 1; ; j++) {
                num = input * j;
                if (set.contains(num)) {
                    System.out.println(String.format("Case #%d: INSOMNIA", i + 1));
                    break;
                }
                set.add(num);
                int localAns = digitFunc(num, arr);
                if (localAns >= 10) {
                    System.out.println(String.format("Case #%d: %d", i + 1, num));
                    break;
                }
            }
        }
    }

    private static int digitFunc(int num, boolean[] arr) {
        while (num > 0) {
            int digit = num % 10;
            arr[digit] = true;
            num /= 10;
        }

        int count = 0;
        for (int i = 0; i < 10; i++) {
            if (arr[i]) {
                count++;
            }
        }
        return count;
    }
}