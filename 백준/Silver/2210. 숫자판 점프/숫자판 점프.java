import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {
    private static final int MAP_SIZE = 5;
    private static final int DIGIT = 6;

    private static int[][] map;
    private static ArrayList<Integer> numbers;

    private static final int[] DX = {0, 0, 1, -1};
    private static final int[] DY = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        initialize(br);

        for (int i = 0; i < MAP_SIZE; i++) {
            for (int j = 0; j < MAP_SIZE; j++) {
                dfs(new int[]{i, j}, 0, 0);
            }
        }

        bw.write(numbers.size() + "\n");
        bw.close();
        br.close();
    }

    private static void initialize(BufferedReader br) throws IOException {
        map = new int[MAP_SIZE][MAP_SIZE];
        numbers = new ArrayList<>();

        for (int i = 0; i < MAP_SIZE; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < MAP_SIZE; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void dfs(int[] start, int depth, int number) {
        if (depth == DIGIT) {
            if (!numbers.contains(number)) {
                numbers.add(number);
            }
            return;
        }

        for (int i = 0; i < DX.length; i++) {
            int nextX = start[0] + DX[i];
            int nextY = start[1] + DY[i];

            if (nextX < 0 || nextY < 0 || nextX >= MAP_SIZE || nextY >= MAP_SIZE) {
                continue;
            }

            dfs(new int[]{nextX, nextY}, depth + 1, number * 10 + map[nextX][nextY]);
        }
    }
}
