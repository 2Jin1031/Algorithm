import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N, M;
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Queue<Deque<Integer>> bookDummy = new LinkedList<>();
        Map<Integer, Deque<Integer>> topTracker = new HashMap<>();

        for (int i = 0; i < M; i++) {
            int count = Integer.parseInt(br.readLine());
            Deque<Integer> books = new ArrayDeque<>();
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < count; j++) {
                books.addFirst(Integer.parseInt(st.nextToken()));
            }
            bookDummy.add(books);
            if (!books.isEmpty()) {
                topTracker.put(books.peekFirst(), books);
            }
        }

        int idx = 1;
        boolean flag = true;

        while (idx <= N) {
            if (topTracker.containsKey(idx)) {
                Deque<Integer> targetStack = topTracker.get(idx);
                targetStack.pollFirst(); // 스택에서 제거
                if (targetStack.isEmpty()) {
                    topTracker.remove(idx);
                } else {
                    topTracker.put(targetStack.peekFirst(), targetStack);
                }
                idx++;
            } else {
                flag = false;
                break;
            }
        }

        bw.write(flag ? "Yes" : "No");
        bw.close();
        br.close();
    }
}