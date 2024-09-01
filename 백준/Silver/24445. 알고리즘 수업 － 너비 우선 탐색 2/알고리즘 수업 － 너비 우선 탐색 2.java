import java.io.*;
import java.util.*;

public class Main {
    private static int N, M, R;
    private static ArrayList<ArrayList<Integer>> graph;
    private static boolean[] visited;
    private static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        initialize(br);
        BFS(R);

        // print
        for (int i = 1; i < N + 1; i++) {
            bw.write(distance[i] + "\n");

        }

        bw.close();
        br.close();
    }

    private static void initialize(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        visited = new boolean[N + 1];
        distance = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            graph.get(node1).add(node2);
            graph.get(node2).add(node1);
        }

        // 내림차순 정렬
        for (int i = 0; i <= N; i++) {
            Collections.sort(graph.get(i), Collections.reverseOrder());
        }
    }

    private static void BFS(int startNode) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);
        visited[startNode] = true;

        int localDistance = 1;
        distance[startNode] = localDistance;
        while (!queue.isEmpty()) {
            int currentNode = queue.poll();

            for (int nextNode : graph.get(currentNode)) {
                if (!visited[nextNode]) {
                    visited[nextNode] = true;
                    localDistance++;
                    distance[nextNode] = localDistance;
                    queue.add(nextNode);
                }
            }
        }
    }
}