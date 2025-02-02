import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());  // 테스트 케이스 개수
        for (int t = 0; t < T; t++) {
            String[] input = br.readLine().split(" ");
            int A = Integer.parseInt(input[0]);
            int B = Integer.parseInt(input[1]);

            String result = BFS(A, B);
            sb.append(result).append("\n");
        }

        System.out.print(sb);
    }

    private static String BFS(int src, int desc) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[10000];  // 방문 체크 배열
        String[] command = new String[10000];    // 명령어 기록 배열

        queue.offer(new int[]{src, 0});
        visited[src] = true;
        command[src] = "";

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentValue = current[0];
            String currentCommand = command[currentValue];

            if (currentValue == desc) {
                return currentCommand;
            }

            // D (2배 연산)
            int nextValue = (currentValue * 2) % 10000;
            if (!visited[nextValue]) {
                visited[nextValue] = true;
                command[nextValue] = currentCommand + "D";
                queue.offer(new int[]{nextValue, current[1] + 1});
            }

            // S (1 감소, 0이면 9999)
            nextValue = currentValue == 0 ? 9999 : currentValue - 1;
            if (!visited[nextValue]) {
                visited[nextValue] = true;
                command[nextValue] = currentCommand + "S";
                queue.offer(new int[]{nextValue, current[1] + 1});
            }

            // L (왼쪽 회전)
            nextValue = (currentValue % 1000) * 10 + currentValue / 1000;
            if (!visited[nextValue]) {
                visited[nextValue] = true;
                command[nextValue] = currentCommand + "L";
                queue.offer(new int[]{nextValue, current[1] + 1});
            }

            // R (오른쪽 회전)
            nextValue = (currentValue % 10) * 1000 + currentValue / 10;
            if (!visited[nextValue]) {
                visited[nextValue] = true;
                command[nextValue] = currentCommand + "R";
                queue.offer(new int[]{nextValue, current[1] + 1});
            }
        }

        return "";
    }
}