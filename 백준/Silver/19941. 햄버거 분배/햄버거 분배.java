import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        String input = br.readLine();

        // 1. set 완성하기
        boolean[] hamburger = new boolean[N];
        for (int i = 0; i < input.length(); i++) {
            Character ch = input.charAt(i);
            if (ch == 'H') { // hamburger
                hamburger[i] = true;
            }
        }

        int result = 0;
        for (int i = 0; i < input.length(); i++) {
            Character ch = input.charAt(i);
            if (ch == 'P') { // person
                int startIdx = Math.max(0, i - K);
                int endIdx = Math.min(N, i + K + 1);
                while (startIdx < endIdx) {
                    if (hamburger[startIdx]) {
                        result++;
                        hamburger[startIdx] = false;
                        break;
                    }
                    startIdx++;
                }
            }
        }
        System.out.println(result);
    }
}