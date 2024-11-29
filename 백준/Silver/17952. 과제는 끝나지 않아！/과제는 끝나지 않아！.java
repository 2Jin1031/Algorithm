import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Stack<int[]> stack = new Stack<>();
        int taskScore = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int isTask = Integer.parseInt(st.nextToken());

            if (isTask == 1) {
                int A = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());
                stack.push(new int[]{A, T});
            }

            if (!stack.isEmpty()) {
                int[] taskInfo = stack.pop();
                taskInfo[1]--;
                if (taskInfo[1] == 0) {
                    taskScore += taskInfo[0];
                } else {
                    stack.push(taskInfo);
                }
            }
        }

        bw.write(taskScore + "\n");
        bw.close();
        br.close();
    }
}