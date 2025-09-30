import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        int[][] pref = new int[N + 1][4];
        for (int i = 1; i < N + 1; i++) {
            int num = Integer.parseInt(br.readLine());
            pref[i][1] = pref[i - 1][1];
            pref[i][2] = pref[i - 1][2];
            pref[i][3] = pref[i - 1][3];
            pref[i][num]++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < Q + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(pref[b][1] - pref[a - 1][1]).append(' ')
              .append(pref[b][2] - pref[a - 1][2]).append(' ')
              .append(pref[b][3] - pref[a - 1][3]).append('\n');
        }

        System.out.println(sb);
    }
}