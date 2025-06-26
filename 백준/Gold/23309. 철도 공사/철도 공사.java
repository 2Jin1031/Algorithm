import java.io.*;
import java.util.*;

public class Main {

    private static final int MAX_ID = 1_000_000 + 1;
    private static final int[] next = new int[MAX_ID];
    private static final int[] prev = new int[MAX_ID];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int first = Integer.parseInt(st.nextToken());
        int before = first;
        int last = first;

        for (int i = 1; i < N; i++) {
            int cur = Integer.parseInt(st.nextToken());
            next[before] = cur;
            prev[cur] = before;
            before = cur;
            last = cur;
        }
        next[last] = first;
        prev[first] = last;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            int x = Integer.parseInt(st.nextToken());

            if (cmd.equals("BN")) {
                int y = Integer.parseInt(st.nextToken());
                int nx = next[x];
                sb.append(nx).append('\n');
                link(x, y, nx);
            } else if (cmd.equals("BP")) {
                int y = Integer.parseInt(st.nextToken());
                int pv = prev[x];
                sb.append(pv).append('\n');
                link(pv, y, x);
            } else if (cmd.equals("CN")) {
                int rm = next[x];
                sb.append(rm).append('\n');
                unlink(x, rm, next[rm]);
            } else if (cmd.equals("CP")) {
                int rm = prev[x];
                sb.append(rm).append('\n');
                unlink(prev[rm], rm, x);
            }
        }
        System.out.print(sb);
    }

    private static void link(int i, int j, int k) {
        next[i] = j;
        prev[j] = i;
        next[j] = k;
        prev[k] = j;
    }

    private static void unlink(int i, int rm, int k) {
        next[i] = k;
        prev[k] = i;
        next[rm] = prev[rm] = 0;
    }
}