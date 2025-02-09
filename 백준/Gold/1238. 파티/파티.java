import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static final int INF = 2000000;

    private static int N, M, X;
    private static ArrayList<int[]>[] graph;
    private static ArrayList<int[]>[] reverseGraph; // 역방향 그래프 추가

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        reverseGraph = new ArrayList[N + 1]; // 역방향 그래프 초기화

        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
            reverseGraph[i] = new ArrayList<>();
        }

        // 그래프 및 역방향 그래프 구성
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int startNode = Integer.parseInt(st.nextToken());
            int endNode = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[startNode].add(new int[]{endNode, weight});
            reverseGraph[endNode].add(new int[]{startNode, weight}); // 역방향 간선 추가
        }

        int[] distFromX = dijkstra(graph, X);        // X → 다른 노드로 가는 최단 거리
        int[] distToX = dijkstra(reverseGraph, X);   // 다른 노드 → X로 가는 최단 거리 (역방향 그래프 사용)

        int maxTime = 0;
        for (int i = 1; i <= N; i++) {
            maxTime = Math.max(maxTime, distFromX[i] + distToX[i]);
        }

        System.out.println(maxTime);
    }

    private static int[] dijkstra(ArrayList<int[]>[] g, int start) {
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

            for (int[] next : g[node]) {
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