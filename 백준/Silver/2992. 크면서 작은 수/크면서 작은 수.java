import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine().trim();
        char[] digits = input.toCharArray();

        if (nextPermutation(digits)) {
            System.out.println(new String(digits));
        } else {
            System.out.println(0);
        }
    }

    private static boolean nextPermutation(char[] arr) {
        int i = arr.length - 1;
        while (i > 0 && arr[i - 1] >= arr[i]) {
            i--;
        }
        if (i == 0) return false;

        int j = arr.length - 1;
        while (arr[i - 1] >= arr[j]) {
            j--;
        }
        
        swap(arr, i - 1, j);

        reverse(arr, i, arr.length - 1);

        return true;
    }

    private static void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static void reverse(char[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start++, end--);
        }
    }
}