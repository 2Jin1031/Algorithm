import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            int N, M;
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            if (N == 0 && M == 0) {
                break;
            }
            HashSet<Integer> set = new HashSet<>();
            for (int i = 0; i < N; i++) {
                set.add(Integer.parseInt(br.readLine()));
            }

            int result = 0;
            for (int i = 0; i < M; i++) {
                if (set.contains(Integer.parseInt(br.readLine()))) {
                    result++;
                }
            }
            bw.write(result + "\n");
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}