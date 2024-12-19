import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        List<Queue<String>> queueList = new ArrayList<>();
        int totalWords = 0;

        for (int i = 0; i < N; i++) {
            Queue<String> queue = new LinkedList<>();
            String[] split = br.readLine().split(" ");
            queue.addAll(List.of(split));
            totalWords += split.length;
            queueList.add(queue);
        }

        String[] srcList = br.readLine().split(" ");
        if (srcList.length > totalWords) {
            bw.write("Impossible");
        } else {
            boolean b = possibleCheck(srcList, queueList);
            if (b && allQueuesEmpty(queueList)) {
                bw.write("Possible");
            } else {
                bw.write("Impossible");
            }
        }

        bw.close();
        br.close();
    }

    private static boolean possibleCheck(String[] srcList, List<Queue<String>> queueList) {
        for (String srcValue : srcList) {
            boolean findValue = false;
            for (Queue<String> queue : queueList) {
                if (!queue.isEmpty() && srcValue.equals(queue.peek())) {
                    queue.poll();
                    findValue = true;
                    break;
                }
            }
            if (!findValue) {
                return false;
            }
        }
        return true;
    }

    private static boolean allQueuesEmpty(List<Queue<String>> queueList) {
        for (Queue<String> queue : queueList) {
            if (!queue.isEmpty()) {
                return false;
            }
        }
        return true;
    }
}