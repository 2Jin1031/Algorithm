import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int N, M;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[][] candyCnt;

    private static int[] endLocation;

    private final static int[] DX = {0, 1, 1};
    private final static int[] DY = {1, 0, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        initialize(br);
        int maxCandy = dp(new int[]{0, 0});
        bw.write(maxCandy + "\n");

        bw.close();
        br.close();
    }

    private static void initialize(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];
        candyCnt = new int[N][M];

        endLocation = new int[]{N - 1, M - 1};

        // candyCnt init
        for (int i = 0; i < N; i++) {
            Arrays.fill(candyCnt[i], Integer.MIN_VALUE);
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static int dp(int[] start) {
        candyCnt[0][0] = map[0][0];

        // row 0
        for (int i = 1; i < M; i++) {
            candyCnt[0][i] = candyCnt[0][i - 1] + map[0][i];
        }

        // column 0
        for (int i = 1; i < N; i++) {
            candyCnt[i][0] = candyCnt[i - 1][0] + map[i][0];
        }

        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                candyCnt[i][j] = Math.max(candyCnt[i - 1][j], candyCnt[i][j - 1]) + map[i][j];
            }
        }

        return candyCnt[endLocation[0]][endLocation[1]];
    }
}