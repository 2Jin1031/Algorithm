import java.io.*;
import java.util.*;

public class Main {
    private static int N, M;
    private static ArrayList<ArrayList<int[]>> map;
    private static int[] cost;

    private static int startCity;
    private static int endCity;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        initialize(br);

        bfs(startCity);

        bw.write(cost[endCity] + "\n");

        br.close();
        bw.close();
    }

    private static void initialize(BufferedReader br) throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        map = new ArrayList<>();
        cost = new int[N + 1];
        Arrays.fill(cost, Integer.MAX_VALUE);  

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

        st = new StringTokenizer(br.readLine());
        startCity = Integer.parseInt(st.nextToken());
        endCity = Integer.parseInt(st.nextToken());
    }

    private static void bfs(int start) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        queue.offer(new int[]{start, 0});
        cost[start] = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentIdx = current[0];
            int currentCost = current[1];

            if (currentCost > cost[currentIdx]) continue;

            for (int[] next : map.get(currentIdx)) {
                int nextIdx = next[0];
                int nextCost = next[1];

                if (cost[nextIdx] > currentCost + nextCost) {
                    cost[nextIdx] = currentCost + nextCost;
                    queue.offer(new int[]{nextIdx, cost[nextIdx]});
                }
            }
        }
    }
}