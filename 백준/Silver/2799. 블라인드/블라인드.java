import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        String[] lines = new String[5 * M + 1];
        for (int i = 0; i < 5 * M + 1; i++) {
            lines[i] = br.readLine();
        }

        int[] answers = new int[6]; // 5 + 1
        for (int i = 4; i < 5 * M + 1; i += 5) {
            for (int j = 1; j < 5 * N + 1; j += 5) {

                int num;
                for (num = i; num > i - 4; num--) { // 창문 종류 찾기
                    if (lines[num].charAt(j) == '*') {
                        break;
                    }    
                }
                num = num % 5 + 1;
                answers[num]++;
            }
        }

        // result
        for (int i = 1; i < 6; i++) {
            System.out.printf(answers[i] + " ");
        }
    }
}