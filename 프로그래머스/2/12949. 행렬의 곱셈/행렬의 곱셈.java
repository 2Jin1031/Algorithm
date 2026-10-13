class Solution {
    
    int H = 0, W = 0; // H: 세로 , W: 가로
    public int[][] solution(int[][] arr1, int[][] arr2) {
        H = arr1.length; W = arr2[0].length;
        
        int[][] result = new int[H][W];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                int num = 0;
                for (int k = 0; k < arr1[0].length; k++) {
                    num += arr1[i][k] * arr2[k][j];
                }
                result[i][j] = num;
            }
        }
        return result;
    }
}