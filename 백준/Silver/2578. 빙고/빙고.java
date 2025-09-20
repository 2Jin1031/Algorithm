import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int num = Integer.parseInt(st.nextToken());
                map.put(num, new int[]{i, j});
            }
        }

        int[] rows = new int[5];
        int[] columns = new int[5];
        int[] diagonals = new int[2];

        int count = 0;
        int ans = 0;
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int num = Integer.parseInt(st.nextToken());
                int[] position = map.get(num);

                rows[position[0]]++;
                if (rows[position[0]] == 5) {
                    count++;
                }
                
                columns[position[1]]++;
                if (columns[position[1]] == 5) {
                    count++;
                }

                if (position[0] - position[1] == 0 || position[0] + position[1] == 4) {
                    if (position[0] - position[1] == 0) {
                        int idx = 1;
                        diagonals[idx]++;
                        if (diagonals[idx] == 5) {
                            count++;
                        }
                    }
                    if (position[0] + position[1] == 4) {
                        int idx = 0;
                        diagonals[idx]++;
                        if (diagonals[idx] == 5) {
                            count++;
                        }
                    }
                }

                if (count >= 3) {
                    ans = i * 5 + j + 1;
                    break;
                } 
            }
            if (count >= 3) {
                break;
            }
        }
        System.out.println(ans);
    }
}