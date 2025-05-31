import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String target = "DKSH";
        String input = br.readLine();

        int count = 0;
        for (int i = 0; i <= input.length() - target.length(); i++) {
            if (input.substring(i, i + target.length()).equals(target)) {
                count++;
            }
        }

        System.out.println(count);
    }
}