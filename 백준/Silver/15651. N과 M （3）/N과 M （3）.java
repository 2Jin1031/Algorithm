import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    private static int N, M;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] result = new int[M];
        backtrack(0, result);

        System.out.println(sb);



    }

    private static void backtrack(final int depth, final int[] result) {
        if (depth == M) {
            for (int num : result) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return ;
        }

        for (int i = 1; i <= N; i++) {
            result[depth] = i;
            backtrack(depth + 1, result);
        }
    }
}
