// 1. 10진수를 2진수로 바꾸는 함수
// 2. arr1 / arr2 맵 형태로 바꾸기
// 3. 조합해서 만들기

import java.io.*;
import java.lang.*;
import java.util.*;

class Solution {
    
    public String[] solution(int n, int[] arr1, int[] arr2) {
        
        String[] ans = new String[n];
        for (int i = 0; i < n; i++) {
            int[] map1 = toBinary(arr1[i], n);
            int[] map2 = toBinary(arr2[i], n);
            
            String str = "";
            for (int j = 0; j < n; j++) {
                if (map1[j] == 1 || map2[j] == 1) { // 벽인지
                    str += "#";
                } else if (map1[j] == 0 && map2[j] == 0) { // 길 인지
                    str += " ";
                }
            }
            ans[i] = str;
        }
        return ans;
    }
    
    private int[] toBinary(int num, int n) {
        int[] arr = new int[n];
        int i = n - 1;
        while (num > 0) {
            arr[i--] = num % 2;
            num /= 2;
        }
        return arr;
    }
}