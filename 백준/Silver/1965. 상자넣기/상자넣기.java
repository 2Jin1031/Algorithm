import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static int[] boxes;
    private static int[] boxCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        initialize(br);

        boxCount[N - 1] = 1;
        int maxCnt = 1;
        for (int i = N - 2; i >= 0; i--) {
            for (int j = i + 1; j < N; j++) {
                if (boxes[i] < boxes[j]) {
                    boxCount[i] = Math.max(boxCount[i], boxCount[j] + 1);
                }
            }
            maxCnt = Math.max(maxCnt, boxCount[i]);
        }

        bw.write(maxCnt + "\n");

        bw.close();
        br.close();
    }

    private static void initialize(BufferedReader br) throws IOException {

        N = Integer.parseInt(br.readLine());

        boxes = new int[N];
        boxCount = new int[N];

        for (int i = 0; i < N; i++) {
            boxCount[i] = 1;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            boxes[i] = Integer.parseInt(st.nextToken());
        }


    }
}