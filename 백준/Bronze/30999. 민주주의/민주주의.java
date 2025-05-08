import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int ans = 0;
        for (int i = 0; i < N; i++) {
            String input = br.readLine();

            int agreeCount = 0;
            int disAgreeCount = 0;
            for(int j = 0; j < input.length(); j++) {
                if (input.charAt(j) == 'O') {
                    agreeCount++;
                } else {
                    disAgreeCount++;
                }
            }
            if (agreeCount > disAgreeCount) {
                ans++;
            }
        }

        System.out.println(ans);
    }
}