import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        Set<String> set = new HashSet<>();

        Map<Character, Integer> map = new LinkedHashMap<>();
        map.put('P', 0);
        map.put('K', 0);
        map.put('H', 0);
        map.put('T', 0);
            
        for(int i = 0; i < input.length(); i += 3) {
            String splitedInput = input.substring(i, i + 3);
            set.add(splitedInput);
            
            Character ch = splitedInput.charAt(0);
            map.put(ch, map.get(ch) + 1);
        }

        if (set.size() != input.length() / 3) {
            System.out.println("GRESKA");
        } else {
            Set<Character> keys = map.keySet();
            for (Character key : keys) {
                System.out.printf(13 - map.get(key) + " ");
            }
        }
    }
}