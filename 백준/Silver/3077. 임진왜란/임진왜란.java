import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] A = br.readLine().split(" ");
        String[] B = br.readLine().split(" ");


        Map<String, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            indexMap.put(B[i], i);
        }

        int correctPairs = 0;
        int totalPairs = N * (N - 1) / 2;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                String x = A[i];
                String y = A[j];


                if (indexMap.get(x) < indexMap.get(y)) {
                    correctPairs++;
                }
            }
        }

        System.out.println(correctPairs + "/" + totalPairs);
    }
}