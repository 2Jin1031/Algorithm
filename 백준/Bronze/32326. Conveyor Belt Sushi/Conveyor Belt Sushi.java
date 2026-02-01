import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[]{3, 4, 5};

        int ans = 0;
        for (int i = 0; i < 3; i++) {
            int num = Integer.parseInt(br.readLine());
            ans += arr[i] * num;
        }

        System.out.println(ans);
    }
}