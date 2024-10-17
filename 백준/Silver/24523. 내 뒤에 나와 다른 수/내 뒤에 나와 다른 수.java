import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new java.io.OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        int[] result = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        arr[0] = arr[1] - 1; // 더미 값

        for (int i = 1; i < N + 1; i++) {
            if (arr[i - 1] == arr[i]) {
                result[i] = result[i - 1];
                continue;
            }
            int idx = -1;
            for (int j = i + 1; j < N + 1; j++) {
                if (arr[i] != arr[j]) {
                    idx = j;
                    break;
                }
            }
            result[i] = idx;
        }

        // print
        for (int i = 1; i < N + 1; i++) {
            bw.write(result[i] + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}