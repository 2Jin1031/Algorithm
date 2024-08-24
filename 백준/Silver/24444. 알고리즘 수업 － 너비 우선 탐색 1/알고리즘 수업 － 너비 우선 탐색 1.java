import java.io.*;
import java.util.*;

public class Main {
    private static int N, M, R;
    private static ArrayList<ArrayList<Integer>> map = new ArrayList<>();
    private static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        initialize(br);

        bfs();

        for (int i = 1; i < N + 1; i++) {
            bw.write(visited[i] + "\n");
        }

        bw.close();
        br.close();
    }

    private static void initialize(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N + 1; i++) {
            map.add(new ArrayList<>());
        }

        visited = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            map.get(u).add(v);
            map.get(v).add(u);
        }

        for (int i = 0; i < map.size(); i++) {
            Collections.sort(map.get(i));
        }
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(R);
        int count = 1;
        visited[R] = count;

        count++;
        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : map.get(current)) {
                if (visited[next] == 0) {
                    visited[next] = count;
                    count++;
                    queue.offer(next);
                }
            }
        }
    }
}