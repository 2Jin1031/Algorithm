import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            Queue<int[]> queue = new LinkedList<>();
            Integer[] importance = new Integer[N];
            int MIdx = M;
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int importanceLevel = Integer.parseInt(st.nextToken());
                queue.add(new int[]{importanceLevel, i});
                importance[i] = importanceLevel;
            }
            Arrays.sort(importance, Collections.reverseOrder());

            int importanceIdx = 0;
            int count = 0;
            while (true) {
                int[] current = queue.poll();
                if (current[0] == importance[importanceIdx]) {
                    count++;
                    if (current[1] == MIdx) {
                        break;
                    }
                    importanceIdx++;
                } else {
                    queue.add(current);
                }
            }
            bw.write(count + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}