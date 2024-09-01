import java.io.*;
import java.util.*;

public class Main {
    private static int N, M;
    private static ArrayList<ArrayList<int[]>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        initialize(br);
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            int distance = BFS(node1, node2);
            bw.write(distance + "\n");
        }

        bw.close();
        br.close();
    }

    private static void initialize(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            graph.get(node1).add(new int[]{node2, distance});
            graph.get(node2).add(new int[]{node1, distance});
        }

        // sort
        for (int i = 1; i <= N; i++) {
            graph.get(i).sort(Comparator.comparingInt(o -> o[1]));
        }
    }

    private static int BFS(int node1, int node2) {
        boolean[] localVisited = new boolean[N + 1];
        localVisited[node1] = true;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{node1, 0});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentNode = current[0];
            int currentDistance = current[1];

            if (currentNode == node2) {
                return currentDistance;
            }

            for (int[] next : graph.get(currentNode)) {
                int nextNode = next[0];
                int nextDistance = next[1];

                if (!localVisited[nextNode]) {
                    localVisited[nextNode] = true;
                    queue.add(new int[]{nextNode, currentDistance + nextDistance});
                }
            }
        }
        return -1;
    }
}