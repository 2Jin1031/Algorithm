import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

import static java.util.Arrays.sort;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        int[] B = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        sort(A);
        sort(B);

        int indexA = 0;
        int indexB = 0;
        int count = 0;
        while(indexA < N && indexB < M) {
            if (A[indexA] < B[indexB]) {
                indexA++;
            }
            else if (A[indexA] > B[indexB]) {
                indexB++;
            }
            else {
                count++;
                indexA++;
                indexB++;
            }
        }

        bw.write(N + M - 2 * count + "\n");

        bw.close();
        br.close();
    }
}