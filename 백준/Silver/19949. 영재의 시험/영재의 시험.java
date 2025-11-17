import java.io.*;
import java.util.*;

public class Main {

    private static int[] arr = new int[12];
    private static int ans = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 2; i < 12; i++) { // 앞에 두개는 0인 숫자 삽입으로 고려
            arr[i] = Integer.parseInt(st.nextToken());
        }

        backtracking(new int[12], 2);
        System.out.println(ans);
    }

    private static void backtracking(int[] result, int idx) { // idx: 이번 거
        if (idx == 12) {
            int correct = 0;
            for (int i = 2; i < 12; i++) {
                if (arr[i] == result[i]) {
                    correct++;
                }
            }
            if (correct >= 5) {
                ans++;
            }
            return ;
        }

        boolean isFlag = false;
        int standard = result[idx - 1];
        if (result[idx - 2] == result[idx - 1]) {
            isFlag = true;
        }

        for (int i = 1; i < 6; i++) {

            if (isFlag && standard == i) { // 이미 연속 2번 에 지금도 같을 것 같으면 패스
                continue;
            }
            
            result[idx] = i;
            backtracking(result, idx + 1);    
            result[idx] = 0;
        }    
    }
}