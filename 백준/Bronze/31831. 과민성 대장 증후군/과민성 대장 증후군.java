import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int stressAmount = 0;
        int ans = 0;
        for (int i = 0; i < N; i++) {
            int stressOfDay = Integer.parseInt(st.nextToken());
            stressAmount += stressOfDay;
            
            if (stressAmount < 0) stressAmount = 0;
            else if (stressAmount >= M) {
                ans++;
            }
        }

        System.out.println(ans);
    }
}