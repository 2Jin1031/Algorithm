import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    private static boolean[][] map = new boolean[101][101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = 0;
        for (int loop = 0; loop < 4; loop++) {
            String[] input = br.readLine().split(" ");
            int startX = Integer.parseInt(input[0]);
            int startY = Integer.parseInt(input[1]);
            int endX = Integer.parseInt(input[2]);
            int endY = Integer.parseInt(input[3]);

            for (int i = startX; i < endX; i++) {
                for (int j = startY; j < endY; j++) {
                    if (!map[i][j]) {
                        map[i][j] = true;
                        count++;
                    }
                }
            }
        }
        bw.write(count + "\n");
        bw.flush();
        bw.close();
    }
}