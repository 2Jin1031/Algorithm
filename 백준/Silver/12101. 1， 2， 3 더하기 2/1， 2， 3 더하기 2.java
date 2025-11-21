import java.io.*;
import java.util.*;

public class Main {

    private static int N, K;

    private static int count = 0;
    private static String ans = "";

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        backtracking(0, "");

        if (count < K) {
            System.out.println("-1");
        } else {
            System.out.println(ans.substring(1));
        }
    }

    private static void backtracking(int sum, String result) { 
        if (sum > N) {
            return ;
        } else if (sum == N) {
            count++;
            if (count == K) {
                ans = result;
            }
            return ;
        }

        for (int i = 1; i < 4; i++) {
            backtracking(sum + i, result + "+" + i);
        }
    }
}