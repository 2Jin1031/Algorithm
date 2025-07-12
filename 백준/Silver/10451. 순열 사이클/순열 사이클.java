import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N + 1];
            boolean[] visited = new boolean[N + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i < N + 1; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int count = 0;
            for (int i = 1; i < N + 1; i++) {
                if (visited[i]) continue;
                int idx = i;
                visited[idx] = true;
                while (true) {
                    int num = arr[idx];
                    visited[num] = true;
                    if (num == i) {
                        count++;
                        break;
                    }
                    idx = num;
                }
            }
            System.out.println(count);
        }
    }
}