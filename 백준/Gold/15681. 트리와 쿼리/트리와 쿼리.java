import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static int N, R, Q;
    private static List<List<Integer>> tree;
    private static int[] subTree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        tree = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            tree.add(new ArrayList<>());
        }

        subTree = new int[N + 1];

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree.get(a).add(b);
            tree.get(b).add(a);
        }

        dfs(R, -1);

        for (int i = 0; i < Q; i++) {
            int node = Integer.parseInt(br.readLine());
            System.out.println(subTree[node]);
        }
    }

    private static int dfs(int node, int parent) {
        if (subTree[node] != 0) {
            return subTree[node];
        }
        subTree[node] = 1;
        for (int child : tree.get(node)) {
            if (child != parent) {
                subTree[node] += dfs(child, node);
            }
        }
        return subTree[node];
    }
}