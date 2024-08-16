import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    private static int N;
    private static int M;
    private static ArrayList<ArrayList<Integer>> graph;
    private static boolean[] visited;
    private static int[] distances;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        initialize(br);

        bfs(1);

        int maxDistance = 0;
        int maxIdx = 0;
        int sameDistance = 0;
        for (int i = 1; i < N + 1; i++) {
            if (distances[i] > maxDistance) {
                maxDistance = distances[i];
                maxIdx = i;
                sameDistance = 1;
            } else if (distances[i] == maxDistance) {
                sameDistance++;
            }

        }
        bw.write(maxIdx + " " + maxDistance + " " + sameDistance + "\n");
        bw.close();
        br.close();
    }

    private static void initialize(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>(N + 1);
        visited = new boolean[N + 1];
        distances = new int[N + 1];

        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
            distances[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        distances[start] = 0;
        visited[start] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : graph.get(current)) {
                if (!visited[next]) {
                    visited[next] = true;
                    
                    distances[next] = distances[current] + 1;
                    queue.add(next);
                }
            }
        }
    }
}
