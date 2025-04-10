import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        int[] arr = new int[2];

        int idx = Integer.parseInt(input.charAt(0) + "");
        for (int i = 0; i < input.length(); i++) {
            int num = Integer.parseInt(input.charAt(i) + "");
            if (idx != num) {
                arr[idx]++;
                idx = (idx + 1) % 2;
            }
        }
        int lastNum = Integer.parseInt(input.charAt(input.length() - 1) + "");
        arr[lastNum]++;

        int result = Math.min(arr[0], arr[1]);
        System.out.println(result);
    }
}