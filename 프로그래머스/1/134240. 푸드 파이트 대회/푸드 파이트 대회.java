class Solution {
    public String solution(int[] food) {
        
        String half = "";
        
        for (int i = 1; i < food.length; i++) {
            int count = food[i] / 2;
            for (int j = 0; j < count; j++) {
                half += i;
            }
        }
        
        String ans  = half + "0";
        for (int i = half.length() - 1; i >= 0; i--) {
            ans += half.charAt(i) + "";
        }
        
        
        return ans;
    }
}