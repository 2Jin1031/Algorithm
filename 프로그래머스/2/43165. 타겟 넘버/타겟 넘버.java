class Solution {
    
    int N, T;
    int answer;
    
    public int solution(int[] numbers, int target) {
        N = numbers.length;
        T = target;
        
        DFS(numbers, 0, 0);
        
        return answer;
    }
    
    public void DFS(int[] numbers, int idx, int result) {
        if (idx >= N) {
            if (result == T) {
                answer++;
            }
            return ;
        }
        
        DFS(numbers, idx + 1, result + numbers[idx]);
        DFS(numbers, idx + 1, result - numbers[idx]);
    }
}