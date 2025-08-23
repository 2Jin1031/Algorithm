import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] arr = new int[11][2];
        for (int i = 0; i < 11; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));

        int ans = 0;
        int sumD = 0;
        for (int i = 0; i < 11; i++) {
            sumD += arr[i][0];
            ans += sumD + 20* arr[i][1];
        }
        System.out.println(ans);
    }
}
