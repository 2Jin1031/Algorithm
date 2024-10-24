import static java.util.Collections.sort;

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
    private static long[] visited;
    private static long[] depth;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new java.io.OutputStreamWriter(System.out));

        initialization(br);

        bfs(R);

        long result = 0;
        for (int i = 1; i < N + 1; i++) {
            result += visited[i] * depth[i];
        }

        bw.write(result + "\n");

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
        visited = new long[N + 1];
        depth = new long[N + 1];

        for (int i = 0; i < N + 1; i++) {
            depth[i] = -1;
            arr.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr.get(a).add(b);
            arr.get(b).add(a);
        }

        for (int i = 1; i < N + 1; i++) {
            sort(arr.get(i));
        }
    }

    private static void bfs(int startIdx) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startIdx);
        int visitOrder = 1;
        visited[startIdx] = visitOrder++;
        depth[startIdx] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int idx : arr.get(current)) {
                if (visited[idx] == 0) {
                    visited[idx] = visitOrder++;
                    depth[idx] = depth[current] + 1;
                    queue.offer(idx);
                }
            }
        }
    }
}
