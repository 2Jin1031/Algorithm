import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static int a, b;
    private static int[] arr;
    private static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        visited = new int[N];
        Arrays.fill(visited, -1); // 방문 초기화

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken()) - 1;
        b = Integer.parseInt(st.nextToken()) - 1;

        BFS(a);

        bw.write(visited[b] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void BFS(int startPosition) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startPosition);
        visited[startPosition] = 0; // 시작점 방문 처리

        while (!queue.isEmpty()) {
            int currentPosition = queue.poll();
            int currentCount = visited[currentPosition];

            int stepSize = arr[currentPosition];

            // 왼쪽 방향으로 점프
            for (int nextPosition = currentPosition - stepSize; nextPosition >= 0; nextPosition -= stepSize) {
                if (visited[nextPosition] == -1) {
                    visited[nextPosition] = currentCount + 1; // 거리 갱신
                    queue.add(nextPosition);
                }
            }

            // 오른쪽 방향으로 점프
            for (int nextPosition = currentPosition + stepSize; nextPosition < N; nextPosition += stepSize) {
                if (visited[nextPosition] == -1) {
                    visited[nextPosition] = currentCount + 1; // 거리 갱신
                    queue.add(nextPosition);
                }
            }
        }
    }
}