import java.util.*;

class Solution {
    
    List<List<Integer>> rel = new ArrayList<>();
    
    int N;
    boolean[] visited;
    
    public int solution(String begin, String target, String[] words) {
        N = words.length;
        visited = new boolean[N];
        
        for (int i = 0; i < N; i++) {
            rel.add(new ArrayList<>());
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                String word1 = words[i];
                String word2 = words[j];
                if (!isDiff1(word1, word2)) continue;
                
                rel.get(i).add(j);
                rel.get(j).add(i);
            }
        }
        
        int minResult = N;
        for (int i = 0; i < N; i++) {
            String word = words[i];
            if (isDiff1(word, begin)) {
                int result = BFS(i, words, target);
                minResult = Math.min(minResult, result);
            }
        }
        
        return minResult;
    }
    
    public boolean isDiff1(String word1, String word2) {
        int count = 0;
        boolean flag = true;

        for (int k = 0; k < word1.length(); k++) {
            if (word1.charAt(k) != word2.charAt(k)) {
                count++;
            }

            if (count >= 2) {
                return false;
            }
        }
        return true;
    }
    
    public int BFS(int idx, String[] words, String target) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{idx, 1});
        visited[idx] = true;
        
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentIdx = current[0];
            int currentCount = current[1];
            
            if (words[currentIdx].equals(target)) {
                return currentCount;
            }
            
            List<Integer> arr = rel.get(currentIdx);
            for (int nextIdx : arr) {
                if (visited[nextIdx]) continue;
                queue.offer(new int[]{nextIdx, currentCount + 1});
                visited[nextIdx] = true;
            }
        }
        return 0;
    }
}