import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int N, M, R;
    private static ArrayList<ArrayList<Integer>> arr;
    private static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new java.io.OutputStreamWriter(System.out));

        initialization(br);

        bfs(R);

        for (int i = 1; i < N + 1; i++) {
            bw.write(visited[i] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void initialization(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new ArrayList<>();
        visited = new int[N + 1];

        for (int i = 0; i < N + 1; i++) {
            visited[i] = -1;
            arr.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr.get(a).add(b);
            arr.get(b).add(a);
        }
    }

    private static void bfs(int startIdx) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startIdx);
        visited[startIdx] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int idx : arr.get(current)) {
                if (visited[idx] == -1) {
                    visited[idx] = visited[current] + 1;
                    queue.offer(idx);
                }
            }
        }
    }
}
