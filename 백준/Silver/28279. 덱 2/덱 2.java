import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.*;

public class Main {
    private static Deque<Integer> deque;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        deque = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            process(input);
        }
        br.close();
    }

    private static void process(String[] input) {
        int command = Integer.parseInt(input[0]);
        int num;
        switch (command) {
            case 1:
                num = Integer.parseInt(input[1]);
                deque.addFirst(num);
                break;
            case 2:
                num = Integer.parseInt(input[1]);
                deque.addLast(num);
                break;
            case 3:
                if (deque.isEmpty()) {
                    System.out.println("-1");
                } else {
                    System.out.println(deque.pollFirst());
                }
                break;
            case 4:
                if (deque.isEmpty()) {
                    System.out.println("-1");
                } else {
                    System.out.println(deque.pollLast());
                }
                break;
            case 5:
                System.out.println(deque.size());
                break;
            case 6:
                if (deque.isEmpty()) {
                    System.out.println("1");
                } else {
                    System.out.println("0");
                }
                break;
            case 7:
                if (deque.isEmpty()) {
                    System.out.println("-1");
                } else {
                    System.out.println(deque.peekFirst());
                }
                break;
            case 8:
                if (deque.isEmpty()) {
                    System.out.println("-1");
                } else {
                    System.out.println(deque.peekLast());
                }
                break;
        }
    }
}