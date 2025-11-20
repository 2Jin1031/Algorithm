import java.io.*;
import java.util.*;

public class Main {

    private static int N, K;
    private static int[] arr;
    private static int[][] R, M;
    private static int ans = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        R = new int[K][N];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                R[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        M = new int[K][N];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                M[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        backtracking(0, 0, new int[N]);
        System.out.println(ans);
    }

    private static void backtracking(int idx, int cost, int[] count) { // idx: 날짜 (K일동안)
        if (idx == K) {
            ans = Math.max(ans, cost);
            return ;
        }

        int addCost = 0;
        // 랑이 하나 고르고
        int Rj = -1;
        // 메리 하나 고르고
        int Mj = -1;
        for (int j = 0; j < N; j++) { // N개의 캔 중 고르기
            if (Rj == -1 && arr[j] > count[j]) { // 랑이 고르는 중에 캔이 남아 있다면
                Rj = j;
                count[Rj] += 1;

                for (int jj = 0; jj < N; jj++) {
                    if (Mj == -1 && arr[jj] > count[jj]) { // 메리 고르는 중에 캔이 남아 있다면
                        Mj = jj;
                        count[Mj] += 1;
                    }
    
                    if (Rj != -1 && Mj != -1) { // 둘다 골랐다면
                        addCost = R[idx][Rj] + M[idx][Mj]; // i: 날짜, j: 캔 종류
                        backtracking(idx + 1, cost + addCost, count);
                        count[Mj]--;
                        addCost = 0;
                        Mj = -1;
                    }    
                }
                count[Rj]--;
                Rj = -1;
            }   
        }
    }
}