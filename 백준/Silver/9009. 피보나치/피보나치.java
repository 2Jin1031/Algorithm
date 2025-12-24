import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int num = Integer.parseInt(br.readLine());
            List<Integer> result = zeckendorf(num);
            for (int i = 0; i < result.size(); i++) {
                if (i > 0) System.out.print(" ");
                System.out.print(result.get(i));
            }
            System.out.println();
        }
    }
    
    private static List<Integer> zeckendorf(int num) {

        List<Integer> fib = new ArrayList<>();
        fib.add(1);
        fib.add(2);
        while (fib.get(fib.size() - 1) < num) {
            int next = fib.get(fib.size() - 1) + fib.get(fib.size() - 2);
            fib.add(next);
        }
    
        List<Integer> result = new ArrayList<>();
        for (int i = fib.size() - 1; i >= 0; i--) {
            if (fib.get(i) <= num) {
                result.add(fib.get(i));
                num -= fib.get(i);
            }
        }
        Collections.reverse(result);
        return result;
    }
}