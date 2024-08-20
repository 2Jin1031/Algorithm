import java.io.*;
import java.util.*;

public class Main {
    private static int N, M;
    private static ArrayList<ArrayList<int[]>> map;
    private static int[][] cost;

    private static final int D_SIZE = 4;
    private static final int[] DX = {-1, 1, 0, 0};
    private static final int[] DY = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        initialize(br);

        for (int i = 1; i < N + 1; i++) {
            bfs(i);
        }

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                if (i == j) {
                    bw.write("0 ");
                } else {
                    bw.write(cost[i][j] + " ");
                }
            }
            bw.write("\n");
        }

        br.close();
        bw.close();
    }

    private static void initialize(BufferedReader br) throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        map = new ArrayList<>();
        cost = new int[N + 1][N + 1];

        for (int i = 0; i < N + 1; i++) {
            map.add(new ArrayList<>());
        }

        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map.get(a).add(new int[]{b, c});
        }
    }

    private static void bfs(int start) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        queue.offer(new int[]{start, 0});
        cost[start][start] = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentIdx = current[0];
            int currentCost = current[1];

            for (int[] next : map.get(currentIdx)) {
                int nextIdx = next[0];
                int nextCost = next[1];

                if (cost[start][nextIdx] == 0 || cost[start][nextIdx] > currentCost + nextCost) {
                    cost[start][nextIdx] = currentCost + nextCost;
                    queue.offer(new int[]{nextIdx, cost[start][nextIdx]});
                }
            }
        }
    }
}

