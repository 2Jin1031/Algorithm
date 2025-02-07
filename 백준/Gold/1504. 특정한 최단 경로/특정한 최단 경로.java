import java.io.*;
import java.util.*;

public class Main {

    private static final int INF = 200000000;
    private static ArrayList<int[]>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new int[]{b, c});
            graph[b].add(new int[]{a, c});
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int[] distFrom1 = dijkstra(N, 1);
        int[] distFromV1 = dijkstra(N, v1);
        int[] distFromV2 = dijkstra(N, v2);

        long path1 = (long) distFrom1[v1] + distFromV1[v2] + distFromV2[N];
        long path2 = (long) distFrom1[v2] + distFromV2[v1] + distFromV1[N];

        long result = Math.min(path1, path2);

        System.out.println(result >= INF ? -1 : result);
    }

    private static int[] dijkstra(int N, int start) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        pq.offer(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int node = current[0];
            int cost = current[1];

            if (cost > dist[node]) continue;

            for (int[] next : graph[node]) {
                int neighbor = next[0];
                int weight = next[1];

                if (dist[neighbor] > cost + weight) {
                    dist[neighbor] = cost + weight;
                    pq.offer(new int[]{neighbor, dist[neighbor]});
                }
            }
        }
        return dist;
    }
}