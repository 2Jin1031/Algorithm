import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        HashMap<Integer, Integer> map = new HashMap<>();
        Queue<int[]> queue = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            queue.add(new int[]{i, Integer.parseInt(st.nextToken())});
        }

        int loopCount = 0;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentPerson = current[0];
            int currentCount = current[1];

            current[1] = currentCount - 1; // 먹기
            loopCount++;

            if (current[1] == 0) { // 다 먹음
                arr[currentPerson] = loopCount;
            }
            else { // 다 못먹음
                queue.add(current);
            }
        }

        for (int i = 0; i < N; i++) {
            bw.write(arr[i] + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}