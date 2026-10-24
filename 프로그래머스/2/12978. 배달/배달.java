import java.util.*;

class Solution {
    
    // int[] parentNodes;
    int[] cheapestPrices;
    
    List<List<int[]>> connectionNodeGroups;
    PriorityQueue<int[]> pq;
    
    public int solution(int N, int[][] road, int K) {
        // parentNodes = new int[N + 1];
        cheapestPrices = new int[N + 1];
        connectionNodeGroups = new ArrayList<>();
        pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        for (int i = 0; i < N + 1; i++) {
            // parentNodes[i] = i;
            cheapestPrices[i] = -1;
            connectionNodeGroups.add(new ArrayList<>());
        } cheapestPrices[1] = 0;

        for (int[] pathInfo : road) {
            int node1 = pathInfo[0];
            int node2 = pathInfo[1];
            int price = pathInfo[2];
            
            connectionNodeGroups.get(node1).add(new int[]{node2, price});
            connectionNodeGroups.get(node2).add(new int[]{node1, price});
        }
        
        updatePq(1);

        while(!pq.isEmpty()) {
            int[] e = pq.poll();
            int resultPrice = e[0];
            int rawPrice = e[1];
            int srcNode = e[2];
            int destNode = e[3];
            
            if (resultPrice > K) {
                break;
            }
            

            if (rawPrice == -1 || resultPrice < rawPrice) { // 업데이트 된 거였으면
                updatePq(destNode);

            }

            System.out.println();
        }
        
        int count = 0;
        for (int i = 1; i < N + 1; i++) {
            if (cheapestPrices[i] != -1 && cheapestPrices[i] <= K) {
                count++;
            }
        }

        return count;
    }
    
    public void updatePq(int srcNode) {
        List<int[]> connectionNodes = connectionNodeGroups.get(srcNode);
        for (int i = 0; i < connectionNodes.size(); i++) {
            int[] connectionNode = connectionNodes.get(i);
            int destNode = connectionNode[0];
            int pathPrice = connectionNode[1];

            int resultPrice = updatePrice(srcNode, destNode, pathPrice);
            int rawPrice = cheapestPrices[destNode];
            if (rawPrice == -1 || resultPrice < rawPrice) { // 업데이트 된 거였으면
                cheapestPrices[destNode] = resultPrice;
                pq.offer(new int[]{resultPrice, rawPrice, srcNode, destNode});
            }
            
        }
    }
    
    public int updatePrice(int srcNode, int destNode, int price) {
        if (cheapestPrices[destNode] == -1) {
            return cheapestPrices[srcNode] + price;
        }
        return Math.min(cheapestPrices[srcNode] + price, cheapestPrices[destNode]);
    }
}