import java.io.*;
import java.util.*;

public class Main {

    private static int N, K, L;
    private static int[][] map;
    private static boolean[][] snake;
    private static HashMap<Integer, Character> direction;

    private static final int[] DX = {0, 1, 0, -1};
    private static final int[] DY = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        initialize(br);
        int time = moveSnake();
        bw.write(time + "\n");
        bw.close();
        br.close();
    }

    private static void initialize(BufferedReader br) throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        snake = new boolean[N + 1][N + 1];

        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            String[] input = br.readLine().split(" ");
            map[Integer.parseInt(input[0])][Integer.parseInt(input[1])] = 1;
        }

        L = Integer.parseInt(br.readLine());
        direction = new HashMap<>();
        for (int i = 0; i < L; i++) {
            String[] input = br.readLine().split(" ");
            direction.put(Integer.parseInt(input[0]), input[1].charAt(0));
        }
    }

    private static int moveSnake() {
        Deque<int[]> snakeBody = new LinkedList<>();
        int currentX = 1, currentY = 1, directionIdx = 0, time = 0;
        snakeBody.add(new int[]{currentX, currentY});
        snake[currentX][currentY] = true;

        while (true) {
            time++;
            int nextX = currentX + DX[directionIdx];
            int nextY = currentY + DY[directionIdx];

            if (!coordinateCheck(nextX, nextY) || snake[nextX][nextY]) {
                break;
            }

            snakeBody.addFirst(new int[]{nextX, nextY});
            snake[nextX][nextY] = true;

            if (map[nextX][nextY] == 1) {
                map[nextX][nextY] = 0;
            } else {
                int[] tail = snakeBody.pollLast();
                snake[tail[0]][tail[1]] = false;
            }

            if (direction.containsKey(time)) {
                directionIdx = directionCheck(time, directionIdx);
            }

            currentX = nextX;
            currentY = nextY;
        }
        return time;
    }

    private static int directionCheck(int nextTime, int directionIdx) {
        if (direction.containsKey(nextTime)) {
            if (direction.get(nextTime) == 'L') {
                directionIdx = (directionIdx + 3) % 4;
            } else {
                directionIdx = (directionIdx + 1) % 4;
            }
        }
        return directionIdx;
    }

    private static boolean coordinateCheck(int x, int y) {
        return x > 0 && x <= N && y > 0 && y <= N;
    }
}
