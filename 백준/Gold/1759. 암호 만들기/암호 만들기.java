import java.io.*;
import java.util.*;

public class Main {

    private static int L, C;
    private static char[] arr;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new char[C];
        for (int i = 0; i < C; i++) {
            arr[i] = st.nextToken().charAt(0); // st.nextToken의 자료형 String 일 것 같은데
        }

        Arrays.sort(arr);

        backtracking(0, new boolean[C], 0, 0);
        System.out.print(sb);
    }

    private static void backtracking(int idx, boolean visited[], int jaCount, int moCount) {
        int totalCount = jaCount + moCount;
        if (totalCount >= L) {
            if (jaCount >= 2 && moCount >= 1) {
                for (int i = 0; i < C; i++) {
                    if (visited[i]) {
                        sb.append(arr[i]);
                    }
                }
                sb.append("\n");
            }
            return ;
        }

        for (int i = idx; i < C; i++) {
            visited[i] = true; 
            if (isMo(arr[i])) {
                backtracking(i + 1, visited, jaCount, moCount + 1);
            } else {
                backtracking(i + 1, visited, jaCount + 1, moCount);
            }
            visited[i] = false;  
        }
    }

    private static boolean isMo(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'o' || ch == 'u' || ch == 'i';
    }
}