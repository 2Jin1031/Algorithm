import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N + 1][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int countryNumber = Integer.parseInt(st.nextToken());
            for (int j = 0; j < 3; j++) {
                arr[countryNumber][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        for (int i = 1; i < N + 1; i++) {
            if (i == K) continue;

            if (arr[K][0] < arr[i][0]) ans++;
            else if (arr[K][1] < arr[i][1]) ans++;
            else if (arr[K][2] < arr[i][2]) ans++;
        }

        System.out.println(ans);
    }
}