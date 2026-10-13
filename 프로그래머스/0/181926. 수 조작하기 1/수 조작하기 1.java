class Solution {
    
    public int getNumFromStr(String str) {
        if (str.equals("w")) {
            return 1;
        } else if (str.equals("s")) {
            return -1;
        } else if (str.equals("d")) {
            return 10;
        } else if (str.equals("a")) {
            return -10;    
        }
        return -999;
    }    
    public int solution(int n, String control) {
        int answer = n;
        
        for (int i = 0; i < control.length(); i++) {
            String str = control.charAt(i) + "";
            int num = getNumFromStr(str);
            answer += num;
            
        }
        return answer;
    }
}