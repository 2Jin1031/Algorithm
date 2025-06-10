import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int i;
        int totalTime = 0;
        for (i = 0; i < N; i++) {
            totalTime += Integer.parseInt(st.nextToken());
            if (totalTime > T) {
                break;
            }
        }
        System.out.println(i);
    }
}