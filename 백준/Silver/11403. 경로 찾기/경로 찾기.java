import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static int[][] map;
    private static boolean[][] visited;
    private static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        initialize(br);

        for (int i = 0; i < N; i++) {
            bfs(i);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                bw.write(map[i][j] + " ");
            }
            bw.write("\n");
        }

        br.close();
        bw.close();
    }

    private static void initialize(BufferedReader br) throws IOException {
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                graph.add(new ArrayList<>());
                if (map[i][j] == 1) {
                    graph.get(i).add(j);
                }
            }
        }
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        for (int value : graph.get(start)) {
            queue.offer(value);
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int nextNode : graph.get(node)) {
                if (!visited[start][nextNode] && map[start][nextNode] == 0) {
                    visited[start][nextNode] = true;
                    map[start][nextNode] = 1;
                    queue.offer(nextNode);
                }
            }
        }
    }
}