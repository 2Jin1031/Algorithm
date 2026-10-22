import java.util.*;

class Solution {
    
    public static List<List<Integer>> graph;
    public static int[] minPathCount;

    public int solution(int n, int[][] edge) {
        
        graph = new ArrayList<>();
        minPathCount = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
            minPathCount[i] = -1;
        }
        
        for (int[] rowEdge : edge) {
            int node1 = rowEdge[0];
            int node2 = rowEdge[1];
            List<Integer> rowGraph = graph.get(node1);
            rowGraph.add(node2);
            
            rowGraph = graph.get(node2);
            rowGraph.add(node1);
        }
        
        BFS();
        
        
        int maxCount = 0;
        int nodeCount = 0;
        for (int i = 2; i < n + 1; i++) {
            int pathCount = minPathCount[i];
            if (pathCount == -1) {
                continue;
            }

            if (maxCount < pathCount) {
                maxCount = pathCount;
                nodeCount = 1;
            } else if (maxCount == pathCount) {
                nodeCount++;
            }
        }
        return nodeCount;
    }

    public void BFS() {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{1, 0});
        
        while (!queue.isEmpty()) {
            int[] currentInfo = queue.poll();
            // System.out.println("currentInfo: " + Arrays.toString(currentInfo));
            
            int node = currentInfo[0];
            int currentCount = currentInfo[1];
            List<Integer> rowGraph = graph.get(node);
            // System.out.println(rowGraph);
            for (int nextNode : rowGraph) {
                if (minPathCount[nextNode] != -1) {
                    continue;
                }
                
                minPathCount[nextNode] = currentCount + 1;
                queue.offer(new int[]{nextNode, currentCount + 1});
            }
        }
    }
}