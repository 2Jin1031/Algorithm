import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(input[0]); // 위치
            arr[i][1] = Integer.parseInt(input[1]); // 높이
        }

        Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));

        int maxHeigth = 0;
        int maxIdx = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i][1] > maxHeigth) {
                maxHeigth = arr[i][1];
                maxIdx = i;
            }
        }

        int sum = 0;

        int leftMaxHeight = arr[0][1];
        int leftMaxIdx = arr[0][0];
        for (int i = 1; i <= maxIdx; i++) {
            if (leftMaxHeight <= arr[i][1]) {
                sum += (arr[i][0] - leftMaxIdx) * leftMaxHeight;
                leftMaxHeight = arr[i][1];
                leftMaxIdx = arr[i][0];
            }
        }

        sum += maxHeigth;

        int rightMaxHeight = arr[N - 1][1];
        int rightMaxIdx = arr[N - 1][0];
        for (int i = N - 2; i >= maxIdx; i--) {
            if (rightMaxHeight <= arr[i][1]) {
                sum += (rightMaxIdx - arr[i][0]) * rightMaxHeight;
                rightMaxHeight = arr[i][1];
                rightMaxIdx = arr[i][0];
            }
        }

        bw.write(sum + "\n");

        bw.close();
        br.close();
    }
}