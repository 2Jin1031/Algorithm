import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        HashMap<Long, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0L, 1);

        long currentSum = 0;
        long count = 0;

        for (int num : nums) {
            currentSum += num;

            count += prefixSumCount.getOrDefault(currentSum - K, 0);

            prefixSumCount.put(currentSum, prefixSumCount.getOrDefault(currentSum, 0) + 1);
        }

        System.out.println(count);
        br.close();
    }
}