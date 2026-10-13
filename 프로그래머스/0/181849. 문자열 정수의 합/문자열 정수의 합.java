class Solution {
    public int solution(String num_str) {
        int answer = 0;
        char[] chars = num_str.toCharArray();

        for (int i = 0; i < num_str.length(); i++) {
            answer += Integer.parseInt(String.valueOf(chars[i]));
        }
        return answer;
    }
}