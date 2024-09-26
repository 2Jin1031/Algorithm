import java.util.*;

public class Main {
    static int[] parent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();  
        int m = sc.nextInt();  
        int t = sc.nextInt();  

        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        List<Integer> truth = new ArrayList<>();
        for (int i = 0; i < t; i++) {
            truth.add(sc.nextInt());
        }

        List<List<Integer>> parties = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int partySize = sc.nextInt();
            List<Integer> party = new ArrayList<>();
            for (int j = 0; j < partySize; j++) {
                party.add(sc.nextInt());
            }
            parties.add(party);

            for (int j = 1; j < party.size(); j++) {
                union(party.get(0), party.get(j));
            }
        }

        boolean[] knowsTruth = new boolean[n + 1];
        for (int person : truth) {
            knowsTruth[find(person)] = true;
        }

        int answer = 0;
        for (List<Integer> party : parties) {
            if (!knowsTruth[find(party.get(0))]) {
                answer++;
            }
        }

        System.out.println(answer);
        sc.close();
    }

    public static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    public static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            parent[rootY] = rootX;
        }
    }
}