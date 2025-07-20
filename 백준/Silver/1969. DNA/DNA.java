import java.io.*;
import java.util.*;

public class Main {

    static final char[] BASES = {'A', 'C', 'G', 'T'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] dna = new String[N];
        for (int i = 0; i < N; i++) {
            dna[i] = br.readLine();
        }

        StringBuilder result = new StringBuilder();
        int totalDistance = 0;

        for (int i = 0; i < M; i++) {
            int[] count = new int[4]; 

            for (int j = 0; j < N; j++) {
                char c = dna[j].charAt(i);
                if (c == 'A') count[0]++;
                else if (c == 'C') count[1]++;
                else if (c == 'G') count[2]++;
                else if (c == 'T') count[3]++;
            }

            int max = -1;
            int idx = 0;
            for (int k = 0; k < 4; k++) {
                if (count[k] > max || (count[k] == max && BASES[k] < BASES[idx])) {
                    max = count[k];
                    idx = k;
                }
            }

            result.append(BASES[idx]);
            totalDistance += N - count[idx];
        }

        System.out.println(result);
        System.out.println(totalDistance);
    }
}