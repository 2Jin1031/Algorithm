import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static ArrayList<int[]> arr;
    private static int[] cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        initialize(br);
        int maxCnt = BFS();
        bw.write(N - maxCnt + "\n");
        bw.close();
        br.close();

    }

    private static void initialize(BufferedReader br) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr.add(new int[]{x, y});
        }

        arr.sort((a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]); // x가 같으면 y를 기준으로 정렬
            } else {
                return Integer.compare(a[0], b[0]); // x를 기준으로 정렬
            }
        });


        cnt = new int[arr.size()];
        Arrays.fill(cnt, 1);
    }

    private static int BFS() {
        int maxCnt = 0;

        for (int i = 0; i < arr.size(); i++) {
            int[] current = arr.get(i);
            int currentX = current[0];
            int currentY = current[1];

            for (int j = 0;  j < i; j++) {
                int[] next = arr.get(j);
                int nextX = next[0];
                int nextY = next[1];

                if (currentX > nextX && currentY > nextY) {
                    cnt[i] = Math.max(cnt[i], cnt[j] + 1);
                }
            }

            maxCnt = Math.max(maxCnt, cnt[i]);
        }


        return maxCnt;
    }
}