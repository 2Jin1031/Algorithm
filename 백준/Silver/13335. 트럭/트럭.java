import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < W - 1; i++) {
            queue.add(-1);
        }
        int idx = 0;
        queue.add(arr[idx]);

        int timeCount = 0;
        int currentWeight = arr[idx++];
        while (!queue.isEmpty() && idx < N) {
            Integer currentTruck = queue.poll();
            timeCount++;
            if (currentTruck != -1) { // 트럭 한 대가 다리를 빠져나옴
                currentWeight -= currentTruck;
            }
            int nextTruck = arr[idx];
            int remainingWeight = L - currentWeight;
            if (nextTruck <= remainingWeight) {
                queue.add(arr[idx++]);
                currentWeight += nextTruck;
            } else {
                queue.add(-1);
            }
        }

        bw.write(timeCount + queue.size() + 1 + "\n");
        bw.close();
        br.close();
    }
}