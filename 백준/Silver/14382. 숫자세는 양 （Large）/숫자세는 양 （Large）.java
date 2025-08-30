import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num == 0) {
                System.out.println(String.format("Case #%d: INSOMNIA", i + 1));
                continue;
            }

            boolean[] visited = new boolean[10];
            int restVisitedCount = 10;

            int result = 0;
            while (restVisitedCount > 0) {
                result += num;

                int tmp = result;
                while (tmp > 0) {
                    int rest = tmp % 10;
                    if (!visited[rest]) {
                        visited[rest] = true;
                        restVisitedCount--;
                    }
                    tmp /= 10;
                }
            }
            System.out.println(String.format("Case #%d: %d", i + 1, result));
        }
    }
}