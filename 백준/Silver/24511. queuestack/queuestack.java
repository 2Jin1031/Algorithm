import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        boolean[] visited = new boolean[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            visited[i] = Integer.parseInt(st.nextToken()) == 0;
        }

        Deque<Integer> deque = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(st.nextToken());
            if (visited[i]) {
                deque.addLast(value);
            }
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            int value = Integer.parseInt(st.nextToken());
            deque.addFirst(value);         
            int lastValue = deque.pollLast(); 
            bw.write(lastValue + " ");   
        }

        bw.close();
        br.close();
    }
}