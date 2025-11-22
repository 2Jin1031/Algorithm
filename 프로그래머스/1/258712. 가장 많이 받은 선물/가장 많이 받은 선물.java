import java.util.*;
import java.lang.*;

// 선물 지수 : 준 선물 수 - 받은 선물 수 (이번 달까지)


class Solution {
    public int solution(String[] friends, String[] gifts) {
        // friends 배열을 Map으로
        Map<String, Integer> map = new HashMap<>();
        int n = friends.length;
        for (int i = 0; i < n; i++) {
            map.put(friends[i], i);
        }
        
        
        // 주고 받은 선물표 : arr (i -> j) 
        // 선물 지수 : arr2
        int[][] arr = new int[n][n];
        int[] arr2 = new int[n];
        for (int i = 0; i < gifts.length; i++) {
            String str = gifts[i];
            String[] splited = str.split(" ");
            int a = map.get(splited[0]);
            int b = map.get(splited[1]);
            
            arr[a][b]++;
            arr2[a]++;
            arr2[b]--;
        }
        
        // ** tmp ** 
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < n; j++) {
        //         System.out.printf(arr[i][j] + " ");
        //     } System.out.println();
        // }
        
        // 한 명씩, 돌면서 조건
        int answer = 0;
        for (int i = 0; i < n; i++) {
            int num = 0;
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                
                if (arr[i][j] > arr[j][i]) {
                    num++;
                } else if (arr[i][j] == arr[j][i] && arr2[i] > arr2[j]) {
                    num++;
                }
            }
            answer = Math.max(answer, num);
        }
        return answer;
    }
}

