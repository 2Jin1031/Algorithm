import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int size = Integer.parseInt(br.readLine());
            String[] inputs = br.readLine().split(" ");
            Deque<String> deque = new ArrayDeque<>();
            for (String input : inputs) {
                if (deque.isEmpty() || deque.peekFirst().compareTo(input) < 0) {
                    deque.add(input);
                } else {
                    deque.addFirst(input);
                }
            }
            while (!deque.isEmpty()) {
                bw.write(deque.pollFirst());
            }
            bw.write("\n");
        }

        bw.close();
        br.close();
    }
}