import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new java.io.OutputStreamWriter(System.out));

        PriorityQueue<Integer> set = new PriorityQueue<>(Collections.reverseOrder());
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int instruction = Integer.parseInt(input[0]);
            if (instruction == 0) {
                if (set.isEmpty()) {
                    bw.write("-1\n");
                } else {
                    bw.write(set.poll() + "\n");
                }
                continue;
            }
            for (int j = 1; j < instruction + 1; j++) {
                set.add(Integer.parseInt(input[j]));
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}