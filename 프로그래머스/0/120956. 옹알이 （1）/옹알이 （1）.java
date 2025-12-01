class Solution {
    private static String[] str = {"aya", "ye", "woo", "ma"};

    public int solution(String[] babbling) {
        int answer = 0;
        
        for (int i = 0; i < babbling.length; i++) {
            if (isCorrect(babbling[i])) {
                answer++;
            }
        }
        return answer;
    }
    
    private boolean isCorrect(String word) {
        String tmp = word;
        int idx = 0;
        while (idx < str.length) {
            boolean result = tmp.startsWith(str[idx]);
            if (result) {
                tmp = tmp.substring(str[idx].length());
                idx = 0;
            } else {
                idx++;
            }
        }
        return tmp.length() == 0;
    }
}