import java.util.*;

class Solution {
    
    private static int ans = 0;
    private static int[] arr;

    public int solution(int[] number) {
        arr = number;
        dfs(0, 0, 0);
        
        return ans;
    }
    
    private void dfs(int count, int sum, int idx) {
        if (count > 3 || idx > arr.length) {
            return ;
        } else if (count == 3) {
            if (sum == 0) {
                ans++;    
            }
            return ;
        }
        
        for (int i = idx; i < arr.length; i++) {
            dfs(count + 1, sum + arr[i], i + 1);
        }
    }
}