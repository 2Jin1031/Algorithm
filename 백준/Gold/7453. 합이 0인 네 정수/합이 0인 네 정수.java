import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());

        int[] A = new int[N];
        int[] B = new int[N];
        int[] C = new int[N];
        int[] D = new int[N];

        for (int i = 0; i < N; i++) {
            String[] input = reader.readLine().split(" ");
            A[i] = Integer.parseInt(input[0]);
            B[i] = Integer.parseInt(input[1]);
            C[i] = Integer.parseInt(input[2]);
            D[i] = Integer.parseInt(input[3]);
        }

        int[] AB = new int[N * N];
        int index = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                AB[index++] = A[i] + B[j];
            }
        }

        int[] CD = new int[N * N];
        index = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                CD[index++] = C[i] + D[j];
            }
        }

        Arrays.sort(AB);

        long count = 0;
        for (int value : CD) {
            int target = -value;
            count += upperBound(AB, target) - lowerBound(AB, target);
        }

        System.out.println(count);
    }

    private static int lowerBound(int[] array, int target) {
        int left = 0, right = array.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private static int upperBound(int[] array, int target) {
        int left = 0, right = array.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (array[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}