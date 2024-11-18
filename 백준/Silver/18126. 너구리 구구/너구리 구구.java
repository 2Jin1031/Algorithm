import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int dest;
        long weight;

        public Node(int dest, long weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        List<List<Node>> adj = new ArrayList<>(N);
        for (int i = 0; i < N + 1; i++) { // 1 base index
            adj.add(new ArrayList<Node>());
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long weight = Integer.parseInt(st.nextToken());
            adj.get(a).add(new Node(b, weight));
            adj.get(b).add(new Node(a, weight));
        }

        boolean[] visited = new boolean[N + 1];
        visited[1] = true;
        Queue<Node> queue = new ArrayDeque<>();
        for (Node node : adj.get(1)) {
            queue.offer(new Node(node.dest, node.weight));
        }

        long maxResult = 0;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int currentId = node.dest;
            long currentWeight = node.weight;
            if (maxResult < currentWeight) {
                maxResult = currentWeight;
            }
            for (Node nextNode : adj.get(currentId)) {
                int nextId = nextNode.dest;
                long addedWeight = nextNode.weight;
                if (!visited[nextId]) {
                    visited[nextId] = true;
                    queue.offer(new Node(nextId, currentWeight + addedWeight));
                }
            }
        }

        System.out.println(maxResult);
    }
}