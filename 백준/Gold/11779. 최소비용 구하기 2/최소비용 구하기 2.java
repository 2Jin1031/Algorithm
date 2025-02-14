import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    private static final int INF = 200000000;
    private static ArrayList<int[]>[] graph;

    private static int endNode;

    private static int[] prev;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int E = Integer.parseInt(br.readLine());

        graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new int[]{b, c});
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int startNode = Integer.parseInt(st.nextToken());
        endNode = Integer.parseInt(st.nextToken());

        int dist = dijkstra(N, startNode);

        System.out.println(dist);

        Stack<Integer> stack = new Stack<>();
        stack.push(endNode);
        while (prev[endNode] != -1) {
            stack.push(prev[endNode]);
            endNode = prev[endNode];
        }

        System.out.println(stack.size());

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    private static int dijkstra(int N, int start) {
        prev = new int[N + 1];
        Arrays.fill(prev, -1);

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        pq.offer(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int node = current[0];
            int cost = current[1];

            if (cost > dist[node]) {
                continue;
            }

            for (int[] next : graph[node]) {
                int neighbor = next[0];
                int weight = next[1];

                if (dist[neighbor] > cost + weight) {
                    prev[neighbor] = node;
                    dist[neighbor] = cost + weight;
                    pq.offer(new int[]{neighbor, dist[neighbor]});
                }
            }
        }

        return dist[endNode];
    }
}