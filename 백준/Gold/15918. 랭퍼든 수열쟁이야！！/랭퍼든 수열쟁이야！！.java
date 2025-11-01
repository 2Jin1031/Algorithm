import java.io.*;
import java.util.*;

public class Main {

    private static int N, X, Y;
    private static int arrLength;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        arrLength = 2 * N;
        int ans = backtracking(new int[arrLength], new boolean[N + 1], 0);
        System.out.println(ans);
    }

    // arr : 만들어 나가는 수열, visited: 사용한 숫자 표기, idx: 진행 중인 인덱스
    private static int backtracking(int[] arr, boolean[] visited, int idx) {
        while (idx < arrLength && arr[idx] != 0) {
            idx++;
        }
    
        if (idx == arrLength) {
            return (arr[X-1] == arr[Y-1]) ? 1 : 0;
        }

        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (!visited[i] && idx + i + 1 < arrLength && arr[idx + i + 1] == 0) {
                visited[i] = true;
                arr[idx] = i;
                arr[idx + i + 1] = i;
                count += backtracking(arr, visited, idx + 1);
                visited[i] = false;
                arr[idx] = 0;
                arr[idx + i + 1] = 0;
            }
        }

        return count;
    }
}

