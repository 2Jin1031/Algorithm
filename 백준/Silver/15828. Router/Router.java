import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new ArrayDeque<>(N);
        while(true) {
            int num = Integer.parseInt(br.readLine());
            if (num == -1) break;
            
            if (num == 0) {
                queue.poll();
                continue;
            }
                
            if (queue.size() >= N) {
                continue;
            }

            queue.add(num);
        }

        if (queue.isEmpty()) {
            System.out.println("empty");
        } else {
            while (!queue.isEmpty()) {
                System.out.print(queue.poll() + " ");
            }
        }
    }
}