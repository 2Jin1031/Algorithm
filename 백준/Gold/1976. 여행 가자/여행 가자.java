import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static int N, M;
    private static boolean[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        initialize(br);
        makeFloyd();
        int[] arr = new int[M];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        boolean isPossible = true;
        for (int i = 0; i < M - 1; i++) {
            if (!map[arr[i]][arr[i + 1]]) {
                isPossible = false;
                break;
            }
        }
        bw.write(isPossible ? "YES" : "NO");

        bw.close();
        br.close();
    }

    private static void initialize(BufferedReader br) throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        map = new boolean[N + 1][N + 1];
        for (int i = 1; i < N + 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N + 1; j++) {
                map[i][j] = Integer.parseInt(st.nextToken()) == 1;
            }
        }

        for (int i = 1; i < N + 1; i++) {
            map[i][i] = true;
        }
    }

    private static void makeFloyd() {
        for (int k = 1; k < N + 1; k++) {
            for (int i = 1; i < N + 1; i++) {
                for (int j = 1; j < N + 1; j++) {
                    if (map[i][k] && map[k][j]) {
                        map[i][j] = true;
                    }
                }
            }
        }
    }
}