import java.util.*;

class Solution {
    public int solution(int k, int[][] dungeons) {
        // (최소 필요 - 소모)가 큰 순서로 정렬
        Arrays.sort(dungeons, (a, b) -> (b[0] - b[1]) - (a[0] - a[1]));

        // dp[j] = 남은 피로도가 j일 때 최대 던전 수 (-1은 도달 불가)
        int[] dp = new int[k + 1];
        Arrays.fill(dp, -1);
        dp[k] = 0;

        for (int[] d : dungeons) {
            int need = d[0];
            int cost = d[1];

            // j가 작은 쪽부터: 쓰는 칸(j - cost)이 이미 지나온 칸이라 같은 던전 두 번 안 씀
            for (int j = need; j < k + 1; j++) {
                if (dp[j] < 0) {
                    continue;
                }

                dp[j - cost] = Math.max(dp[j - cost], dp[j] + 1);
            }
        }

        int answer = 0;
        for (int j = 0; j < k + 1; j++) {
            answer = Math.max(answer, dp[j]);
        }
        return answer;
    }
}