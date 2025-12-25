import java.io.*;
import java.util.*;

public class Main {

    private static int minAns = Integer.MAX_VALUE;
    private static int maxAns = Integer.MIN_VALUE;

    private static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());   
        }

        int[] counts = new int[4];
        int countSize = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            counts[i] = Integer.parseInt(st.nextToken());
            countSize += counts[i];
        }

        backtracking(counts, new int[countSize], 0);
        System.out.println(maxAns);
        System.out.println(minAns);
    }

    private static void backtracking(int[] counts, int[] calculator, int idx) {
        if (idx >= arr.length - 1) {
            int ans = calculate(calculator);
            minAns = Math.min(minAns, ans);
            maxAns = Math.max(maxAns, ans);
            return ;
        }
        
        for (int i = 0; i < 4; i++) {
            if (counts[i] > 0) {
                calculator[idx] = i;
                counts[i]--;
                backtracking(counts, calculator, idx + 1);
                counts[i]++;
            }
        }
    }

    private static int calculate(int[] calculator) {
        int ans = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == 0) {
                break;
            }
            
            if (calculator[i - 1] == 0) {
                ans += arr[i];
            } else if (calculator[i - 1] == 1) {
                ans -= arr[i];
            } else if (calculator[i - 1] == 2) {
                ans *= arr[i];
            } else { // (calculator[i - 1] == '%')
                ans /= arr[i];
            }
        }

        return ans;
    }
}