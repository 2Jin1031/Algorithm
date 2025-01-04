import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.TreeSet;
import java.util.stream.Stream;

public class Main {

    private static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int ASize = Integer.parseInt(br.readLine());
            int[] A = new int[ASize];
            A = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int BSize = Integer.parseInt(br.readLine());
            int[] B = new int[BSize];
            B = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int CSize = Integer.parseInt(br.readLine());
            int[] C = new int[CSize];
            C = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            HashSet<Integer> set = new HashSet<>();
            int count = 0;
            for (int j = 0; j < ASize; j++) {
                for (int k = 0; k < BSize; k++) {
                    for (int l = 0; l < CSize; l++) {
                        int value = A[j] + B[k] + C[l];
                        if (isCoordinate(value)) {
                            if (!set.contains(value)) {
                                set.add(value);
                                count++;
                            }
                        }
                    }
                }
            }
            System.out.println(count);
        }

    }

    private static boolean isCoordinate(int value) {

        while (value > 0) {
            int digit = value % 10;
            if (digit != 5 && digit != 8) {
                return false;
            }
            value /= 10;
        }
        return true;
    }
}