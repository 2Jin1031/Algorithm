import java.io.*;
import java.util.*;

public class Main {
    static final long INF = Long.MAX_VALUE / 4;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int[] result = new int[N];
        int idx = 0;
        for (int i = 0; i < N; i++) {
            int num = arr[i];
            for (int j = 0; j < N; j++) {
                if (result[j] < num) {
                    result[j] = num;
                    idx = Math.max(idx, j);
                    break;
                }
            }
        }

        System.out.println(idx + 1);
    }
}