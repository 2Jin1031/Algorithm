import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    private static int N, K, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Deque<Integer> dq = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            dq.add(i);
        }

        int moveCount = 1;
        int deleteCount = 0;

        while (!dq.isEmpty()) {
            if (deleteCount == M) {
                deleteCount = 0;
                reverseDeque(dq);
                continue;
            }

            if (moveCount == K) {
                moveCount = 1;
                deleteCount++;
                bw.write(dq.poll() + "\n");
                continue;
            }
            if (moveCount < K) {
                dq.addLast(dq.poll());
                moveCount++;
            }
        }

        bw.close();
        br.close();
    }

    private static void reverseDeque(Deque<Integer> dq) {
        Deque<Integer> temp = new LinkedList<>();
        while (!dq.isEmpty()) {
            temp.add(dq.pollLast());
        }
        dq.addAll(temp);
    }
}