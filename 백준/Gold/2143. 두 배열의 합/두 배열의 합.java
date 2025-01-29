import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static int T, N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());
        List<Integer> A = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A.add(Integer.parseInt(st.nextToken()));
        }
        M = Integer.parseInt(br.readLine());
        List<Integer> B = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B.add(Integer.parseInt(st.nextToken()));
        }

        List<Integer> sumA = new ArrayList<>();
        List<Integer> sumB = new ArrayList<>();
        sumA.add(0);
        sumB.add(0);

        int sum = 0;
        for (int i = 0; i < N; i++) {
            sumA.add(sum += A.get(i));
        }

        sum = 0;
        for (int i = 0; i < M; i++) {
            sumB.add(sum += B.get(i));
        }

        long answer = getAnswer(sumA, sumB);
        System.out.println(answer);
    }

    private static long getAnswer(List<Integer> sumA, List<Integer> sumB) {
        HashMap<Integer, Integer> mapA = new HashMap<>();
        for (int i = 1; i < sumA.size(); i++) {
            for (int j = 0; j < i; j++) {
                int sum = sumA.get(i) - sumA.get(j);
                mapA.put(sum, mapA.getOrDefault(sum, 0) + 1);
            }
        }
        HashMap<Integer, Integer> mapB = new HashMap<>();
        for (int i = 1; i < sumB.size(); i++) {
            for (int j = 0; j < i; j++) {
                int sum = sumB.get(i) - sumB.get(j);
                mapB.put(sum, mapB.getOrDefault(sum, 0) + 1);
            }
        }

        long answer = 0;
        for (int key : mapA.keySet()) {
            answer += (long) mapA.get(key) * mapB.getOrDefault(T - key, 0);
        }
        return answer;
    }
}