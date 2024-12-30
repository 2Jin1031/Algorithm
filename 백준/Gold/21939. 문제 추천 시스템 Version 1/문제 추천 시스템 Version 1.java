import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {
    private static TreeMap<Integer, TreeSet<Integer>> recommendBook;
    private static HashMap<Integer, Integer> problemLevel;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        recommendBook = new TreeMap<>(Comparator.reverseOrder());
        problemLevel = new HashMap<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int problemNumber = Integer.parseInt(st.nextToken());
            int level = Integer.parseInt(st.nextToken());
            addProblem(level, problemNumber);
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            String[] arguments = br.readLine().split(" ");
            if (arguments[0].equals("add")) {
                int problemNumber = Integer.parseInt(arguments[1]);
                int level = Integer.parseInt(arguments[2]);
                addProblem(level, problemNumber);
            } else if (arguments[0].equals("recommend")) {
                int recommend = Integer.parseInt(arguments[1]);
                if (recommend == 1) {
                    System.out.println(recommendBook.firstEntry().getValue().first());
                } else { // recommend == -1
                    System.out.println(recommendBook.lastEntry().getValue().last());

                }
            } else if (arguments[0].equals("solved")) {
                int problemNumber = Integer.parseInt(arguments[1]);
                recommendBook.get(problemLevel.get(problemNumber)).remove(problemNumber);
                if (recommendBook.get(problemLevel.get(problemNumber)).isEmpty()) {
                    recommendBook.remove(problemLevel.get(problemNumber));
                }
                problemLevel.remove(problemNumber);
            }

        }
    }

    private static void addProblem(int level, int problemNumber) {
        if (!recommendBook.containsKey(level)) {
            recommendBook.put(level, new TreeSet<>(Comparator.reverseOrder()));
        }
        recommendBook.get(level).add(problemNumber);
        problemLevel.put(problemNumber, level);
    }
}