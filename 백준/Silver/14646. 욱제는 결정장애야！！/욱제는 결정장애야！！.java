import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());

        boolean[] board = new boolean[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        int count = 0;
        int ans = 0;
        for (int i = 0; i < N * 2; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (board[num]) {
                count--;
            } else {
                count++;
                board[num] = true;
                ans = Math.max(ans, count);
            }
        }

        System.out.println(ans);
    }
}