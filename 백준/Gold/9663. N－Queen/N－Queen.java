import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    private static int N;
    private static int[] queenPosition;
    private static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        queenPosition = new int[N];

        solveNQueen(0);

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void solveNQueen(int row) {
        if (row == N) {
            result++;
            return;
        }
        for (int col = 0; col < N; col++) {
            if (isSafe(row, col)) {
                queenPosition[row] = col;
                solveNQueen(row + 1);
            }
        }
    }

    private static boolean isSafe(int row, int col) {
        for (int prevRow = 0; prevRow < row; prevRow++) {
            if (queenPosition[prevRow] == col ||
                    Math.abs(queenPosition[prevRow] - col) == Math.abs(prevRow - row)) {
                return false;
            }
        }
        return true;
    }
}