import java.io.*;
import java.util.*;

public class Main {
    private static int N, K;
    private static int[] location;
    private static boolean[] visited;

    private static int graphSize;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        initialize(br);
        bfs(N, bw);

        bw.close();
        br.close();
    }

    private static void bfs(int start, BufferedWriter bw) throws IOException {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start, 0});
        visited[start] = true;

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentLocation = current[0];
            int currentCount = current[1];

            if(currentLocation == K) {
                bw.write(currentCount + "\n");

                // 경로를 추적해서 스택에 저장
                Stack<Integer> stack = new Stack<>();
                int temp = K;
                while (temp != start) {
                    stack.push(temp);
                    temp = location[temp];
                }
                stack.push(start);

                // 스택에서 하나씩 꺼내어 순서대로 출력
                while (!stack.isEmpty()) {
                    bw.write(stack.pop() + " ");
                }
                bw.write("\n");
                break;
            }

            if(isValidCoordinate(currentLocation + 1) && !visited[currentLocation + 1]) {
                queue.add(new int[]{currentLocation + 1, currentCount + 1});
                location[currentLocation + 1] = currentLocation;
                visited[currentLocation + 1] = true;
            }
            if (isValidCoordinate(currentLocation - 1) && !visited[currentLocation - 1]) {
                queue.add(new int[]{currentLocation - 1, currentCount + 1});
                location[currentLocation - 1] = currentLocation;
                visited[currentLocation - 1] = true;
            }
            if (isValidCoordinate(currentLocation * 2) && !visited[currentLocation * 2]) {
                queue.add(new int[]{currentLocation * 2, currentCount + 1});
                location[currentLocation * 2] = currentLocation;
                visited[currentLocation * 2] = true;
            }
        }
    }

    private static void initialize(BufferedReader br) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        graphSize = Math.max(N, K) * 2 + 1;

        location = new int[graphSize];
        visited = new boolean[graphSize];

        Arrays.fill(location, -1);
    }

    private static boolean isValidCoordinate(int currentLocation) {
        return currentLocation >= 0 && currentLocation < graphSize;
    }
}