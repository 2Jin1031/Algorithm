import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        ArrayList<Integer>[] graph = new ArrayList[13];
        for (int i = 1; i <= 12; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < 12; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x].add(y);
            graph[y].add(x);
        }
        
        for (int i = 1; i <= 12; i++) {
            if (graph[i].size() == 3) {
                int[] degrees = new int[3];
                for (int j = 0; j < 3; j++) {
                    degrees[j] = graph[graph[i].get(j)].size();
                }
                Arrays.sort(degrees);
                if (degrees[0] == 1 && degrees[1] == 2 && degrees[2] == 3) {
                    System.out.println(i);
                    break;
                }
            }
        }
    }
}