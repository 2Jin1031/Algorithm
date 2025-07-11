import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }

            boolean[] visited = new boolean[N + 1];
            int current = 1;
            int count = 0;

            visited[1] = true;

            while (true) {
                current = arr[current];
                count++;

                if (current == N) {
                    System.out.println(count);
                    break;
                }

                if (visited[current]) {
                    System.out.println(0);
                    break;
                }

                visited[current] = true;
            }
        }
    }
}