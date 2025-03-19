import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.Math;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            int num = Integer.parseInt(br.readLine());
            if (arr.contains(num)) {
                int idx = 0;
                for (int j = 0; j < arr.size(); j++) {
                    if (arr.get(j) == num) {
                        idx = j;
                    }
                }
                arr.remove(idx);
            }
            else {
                arr.add(num);
            }
        }
        System.out.println(arr.get(0));
    } 
}