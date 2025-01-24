import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input1 = reader.readLine();
        String input2 = reader.readLine();

        System.out.println(input1 + input2);
    }
}