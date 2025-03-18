import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.Math;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int damage = Integer.parseInt(st.nextToken());
        int percentage = Integer.parseInt(st.nextToken());
        
        double result = damage - (damage * 0.01 * percentage);
        int flag = 0;
        if (result < 100) {
            flag = 1;
        }
        System.out.println(flag);
    } 
}