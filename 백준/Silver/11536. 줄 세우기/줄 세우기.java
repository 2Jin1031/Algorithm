import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());

        String[] originalNames = new String[N];
        String[] naturalSortedNames = new String[N];
        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            originalNames[i] = name;
            naturalSortedNames[i] = name;
        }

        
        Arrays.sort(naturalSortedNames);


        boolean flag = true;
        for (int i = 0; i < N; i++) {
            if (!originalNames[i].equals(naturalSortedNames[i])) {
                flag = false;
                break;
            }
        }
        if (flag) {
            System.out.println("INCREASING");
            return ;
        }

        flag = true;
        for (int i = 0; i < N; i++) {
            if (!originalNames[N - i - 1].equals(naturalSortedNames[i])) {
                flag = false;
                break;
            }
        }

        if (flag) {
            System.out.println("DECREASING");
            return ;
        }

        System.out.println("NEITHER");
    }
}