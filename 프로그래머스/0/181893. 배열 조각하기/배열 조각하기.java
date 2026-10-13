class Solution {
    public int[] solution(int[] arr, int[] query) {
        int startIdx = 0, endIdx = Math.max(arr.length - 1, 0); // result(startIdx ~ endIdx)
        for (int i = 0; i < query.length; i++) {
            int stdIdx = query[i];
            if (i % 2 == 0) {
                endIdx = startIdx + stdIdx;
            } else {
                startIdx += stdIdx;
            }
        }
        System.out.println(endIdx + " " + startIdx);
        
        int[] result = new int[endIdx - startIdx + 1];
        for (int i = 0; i < result.length; i++) {
            result[i] = arr[startIdx++];
        }
        return result;
        // return new int[0];
    }
}

// 엣지
// 잘랐는데 그 뒤까지를 원하면?