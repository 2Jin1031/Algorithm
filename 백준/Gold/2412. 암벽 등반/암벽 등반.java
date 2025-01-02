import java.io.*;
import java.util.*;

public class Main {

    private static int N, T;
    private static TreeSet<int[]> pointSet;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        pointSet = new TreeSet<>((o1, o2) -> {
            if (o1[1] != o2[1]) return Integer.compare(o1[1], o2[1]); // y 우선 정렬
            return Integer.compare(o1[0], o2[0]); // x 정렬
        });

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            pointSet.add(new int[]{x, y});
        }

        pointSet.add(new int[]{0, 0}); // 시작점 강제 추가

        int result = BFS();
        System.out.println(result);
    }

    private static int BFS() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 0}); // 시작점: (0, 0), 이동 횟수 0

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int curX = current[0];
            int curY = current[1];
            int steps = current[2];

            if (curY >= T) { // 목표 높이에 도달
                return steps;
            }

            // 현재 y 범위에서 이동 가능한 점들 탐색
            List<int[]> candidates = new ArrayList<>(pointSet.subSet(
                    new int[]{Integer.MIN_VALUE, curY - 2}, true,
                    new int[]{Integer.MAX_VALUE, curY + 2}, true
            ));

            // 후보 점들 방문 처리 (x 범위 필터링 추가)
            for (int[] next : candidates) {
                if (Math.abs(curX - next[0]) <= 2) {
                    queue.offer(new int[]{next[0], next[1], steps + 1});
                    pointSet.remove(next); // 방문 처리
                }
            }
        }
        return -1; // 목표에 도달할 수 없는 경우
    }
}