import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char ch = br.readLine().charAt(0);
        
        int code = ch - 0xAC00;
        int position = code / 28 / 21 * 588 + code / 28 % 21 * 28 + code % 28 + 1;
        
        System.out.println(position);
    }
}