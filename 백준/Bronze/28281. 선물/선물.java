import java.util.*;
import java.io.*;
import java.lang.Math;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        double minCost = Double.MAX_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            double sumCost = arr[i] * X + arr[i + 1] * X;
            minCost = Math.min(minCost, sumCost);
        }
        
        System.out.println((int) minCost);
    }
}