import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        String ans = backtracking("");
        
        System.out.println(ans);
    }

    private static String backtracking(String str) {
        if (str.length() == N) {
            return str;
        }

        boolean[] visited = new boolean[4]; // 안되는 숫자 visited 해버리기
        int length = 1;
        while (length * 2 - 1 <= str.length()) { // depth 에 따라서 앞에 한개, 두개, 세개 ..
            String src = str.substring(str.length() - (length * 2 - 1), str.length() - length + 1); //
            String desc = str.substring(str.length() - length + 1); //

            if (src.substring(0, src.length() - 1).equals(desc)) {
                int num = Integer.parseInt(src.substring(src.length() - 1));
                visited[num] = true;
            }
            length++;
        }

        // 되는 것 중에 맨 앞에 찾기
        for (int i = 1; i < 4; i++) {
            if (!visited[i]) {
                String ans = backtracking(str + i);
                if (ans != null) {
                    return ans;
                }
            }
        }

        return null;
    }
}