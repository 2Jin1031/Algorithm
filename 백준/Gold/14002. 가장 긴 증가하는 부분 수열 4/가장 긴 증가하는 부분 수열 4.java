import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N];
        int[] prev = new int[N];

        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);  // 전체 prev 배열을 -1로 초기화

        int maxIdx = 0;
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
            if (dp[maxIdx] < dp[i]) {
                maxIdx = i;
            }
        }

        bw.write(dp[maxIdx] + "\n");
        Stack<Integer> stack = new Stack<>();
        int idx = maxIdx;
        while (idx != -1) {
            stack.push(arr[idx]);
            idx = prev[idx];
        }
        while (!stack.isEmpty()) {
            bw.write(stack.pop() + " ");
        }

        bw.close();
        br.close();
    }
}