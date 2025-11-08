import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        String str1 = br.readLine();
        String str2 = br.readLine();

        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        String new1 = "";
        String new2 = "";
        for (int i = 0; i < N; i++) {
            Character ch1 = str1.charAt(i);
            Character ch2 = str2.charAt(i);
            map1.put(ch1, map1.getOrDefault(ch1, 0) + 1);
            map2.put(ch2, map2.getOrDefault(ch2, 0) + 1);

            if (!isMo(ch1)) {
                new1 += ch1 + "";
            }

            if (!isMo(ch2)) {
                new2 += ch2 + "";
            }
        }

        boolean flag = true;
        for (Character key : map1.keySet()) {
            int value1 = map1.get(key);
            int value2 = map2.getOrDefault(key, 0);
            if (value1 != value2) {
                flag = false;
                break;
            }
        }

        if (str1.charAt(0) != str2.charAt(0) || str1.charAt(N - 1) != str2.charAt(N - 1)) {
            flag = false;
        }

        if (new1.length() > 0 && !new1.equals(new2)) {
            flag = false;
        }

        System.out.println(flag ? "YES" : "NO");
    }

    private static boolean isMo(Character ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}