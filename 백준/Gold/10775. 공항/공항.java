import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int G = Integer.parseInt(br.readLine());
        int[] gArr = new int[G + 1];
        for (int i = 1; i <= G; i++) {
            gArr[i] = i;
        }
        int P = Integer.parseInt(br.readLine());
        int[] pArr = new int[P];
        for (int i = 0; i < P; i++) {
            pArr[i] = Integer.parseInt(br.readLine());
        }

        int[] parent = new int[G + 1];
        for (int i = 1; i <= G; i++) {
            parent[i] = i;
        }

        int result = 0;
        for (int i = 0; i < P; i++) {
            int gate = pArr[i];
            int root = find(parent, gate);
            if (root == 0) {
                break;
            }
            union(parent, root, root - 1);
            result++;
        }

        System.out.println(result);
    }

    public static int find(int[] parent, int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent, parent[x]);
    }

    public static void union(int[] parent, int a, int b) {
        a = find(parent, a);
        b = find(parent, b);
        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }
}