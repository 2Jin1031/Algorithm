import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {

    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        int[] arr = new int[10];
        while (num > 0) {
            int digit = num % 10;
            arr[digit]++;
            num /= 10;
        }

        int minSet = 0;
        for (int i = 0; i < 6; i++) {
            minSet = Math.max(minSet, arr[i]);
        }
        for (int i = 7; i < 9; i++) {
            minSet = Math.max(minSet, arr[i]);
        }

        int count6and9 = arr[6] + arr[9];
        minSet = Math.max(minSet, (count6and9) / 2 + (count6and9 % 2 == 0 ? 0 : 1));

        System.out.println(minSet);
    }
}