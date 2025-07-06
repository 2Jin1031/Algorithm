import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int T = Integer.parseInt(br.readLine());
        Deque<Integer> dq = new ArrayDeque<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N * 2; i++) {
            dq.addLast(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < T; i++) {
            int num = Integer.parseInt(st.nextToken());
            while (--num > 0) {
                dq.addLast(dq.removeFirst());
            }
            System.out.printf(dq.getFirst() + " ");
        }
    }
}