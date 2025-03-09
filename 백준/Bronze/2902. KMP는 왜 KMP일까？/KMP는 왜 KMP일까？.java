import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Map;
import java.lang.Math;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        String[] parsedInput = input.split("-");
        String result = "";
        for(int i = 0; i < parsedInput.length; i++) {
            result += parsedInput[i].charAt(0);
        }
        System.out.println(result);
    }
}