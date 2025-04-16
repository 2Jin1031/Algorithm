import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            int[][] applicants = new int[N][2];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                applicants[i][0] = Integer.parseInt(st.nextToken()); // a
                applicants[i][1] = Integer.parseInt(st.nextToken()); // b
            }

            Arrays.sort(applicants, Comparator.comparingInt(o -> o[0]));

            int count = 1;
            int minB = applicants[0][1];
            for (int i = 1; i < N; i++) {
                if (applicants[i][1] < minB) {
                    count++;
                    minB = applicants[i][1];
                }
            }

            System.out.println(count);
        }
    }
}