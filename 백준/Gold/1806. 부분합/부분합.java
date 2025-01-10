import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int N, S;
    private static int[] arr;
    private static int[] sumArr;

    public static void main(String[] args) throws IOException {

        initialize();

        int endIdx = 1, minLength = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            if (endIdx < i) {
                endIdx = i;
            }
            if (sumArr[endIdx - 1] - sumArr[i - 1] < S && sumArr[endIdx] - sumArr[i - 1] >= S) { // endPoint 찾음

            } else if (sumArr[endIdx] - sumArr[i - 1] < S) { // 부족하면
                endIdx = binarySearch(i - 1, endIdx + 1, N);
            } else { // 넘치면
                endIdx = binarySearch(i - 1, i + 1, endIdx - 1);
            }
            if (endIdx != -1) {
            minLength = Math.min(minLength, endIdx - i + 1);
            }
        }
        if (minLength == Integer.MAX_VALUE) {
            minLength = 0;
        }
        System.out.println(minLength);
    }

    private static void initialize() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];
        sumArr = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        int sum = 0;
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
            sumArr[i] = sum;
        }
    }

    private static int binarySearch(int startSum, int start, int end) {
        int mid;

        int targetSum = S + sumArr[startSum];

        while (start <= end) {
            mid = (start + end) / 2;
            if (sumArr[mid - 1] < targetSum && sumArr[mid] >= targetSum) {
                return mid;
            }

            if (sumArr[mid] < targetSum) { // 찾는 것보다 작으면
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        return -1;
    }
}