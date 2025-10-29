import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        LinkedList<Integer> arr = new LinkedList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr.add(num);
        }

        int ans = backtracking(arr, 0);
        System.out.println(ans);
    }

    private static int backtracking(LinkedList<Integer> arr, int sum) {
        if (arr.size() == 2) {
            return sum;
        }

        int maxSum = 0;
        for (int i = 1; i < arr.size() - 1; i++) { // 양 끝을 제외한 인덱스
            Integer num = arr.get(i);
            arr.remove(i);
            int localSum = backtracking(arr, sum + arr.get(i - 1) * arr.get(i));
            arr.add(i, num);
            maxSum = Math.max(maxSum, localSum);
        }
        return maxSum;
    }
}