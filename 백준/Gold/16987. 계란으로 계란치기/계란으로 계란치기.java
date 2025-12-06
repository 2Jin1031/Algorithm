import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static int[][] arr;
    private static int ans = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N][2];
        int[] strongs = new int[N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int strong = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            arr[i][0] = strong;
            arr[i][1] = weight;

            strongs[i] = strong;
        }

        backtracking(0, 0, strongs);
        System.out.println(ans);
    }

    private static void backtracking(int idx, int count, int[] strongs) {
        if (idx >= N) {
            ans = Math.max(ans, count);
            return;
        }
    
        if (count == N) {
            ans = count;
            return;
        }
    
        if (strongs[idx] <= 0) {
            backtracking(idx + 1, count, strongs);
            return;
        }
    
        boolean hit = false;
    
        for (int i = 0; i < N; i++) {
            if (idx == i || strongs[i] <= 0) {
                continue;
            }
    
            hit = true;
    
            int aWeight = arr[idx][1];
            int bWeight = arr[i][1];
    
            int addCount = 0;
    
            strongs[i] -= aWeight;
            if (strongs[i] <= 0) addCount++;
    
            strongs[idx] -= bWeight;
            if (strongs[idx] <= 0) addCount++;
    
            backtracking(idx + 1, count + addCount, strongs);
    
            strongs[i] += aWeight;
            strongs[idx] += bWeight;
        }
    
        if (!hit) {
            backtracking(idx + 1, count, strongs);
        }
    }
}