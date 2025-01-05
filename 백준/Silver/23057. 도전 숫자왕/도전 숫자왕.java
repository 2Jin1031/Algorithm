import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[] cards;
    static TreeSet<Integer> reachable;
    static int totalSum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        cards = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        totalSum = Arrays.stream(cards).sum();
        reachable = new TreeSet<>();

        dfs(0, 0);


        System.out.println(totalSum - reachable.size() + 1);
    }

    private static void dfs(int index, int currentSum) {
        if (index == N) {
            reachable.add(currentSum);
            return;
        }

        dfs(index + 1, currentSum);

        dfs(index + 1, currentSum + cards[index]);
    }
}