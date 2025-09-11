import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();

        TreeSet<String> set = new TreeSet<>();
        for (int i = 0; i < S.length(); i++) {
            String str = S.substring(i);
            set.add(str);
        }

        for (String key : set) {
            System.out.println(key);
        }
    }
}
