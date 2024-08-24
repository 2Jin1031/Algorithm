import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int T, N;
    private static int[] startPoint;
    private static ArrayList<int[]> cu;
    private static int[] endPoint;

    private static int bearCount = 20;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            initialize(br);
            bw.write(bfs() ? "happy\n" : "sad\n");
        }

        bw.close();
        br.close();
    }

    private static void initialize(BufferedReader br) throws IOException {
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        startPoint = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

        cu = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            cu.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        st = new StringTokenizer(br.readLine());
        endPoint = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
    }

    private static boolean bfs() {
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[N];
        queue.offer(startPoint);

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];

            int endDistance = Math.abs(currentX - endPoint[0]) + Math.abs(currentY - endPoint[1]);
            if (endDistance <= bearCount * 50) {
                return true;
            }

            for (int i = 0; i < cu.size(); i++) {
                if (!visited[i]) {
                    int[] currentCu = cu.get(i);
                    int cuX = currentCu[0];
                    int cuY = currentCu[1];

                    int cuDistance = Math.abs(currentX - cuX) + Math.abs(currentY - cuY);
                    if (cuDistance <= bearCount * 50) {
                        visited[i] = true;
                        queue.offer(new int[]{cuX, cuY});
                    }
                }
            }
        }
        return false;
    }
}