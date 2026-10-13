class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        
        int[] result = new int[queries.length];
        for (int idx = 0; idx < queries.length; idx++) {
            int[] query = queries[idx];
            int s = query[0];
            int e = query[1];
            int k = query[2];
            
            int localResultNum = -1;
            for (int i = s; i <= e; i++) { // (s~e)
                int num = arr[i];
                if (num > k) {
                    if (localResultNum == -1 || localResultNum > num) {
                        localResultNum = num;
                    }
                }
            }
            result[idx] = localResultNum;
        }
        
        return result;
    }
}