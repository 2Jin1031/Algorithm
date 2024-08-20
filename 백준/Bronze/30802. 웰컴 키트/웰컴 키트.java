import java.io.*;
import java.util.*;

public class Main {
    private static int N, T, P;
    private static int[] T_size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        initialize(br);

        int T_bundle = 0, P_bundle = 0;

        for (int i = 0; i < 6; i++) {
            T_bundle += T_size[i] / T + (T_size[i] % T == 0 ? 0 : 1);
        }

        bw.write(T_bundle + "\n");

        P_bundle = N / P;
        int P_remainder = N % P;

        bw.write(P_bundle + " " + P_remainder + "\n");

        br.close();
        bw.close();
    }

    private static void initialize(BufferedReader br) throws IOException {
        T_size = new int[6];
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++) {
            T_size[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
    }
}