import java.io.*;
import java.util.*;

public class Main {
    private static int N, M;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (isSameParentCheck(v)) {
                unionParent(a, b);
            }
            else {
                if (findParent(a) == findParent(b)) {
                    bw.write("YES\n");
                }
                else {
                    bw.write("NO\n");
                }
            }
        }


        bw.flush();
        bw.close();
        br.close();
    }

    private static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);

        if (a < b) {
            arr[b] = a;
        }
        else {
            arr[a] = b;
        }
    }

    private static boolean isSameParentCheck(int v) {
        return v == 0;
    }

    private static int findParent(int a) {
        if (arr[a] == a) {
            return a;
        }
        return arr[a] = findParent(arr[a]);
    }
}