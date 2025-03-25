import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] count = new int[N];
        int sign = 1;
        count[0] = 1;
        int idx = 0;

        int loop = 0;
        while (true) {
            if (count[idx] >= M) {
                break;
            }
            if (count[idx] % 2 == 0) {
                sign = -1;
            } else {
                sign = 1;
            }
            
            idx = (idx + L * sign + N) % N; 
            count[idx]++;
            loop++;
        }
        System.out.println(loop);
    }
}