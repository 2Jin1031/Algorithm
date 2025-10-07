import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        boolean[] visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int currentIdx = 0; visited[0] = true;
        int ans = 1;
        while (true) {
            int nextIdx = arr[currentIdx];
            if (nextIdx == K) {
                System.out.println(ans);
                return;
            }
            if (visited[nextIdx]) {
                break;
            }
            visited[nextIdx] = true;
            ans++;
            currentIdx = nextIdx;
        }
        System.out.println("-1");
    }
}