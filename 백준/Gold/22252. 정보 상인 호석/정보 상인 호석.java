import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.TreeSet;
import java.util.stream.Stream;

public class Main {

    private static int T;
    private static HashMap<String, PriorityQueue<Integer>> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        map = new HashMap<>();

        long result = 0;
        for (int i = 0; i < T; i++) {
            String[] input = br.readLine().split(" ");
            int command = Integer.parseInt(input[0]);
            String name = input[1];

            if (command == 1) { // Add
                for (int j = 3; j < input.length; j++) {
                    int score = Integer.parseInt(input[j]);
                    map.putIfAbsent(name, new PriorityQueue<>(Comparator.reverseOrder()));
                    map.get(name).add(score);
                }
            } else if (command == 2) { // Remove
                int count = Integer.parseInt(input[2]);
                if (map.containsKey(name)) {
                    PriorityQueue<Integer> scores = map.get(name);
                    for (int j = 0; j < count; j++) {
                        if (!scores.isEmpty()) {
                            result += scores.poll();
                        } else {
                            break; // 더 이상 삭제할 값이 없으면 중단
                        }
                    }
                    if (scores.isEmpty()) {
                        map.remove(name);
                    }
                }
            }
        }

        System.out.println(result);

    }

}