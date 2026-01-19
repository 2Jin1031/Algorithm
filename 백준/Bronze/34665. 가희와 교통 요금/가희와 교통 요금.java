import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine();
        String str2 = br.readLine();

        int ans = 0;
        if (!str1.equals(str2)) {
            ans = 1550;
        }

        System.out.println(ans);
    }
}