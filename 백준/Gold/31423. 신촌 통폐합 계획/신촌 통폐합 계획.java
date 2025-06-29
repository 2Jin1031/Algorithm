import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] names = new String[N + 1];
        int[] parent = new int[N + 1];
        int[] next = new int[N + 1];
        int[] tail = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            names[i] = br.readLine();
            parent[i] = i;
            tail[i] = i;
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int ra = find(parent, a);
            int rb = find(parent, b);

            next[tail[ra]] = rb;
            tail[ra] = tail[rb];
            parent[rb] = ra;
        }
        int root = find(parent, 1);
        StringBuilder sb = new StringBuilder();
            for (int i = root; i != 0; i = next[i]) {
                sb.append(names[i]);
            }
        System.out.print(sb);
    }

    private static int find(int[] parent, int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent, parent[x]);
    }
}