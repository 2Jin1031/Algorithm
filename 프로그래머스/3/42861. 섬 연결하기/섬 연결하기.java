import java.util.*;

class Solution {
    
    int[] parentNodes;
    
    public int solution(int n, int[][] costs) {
        parentNodes = new int[n];
        for (int i = 0; i < n; i++) {
            parentNodes[i] = i;
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        for (int i = 0; i < costs.length; i++) {
            int[] cost = costs[i];
            int price = cost[2];
            
            pq.offer(new int[]{price, i});
        }
        
        int nodeCount = 0;
        int sumPrice = 0;
        while (!pq.isEmpty() && nodeCount < n - 1) {
            int[] e = pq.poll();
            int price = e[0];
            int i = e[1];

            int[] cost = costs[i];
            int node1 = cost[0];
            int node2 = cost[1];
            
            int root1 = findRootNode(node1);
            int root2 = findRootNode(node2);
            
            if (root1 == root2) {
                continue;
            }
            
            unionNodes(root1, root2);
            nodeCount++;
            sumPrice += price;
        } 
        
        
        return sumPrice;
    }
    
    public void unionNodes(int root1, int root2) {
        int minRoot = Math.min(root1, root2);
        int maxRoot = Math.max(root1, root2);
        
        parentNodes[maxRoot] = minRoot;
    }
    
    public int findRootNode(int node) {
        while (parentNodes[node] != node) {
            parentNodes[node] = parentNodes[parentNodes[node]];
            node = parentNodes[node];
        }
        
        return parentNodes[node];
    }
}