import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int[][] map;
    private static int result[] = new int[2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        divide(0, 0, N);

        sb.append(result[0]).append("\n").append(result[1]);
        System.out.println(sb);
    }

    private static void divide(int low, int start, int size) {
        if (size == 0) {
            return;
        }

        boolean isOne = true;
        boolean isZero = true;
        for (int i = low; i < low + size; i++) {
            for (int j = start; j < start + size; j++) {
                if (map[i][j] == 0) {
                    isOne = false;
                    if (!isZero) {
                        break;
                    }
                } else {
                    isZero = false;
                    if (!isOne) {
                        break;
                    }
                }
            }
        }

        if (isOne) {
            result[1]++;
            return;
        }
        if (isZero) {
            result[0]++;
            return;
        }

        divide(low, start, size / 2);
        divide(low, start + size / 2, size / 2);
        divide(low + size / 2, start, size / 2);
        divide(low + size / 2, start + size / 2, size / 2);
    }
}