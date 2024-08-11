import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Character> stack = new Stack<>();
        int count = 0;
        
        for (int k = 0; k < N; k++) {
            String inputString = br.readLine();
            stack.clear();
            
            for (char ch : inputString.toCharArray()) {
                if (!stack.isEmpty() && stack.peek() == ch) {
                    stack.pop();
                }
                else {
                    stack.push(ch);
                }
            }

            if (stack.isEmpty()) {
                count++;
            }
        }

        System.out.println(count);
    }
}
