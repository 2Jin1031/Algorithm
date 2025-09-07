import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        int[] A = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());

        Integer[] idx = new Integer[N];
        for (int i = 0; i < N; i++) idx[i] = i;

        Arrays.sort(idx, (i, j) -> {
            if (A[i] != A[j]) return Integer.compare(A[i], A[j]);
            return Integer.compare(i, j);
        });

        int[] P = new int[N];
        for (int rank = 0; rank < N; rank++) P[idx[rank]] = rank;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            if (i > 0) sb.append(' ');
            sb.append(P[i]);
        }
        System.out.println(sb);
    }
}