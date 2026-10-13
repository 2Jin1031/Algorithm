class Solution {
    public int solution(int[][] signals) {
        int n = signals.length;
        
        // infos[i] = { 노랑 시작(포함), 노랑 끝(미포함), 주기 }
        // 위치 p = (t-1) % T 가 [G, G+Y) 안에 있으면 노란불
        int[][] infos = new int[n][3];
        long lcm = 1;
        for (int i = 0; i < n; i++) {
            int g = signals[i][0];
            int y = signals[i][1];
            int r = signals[i][2];
            int period = g + y + r;
            infos[i][0] = g;        // 노랑 min (포함)
            infos[i][1] = g + y;    // 노랑 max (미포함)
            infos[i][2] = period;   // 주기
            lcm = lcm(lcm, period);
        }
        
        // t = 1 부터 lcm 까지 한 주기만 확인하면 충분
        for (long t = 1; t <= lcm; t++) {
            boolean allYellow = true;
            for (int i = 0; i < n; i++) {
                int p = (int) ((t - 1) % infos[i][2]);
                if (!(infos[i][0] <= p && p < infos[i][1])) {
                    allYellow = false;
                    break;
                }
            }
            if (allYellow) return (int) t;
        }
        
        return -1;
    }
    
    private long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }
    
    private long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}