import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Queue<String> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            queue.add(br.readLine());
        }

        int count = 0;
        for (int i = 1; i <= N; i++) {
            String afterName = br.readLine();
            if (!afterName.equals(queue.peek())) {
                count++;
                queue.remove(afterName);
            }
            if (Objects.equals(queue.peek(), afterName))
                queue.remove(afterName);
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}