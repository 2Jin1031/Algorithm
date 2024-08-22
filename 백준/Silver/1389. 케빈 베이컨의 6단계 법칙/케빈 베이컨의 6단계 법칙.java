import java.io.*;
import java.util.*;

public class Main {
    private static int N, M;
    private static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        initialize(br);

        int minValue = Integer.MAX_VALUE;
        int minIndex = 0;
        for (int i = 1; i < N + 1; i++) {
            int value = bfs(i);
            if (minValue > value) {
                minValue = value;
                minIndex = i;
            }
        }

        bw.write(minIndex + "\n");

        bw.close();
        br.close();
    }

    private static void initialize(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
    }

    private static int bfs(int start) {
        int[] localDistance = new int[N + 1];
        Arrays.fill(localDistance, -1);
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);

        localDistance[start] = 0;

        while (!q.isEmpty()) {
            int x = q.poll();

            for (int i = 0; i < graph.get(x).size(); i++) {
                int y = graph.get(x).get(i);
                if (localDistance[y] == -1) {
                    q.offer(y);
                    localDistance[y] = localDistance[x] + 1;
                }
            }
        }

        int sum = 0;
        for (int i = 1; i < N + 1; i++) {
            sum += localDistance[i];
        }

        return sum;
    }
}