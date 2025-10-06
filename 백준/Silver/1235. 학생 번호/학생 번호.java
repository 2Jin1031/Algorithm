import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());

        String[] names = new String[N];
        for (int i = 0; i < N; i++) {
            names[i] = br.readLine();
        }

        int idx = names[0].length() - 1;
        HashSet<String> set;
        while(true) {
            set = new HashSet<>();
            for (int i = 0; i < N; i++) {
                String str = names[i].substring(idx);
                if (set.contains(str)) {
                    break;
                }
                set.add(str);
            }
            if (set.size() == N) {
                System.out.println(names[0].length() - idx);
                return;
            }
            idx--;
        }
    }
}