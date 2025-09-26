import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new java.io.OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] sum = new int[M + 1];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                sum[j + 1] += Integer.parseInt(st.nextToken());
            }
        }

        int rowCount = Integer.parseInt(br.readLine());

        int[] sectionSum = new int[M + 1];
        for (int i = 1; i < M + 1; i++) {
            sectionSum[i] += sectionSum[i - 1] + sum[i];
        }

        int ans = 0;
        for (int i = rowCount; i < M + 1; i++) {
            ans = Math.max(ans, sectionSum[i] - sectionSum[i - rowCount]);;
        }

        System.out.println(ans);
    }
}