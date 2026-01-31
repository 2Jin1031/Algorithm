import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<Character, Integer> map = new HashMap<>();
        map.put('c', 0);
        map.put('d', 1);
        map.put('l', 2);
        map.put('n', 3);
        map.put('s', 4);
        map.put('z', 5);

        String[][] directory = new String[][] {
            {"c=", "c-"},
            {"dz=", "d-"},
            {"lj"},
            {"nj"},
            {"s="},
            {"z="}
        };

        String line = br.readLine();
        int ans = 0;
        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);
            // System.out.println("ch : " + ch);
            if (map.containsKey(ch)) {
                int idx = map.get(ch);
                boolean flag = false;
                int lastIdx = 0;
                for (int j = 0; j < directory[idx].length; j++) {
                    lastIdx = Math.min(i + directory[idx][j].length(), line.length());
                    String word = line.substring(i, lastIdx); // ok
                    if (word.equals(directory[idx][j])) {
                        ans++;
             //            System.out.println("find directory : " + word);
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    i += lastIdx - i - 1;
                    continue;    
                }
            }
            ans++;
        }

        System.out.println(ans);
    }
}