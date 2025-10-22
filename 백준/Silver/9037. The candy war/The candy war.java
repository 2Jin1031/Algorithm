import java.io.*;
import java.util.*;

public class Main {
    static boolean allEqual(int[] a) {
        for (int i = 1; i < a.length; i++) if (a[i] != a[0]) return false;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

            for (int i = 0; i < N; i++) if ((arr[i] & 1) == 1) arr[i]++;

            int rounds = 0;
            while (!allEqual(arr)) {
                int[] next = new int[N];
                for (int i = 0; i < N; i++) {
                    int left = (i - 1 + N) % N;
                    next[i] = arr[i] / 2 + arr[left] / 2;
                }
                for (int i = 0; i < N; i++) if ((next[i] & 1) == 1) next[i]++; // 순환 내 홀수 보정
                arr = next;
                rounds++;
            }
            sb.append(rounds).append('\n');
        }
        System.out.print(sb);
    }
}