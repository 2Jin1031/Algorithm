import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[N + 1];

        int num = 0;
        for (int i = 2; i <= N; i++) {
            for (int j = 1; i * j <= N; j++) {
                num = i * j;
                if (!visited[num]) {
                    visited[num] = true;
                    K--;
                    if (K == 0) {
                        break;
                    }
                }
            }
            if (K == 0) {
                break;        
            }
        }
        System.out.println(num);
    }
}
