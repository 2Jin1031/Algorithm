import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.Math;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        Integer[] arr = new Integer[4];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        List<Integer> list = Arrays.asList(arr);
        Collections.sort(list);
        
        int sum1 = list.get(0) + list.get(3);
        int sum2 = list.get(1) + list.get(2);
        
        System.out.println(Math.abs(sum1 - sum2));
    } 
}