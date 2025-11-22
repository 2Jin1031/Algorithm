import java.util.*;

class Solution {
    public int solution(String s) {
        String[] str = s.split(" ");
        
        int ans = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i].equals("Z")) {
                ans -= Integer.parseInt(str[i - 1]);
                continue;
            } 
            ans += Integer.parseInt(str[i]);
        }
         
        return ans;
    }
}