import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.Math;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());
        
        int discountPrice = 0;
        if (N >= 20) {
            discountPrice = Math.max((int) (P * 0.25), discountPrice);
        } 
        if (N >= 15) {
            discountPrice = Math.max(2000, discountPrice);
        }
        if (N >= 10) {
            discountPrice = Math.max((int) (P * 0.1), discountPrice);
        }
        if (N >= 5) {
            discountPrice = Math.max(500, discountPrice);
        }
        System.out.println(Math.max(P - discountPrice, 0));
    } 
}