import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static char[] arr;
    private static StringBuilder ans = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new char[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = st.nextToken().charAt(0);
        }

        backtracking(new StringBuilder(), -1, new boolean[10]);

        ans.deleteCharAt(ans.length() - 1);
        int first = ans.indexOf("\n");
        int last  = ans.lastIndexOf("\n");
        
        String firstLine = ans.substring(0, first);
        String lastLine = ans.substring(last + 1);
        System.out.println(lastLine);
        System.out.println(firstLine);
    }

    private static void backtracking(StringBuilder sb, int idx, boolean[] visited) {
        int count = sb.length();
        if (count == N + 1) {
            ans.append(sb).append("\n");
            return ;
        }

        if (count == 0 || arr[count - 1] == '<') {
            for (int i = idx + 1; i < 10; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    backtracking(sb.append(i), i, visited);
                    sb.deleteCharAt(sb.length() - 1);
                    visited[i] = false;
                }
            }    
        } else {
            for (int i = 0; i < idx; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    backtracking(sb.append(i), i, visited);
                    sb.deleteCharAt(sb.length() - 1);
                    visited[i] = false;
                }
            }
        }
    }
}