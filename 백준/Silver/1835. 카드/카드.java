import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        Deque<String> deque = new ArrayDeque<>();
        for (int i = 1; i < N + 1; i++) {
            deque.add(String.valueOf(i));
        }

        int loop = 1;
        while (!deque.isEmpty()) {
            for (int i = 0; i < loop; i++) {
                deque.addLast(deque.pollFirst());
            }
            String str = deque.pollFirst();
            map.put(str, loop++);
        }

        // print
        for (int i = 1; i < N + 1; i++) {
            bw.write(map.get(String.valueOf(i)) + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}