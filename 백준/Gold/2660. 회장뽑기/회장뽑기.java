import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Main {
    static final int INF = 1_000_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] dist = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) dist[i][j] = 0;
                else dist[i][j] = INF;
            }
        }

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a == -1 && b == -1) break;
            dist[a][b] = 1;
            dist[b][a] = 1;
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                if (dist[i][k] == INF) continue;
                for (int j = 1; j <= N; j++) {
                    if (dist[k][j] == INF) continue;
                    int nd = dist[i][k] + dist[k][j];
                    if (nd < dist[i][j]) dist[i][j] = nd;
                }
            }
        }

        int[] score = new int[N + 1];
        int best = INF;

        for (int i = 1; i <= N; i++) {
            int mx = 0;
            for (int j = 1; j <= N; j++) {
                mx = Math.max(mx, dist[i][j]);
            }
            score[i] = mx;
            best = Math.min(best, mx);
        }

        List<Integer> cand = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (score[i] == best) cand.add(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(best).append(' ').append(cand.size()).append('\n');
        for (int x : cand) {
            sb.append(x).append(' ');
        }
        System.out.print(sb.toString());
    }
}