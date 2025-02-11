import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int N, M, R;
    private static int[] items;
    private static ArrayList<int[]>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        items = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            int nodeA = Integer.parseInt(st.nextToken());
            int nodeB = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph[nodeA].add(new int[]{nodeB, weight});
            graph[nodeB].add(new int[]{nodeA, weight});
        }

        int result = 0;
        for (int i = 1; i <= N; i++) {
            result = Math.max(result, dijkstra(i));
        }
        System.out.println(result);
    }

    private static int dijkstra(int start) {
        int[] distance = new int[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{start, 0});

        int totalItems = 0;

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentNode = current[0];
            int currentDistance = current[1];

            if (currentDistance > M) continue;

            if (distance[currentNode] == currentDistance) {
                totalItems += items[currentNode];
            }

            for (int[] neighbor : graph[currentNode]) {
                int nextNode = neighbor[0];
                int weight = neighbor[1];
                int nextDistance = currentDistance + weight;

                if (nextDistance < distance[nextNode]) {
                    distance[nextNode] = nextDistance;
                    pq.offer(new int[]{nextNode, nextDistance});
                }
            }
        }
        return totalItems;
    }
}