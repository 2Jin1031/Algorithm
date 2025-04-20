import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String calculater = "";

        int num = Integer.parseInt(br.readLine());
        String input = br.readLine();
        calculater = input;
        
        int ans = num;
        for (int i = 0; ; i++) {
            num = Integer.parseInt(br.readLine());
            if (calculater.equals("+")) {
                ans += num;
            } else if (calculater.equals("-")) {
                ans -= num;
            } else if (calculater.equals("*")) {
                ans *= num;
            } else if (calculater.equals("/")) {
                ans /= num;
            }
            input = br.readLine();
            if (input.equals("=")) {
                break;   
            }
            calculater = input;
        }
        System.out.println(ans);
    }
}