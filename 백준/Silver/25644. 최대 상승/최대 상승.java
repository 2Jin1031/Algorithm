import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        int minValue = arr[0];

        for (int i = 1; i < N; i++) {
            if (arr[i] > minValue) {
                max = Math.max(max, arr[i] - minValue);
            } else {
                minValue = arr[i];
            }
        }

        bw.write(max + "\n");

        bw.close();
        br.close();
    }
}