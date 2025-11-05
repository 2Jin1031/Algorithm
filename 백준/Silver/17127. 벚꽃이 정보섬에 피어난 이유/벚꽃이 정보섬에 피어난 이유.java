import java.io.*;
import java.util.*;

public class Main {

    private static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());

        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int ans = backtracking(0, 0, 0);

        System.out.println(ans);
    }

    private static int backtracking(int groupCount, int lastIdx, int sum) {
        if (groupCount >= 4) {
            return sum;
        } else if (lastIdx >= arr.length) {
            return -1;
        }
        
        int ans = 0;
        for (int endIdx = lastIdx; endIdx < arr.length; endIdx++) {
            int score = groupScore(lastIdx, endIdx);
            int groupSum = backtracking(groupCount + 1, endIdx + 1, sum + score);
            ans = Math.max(ans, groupSum);
        }

        return ans;
    }

    private static int groupScore(int startIdx, int endIdx) { // endIdx : 포함
        int score = 1;
        for (int i = startIdx; i <= endIdx; i++) {
            score *= arr[i];
        }
        return score;
    }
        
}