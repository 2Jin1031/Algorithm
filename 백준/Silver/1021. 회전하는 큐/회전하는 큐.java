import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 1; i < N + 1; i++) {
            deque.add(i);
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        int count = 0;
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            int value = iterator.next();
            boolean front = validateFrontPosition(deque, value);

            if (front) {
                while (true) {
                    int element = deque.peekFirst();
                    if (value == element) {
                        deque.pollFirst();
                        break;
                    }
                    deque.addLast(deque.pollFirst());
                    count++;
                }
            }
            else {
                while (true) {
                    int element = deque.peekLast();
                    if (value == element) {
                        deque.pollLast();
                        count++;
                        break;
                    }
                    deque.addFirst(deque.pollLast());
                    count++;
                }
            }
        }
        bw.write(count + "\n");
        bw.close();
        br.close();
    }

    private static boolean validateFrontPosition(Deque<Integer> deque, int value) {
        List<Integer> list = new ArrayList<>(deque);
        for (int i = 0; i < list.size() / 2 + 1; i++) {
            if (list.get(i) == value) {
                return true;
            }
        }
        return false;
    }
}