import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int leftWeight = 0;
        int rightWeight = 0;
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (leftWeight <= rightWeight) {
                leftWeight += num;
            } else {
                rightWeight += num;
            }
        }

        int[] counterWeights = new int[]{1, 2, 5, 10, 20, 50, 100};

        int diff = Math.max(leftWeight, rightWeight) - Math.min(leftWeight, rightWeight);
        int ans = 0;
        for (int i = counterWeights.length - 1; i >= 0; i--) {
            int counterWeight = counterWeights[i];
            if (diff >= counterWeight) {
                int count = diff / counterWeight;
                diff -= count * counterWeight;
                ans += count;
            }
        }
        System.out.println(ans);
    }
}
