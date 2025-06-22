import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<Character, Integer> map = new HashMap<>();
        map.put('A', 1);
        map.put('a', 1);
        map.put('B', 2);
        map.put('b', 1);
        map.put('D', 1);
        map.put('d', 1);
        map.put('e', 1);
        map.put('g', 1);
        map.put('O', 1);
        map.put('o', 1);
        map.put('P', 1);
        map.put('p', 1);
        map.put('Q', 1);
        map.put('q', 1);
        map.put('R', 1);
        map.put('@', 1);


        String input = br.readLine();

        int ans = 0;
        for (int i = 0; i < input.length(); i++) {
            Character ch = input.charAt(i);
            int count = map.getOrDefault(ch, 0);
            ans += count;
        }   

        System.out.println(ans);
    }
}