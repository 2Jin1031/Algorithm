import java.io.*;
import java.util.*;

public class Main {
    private static int V, E, K;
    private static ArrayList<ArrayList<int[]>> map;
    private static int[] distances;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        initialize(br);

        bfs(K);

        for (int i = 1; i < V + 1; i++) {
            if (distances[i] == Integer.MAX_VALUE) {
                bw.write("INF\n");
            } else {
                bw.write(distances[i] + "\n");
            }
        }
        br.close();
        bw.close();
    }

    private static void initialize(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        K = Integer.parseInt(br.readLine());

        map = new ArrayList<>();
        distances = new int[V + 1];

        for (int i = 0; i < V + 1; i++) {
            map.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            map.get(u).add(new int[]{v, w});
        }

        Arrays.fill(distances, Integer.MAX_VALUE);

    }

    private static void bfs(int start) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        queue.offer(new int[]{start, 0});
        distances[start] = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentNode = current[0];
            int currentDist = current[1];

            if (distances[currentNode] < currentDist) {
                continue;
            }

            for (int i = 0; i < map.get(currentNode).size(); i++) {
                int nextNode = map.get(currentNode).get(i)[0];
                int nextDist = currentDist + map.get(currentNode).get(i)[1];
                if (nextDist < distances[nextNode]) {
                    queue.offer(new int[]{nextNode, nextDist});
                    distances[nextNode] = nextDist;
                }
            }
        }
    }
}