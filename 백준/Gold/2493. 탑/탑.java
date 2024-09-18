import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        int[] result = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        Stack<Integer> stack = new Stack<>();

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                result[i] = stack.peek();
            } else {
                result[i] = 0;
            }

            stack.push(i);
        }

        for (int i = 1; i <= N; i++) {
            bw.write(result[i] + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}