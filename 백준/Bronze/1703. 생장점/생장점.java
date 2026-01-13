import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            
            if (a == 0) {
                break;
            }
            
            long leaves = 1;
            
            for (int i = 0; i < a; i++) {
                int splittingFactor = Integer.parseInt(st.nextToken());
                int pruned = Integer.parseInt(st.nextToken());
                
                leaves = leaves * splittingFactor - pruned;
            }
            
            sb.append(leaves).append("\n");
        }
        
        System.out.print(sb);
    }
}