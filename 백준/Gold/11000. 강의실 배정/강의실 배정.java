import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        // 수업 정보 저장: [시작 시간, 종료 시간]
        int[][] classes = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            classes[i][0] = Integer.parseInt(st.nextToken()); // 시작 시간
            classes[i][1] = Integer.parseInt(st.nextToken()); // 종료 시간
        }

        // 시작 시간을 기준으로 수업 정렬
        Arrays.sort(classes, (a, b) -> a[0] - b[0]);

        // 우선순위 큐를 사용해 강의실의 끝나는 시간을 관리
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int start = classes[i][0];
            int end = classes[i][1];

            // 가장 빨리 끝나는 시간보다 현재 수업이 시작할 수 있으면 강의실 재사용
            if (!pq.isEmpty() && pq.peek() <= start) {
                pq.poll();
            }

            // 현재 수업의 종료 시간을 큐에 추가
            pq.offer(end);
        }

        // 큐에 남아있는 종료 시간의 개수가 필요한 강의실 수
        bw.write(pq.size() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}