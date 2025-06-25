import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Stack<Double> stack = new Stack<>();

        double result = 0.0;
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                int arrIdx = ch - 'A';
                stack.push(arr[arrIdx] + 0.0);
            } else {
                double num1 = stack.pop();
                double num2 = stack.pop();

                double ans = 0.0;
                switch (ch) {
                    case('*') -> ans = num2 * num1;
                    case('+') -> ans = num2 + num1;
                    case('/') -> ans = num2 / (num1 + 0.0);
                    case('-') -> ans = num2 - num1;
                }
                stack.push(ans);
                result = ans;
            }
        }
        System.out.println(String.format("%.2f", result));
     }
}