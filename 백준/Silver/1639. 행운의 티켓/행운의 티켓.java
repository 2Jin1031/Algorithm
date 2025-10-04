import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        
        String input = br.readLine();
        int[] sum = new int[input.length() + 1];

        for (int i = 1; i < input.length() + 1; i++) {
            sum[i] = sum[i - 1] + Integer.parseInt(input.charAt(i - 1) + "");
        }

        // logic
        int maxLength = 0;
        for (int i = 1; i < (input.length() + 1) / 2 + 1; i++) { // i: 부분의 크기
            for (int j = i; j + i < (input.length() + 1); j++) { // j: firstSum의 시작 idx
                int firstSum = sum[j] - sum[j - i];
                int secondSum = sum[j + i] - sum[j];
                if (firstSum == secondSum) {
                    maxLength = Math.max(maxLength, i * 2);
                    break;
                }
            }
        }
        System.out.println(maxLength);
    }
}