import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] numberings = new int[] {
            2, 2, 2, // ABC
            3, 3, 3, // DEF
            4, 4, 4, // GHI
            5, 5, 5, // JKL
            6, 6, 6, // MNO
            7, 7, 7, 7, // QPRS
            8, 8, 8, // TUV
            9, 9, 9, 9 // WXYZ
            };

        String str = br.readLine();
        
        int ans = str.length();
        for (int i = 0; i < str.length(); i++) {
            int idx = str.charAt(i) - 'A';
            ans += numberings[idx];
        }

        System.out.println(ans);
    }
}