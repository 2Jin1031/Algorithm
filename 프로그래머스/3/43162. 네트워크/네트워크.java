import java.util.*;

class Solution {
    
    int[] parentNodes;
    
    public int solution(int n, int[][] computers) {
        parentNodes = new int[n];
        for (int i = 0; i < n; i++) {
            parentNodes[i] = i;
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int connection = computers[i][j];
                if (connection != 1) {
                    continue;
                }
                
                int node1 = i;
                int node2=  j;
                unionNodes(node1, node2);
            }
        }
        
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(findRootNode(i));
        }
        
        int answer = set.size();
        return answer;
    }
    
    public int findRootNode(int node) {
        while (parentNodes[node] != node) {
            parentNodes[node] = parentNodes[parentNodes[node]];
            node = parentNodes[node];
        }
        
        return parentNodes[node]; // 
    }
    
    public void unionNodes(int node1, int node2) {
        int root1 = findRootNode(node1);
        int root2 = findRootNode(node2);
        
        if (root1 == root2) return ;
        
        int minRoot = Math.min(root1, root2);
        int maxRoot = Math.max(root1, root2);
        
        parentNodes[maxRoot] = minRoot;
    }
}