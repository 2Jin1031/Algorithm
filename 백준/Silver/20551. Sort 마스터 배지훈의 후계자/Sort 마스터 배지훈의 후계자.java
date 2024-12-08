import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N, M;
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            arr.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(arr);

        for (int i = 0; i < M; i++) {
            int value = Integer.parseInt(br.readLine());
            int result = binarySearchFirstIndex(arr, value);

            if (result == -1) {
                bw.write("-1\n");
            } else {
                bw.write(result + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static int binarySearchFirstIndex(List<Integer> arr, int target) {
        int left = 0, right = arr.size() - 1;
        int result = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr.get(mid) >= target) {
                right = mid - 1; 
            } else {
                left = mid + 1;
            }

            if (arr.get(mid) == target) {
                result = mid;
            }
        }

        return result; 
    }
}