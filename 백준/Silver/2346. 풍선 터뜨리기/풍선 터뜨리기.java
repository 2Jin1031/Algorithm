import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        ArrayDeque<int[]> deque = new ArrayDeque<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            deque.add(new int[]{Integer.parseInt(st.nextToken()), i + 1});
        }

        while (!deque.isEmpty()) {
            int[] current = deque.pollFirst();
            int value = current[0];
            bw.write(current[1] + " ");
            bw.flush();  // 데이터를 즉시 출력하여 메모리 누적 방지

            if (deque.isEmpty()) {
                break;
            }

            if (value > 0) {
                for (int i = 0; i < value - 1; i++) {
                    deque.addLast(deque.pollFirst());
                }
            } else {
                for (int i = 0; i < Math.abs(value); i++) {
                    deque.addFirst(deque.pollLast());
                }
            }
        }
        bw.close();
        br.close();
    }
}