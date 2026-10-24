import java.util.*;

class Solution {
    
    int n;
    int[][] cheapestPriceGroups;
    int[] cheapestPriceGroup;
    List<List<int[]>> connectionNodeGroups;
    PriorityQueue<int[]> pq;
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        this.n = n;
        cheapestPriceGroups = new int[n + 1][n + 1];
        connectionNodeGroups = new ArrayList<>();
        pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[3], o2[3]));
        
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                cheapestPriceGroups[i][j] = -1;
            }
            cheapestPriceGroups[i][i] = 0;
            connectionNodeGroups.add(new ArrayList<>());
        }
        
        for (int i = 0; i < fares.length; i++) {
            int[] fare = fares[i];
            int node1 = fare[0];
            int node2 = fare[1];
            int price = fare[2];
            connectionNodeGroups.get(node1).add(new int[]{node2, price});
            connectionNodeGroups.get(node2).add(new int[]{node1, price});
        }
        
        for (int i = 1; i < n + 1; i++) {
            if (i != s && i != a && i != b) continue;
            cheapestPriceGroup = cheapestPriceGroups[i];
            updatePq(i);
            while(!pq.isEmpty()) {
                int[] e = pq.poll();
                int srcNode = e[0];
                int destNode = e[1];
                int rawPrice = e[2];
                int finalPrice = e[3];
              
                updatePq(destNode);
            
            }
        }
        
        
        int minCost = Integer.MAX_VALUE;
        for (int i = 1; i < n + 1; i++) {
            // 1. 같이 가는 경로 찾기
            int sameWayPrice = cheapestPriceGroups[s][i];
            int aWayPrice = cheapestPriceGroups[a][i];
            int bWayPrice = cheapestPriceGroups[b][i];
            
            if (sameWayPrice == -1 || aWayPrice == -1 || bWayPrice == -1) {
                continue;
            }
            
            int totalCost = sameWayPrice + aWayPrice + bWayPrice;
            minCost = Math.min(minCost, totalCost);
        }
        
        return minCost;
    }
    
    public void updatePq(int idx) {
        List<int[]> connectionNodeGroup = connectionNodeGroups.get(idx);
        for (int[] connectionNode : connectionNodeGroup) {
            int endNode = connectionNode[0];
            int price = connectionNode[1];

            int rawPrice = cheapestPriceGroup[endNode];
            int newPrice = cheapestPriceGroup[idx] + price;
            
            int finalPrice = getMinPrice(rawPrice, newPrice);
            cheapestPriceGroup[endNode] = finalPrice;
            if (rawPrice == -1 || rawPrice != finalPrice) { // 업데이트 된 것
                pq.offer(new int[]{idx, endNode, rawPrice, finalPrice}); 
            }    
            
        }
    }
    
    public int getMinPrice(int rawPrice, int newPrice) {
        if (rawPrice == -1) {
            return newPrice;
        }
        return Math.min(rawPrice, newPrice);
    }
}