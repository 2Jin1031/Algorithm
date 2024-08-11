import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Character> stack = new Stack<>();

        String str;
        int cnt = 0;
        for (int k = 0; k < N; k++) {

            str = br.readLine();
            stack.clear();
            for (int i = 0; i < str.length(); i++) {

                if (stack.isEmpty()) {
                    stack.push(str.charAt(i));
                }
                else {
                    if (stack.peek() == str.charAt(i)) {
                        stack.pop();
                    }
                    else {
                        stack.push(str.charAt(i));
                    }
                }
            }

            if (stack.isEmpty()) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
