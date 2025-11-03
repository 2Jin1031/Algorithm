import java.io.*;
import java.util.*;

public class Main {

    private static int[] lineCount = {3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine();
        String str2 = br.readLine();

        int[] arr = new int[str1.length() * 2];
        for (int i = 0; i < str1.length(); i++) {
            int num1 = str1.charAt(i) - 'A';
            int num2 = str2.charAt(i) - 'A';

            arr[i * 2] = lineCount[num1];
            arr[i * 2 + 1] = lineCount[num2];
        }

        // 다 만든 배열로 로직
        int size = arr.length;
        
        while (true) {
            if (size == 2) break;

            for (int i = 1; i < size; i++) {
                arr[i - 1] = (arr[i - 1] + arr[i]) % 10;  
            }    
            size--;
        }
        System.out.println(arr[0] + "" + arr[1]);
    }
}