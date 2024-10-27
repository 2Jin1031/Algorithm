import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int N, M;
    private static ArrayList<ArrayList<Integer>> arr;
    private static int[] visited;

    private static int[] count;

    private static final int[] DX = {1, -1, 0, 0};
    private static final int[] DY = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new java.io.OutputStreamWriter(System.out));

        initialization(br);

        bfs();

        int count = 0;
        for (int i = 1; i < N + 1; i++) {
            if (visited[i] != 0 && visited[i] <= 3) {
                count++;
            }
        }

        bw.write(count - 1 + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    private static void initialization(BufferedReader br) throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        arr = new ArrayList<>();
        visited = new int[N + 1];

        for (int i = 0; i < N + 1; i++) {
            arr.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr.get(a).add(b);
            arr.get(b).add(a);
        }
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        visited[1] = 1;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int i = 0; i < arr.get(current).size(); i++) {
                int next = arr.get(current).get(i);

                if (visited[next] == 0) {
                    visited[next] = visited[current] + 1;
                    queue.offer(next);
                }
            }
        }
    }
}
