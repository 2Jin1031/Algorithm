import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            String code = br.readLine();
            if (code.contains("FBI")) {
                ans.append(i + 1).append(" ");
            }
        }

        if (ans.length() == 0) {
            System.out.println("HE GOT AWAY!");
        } else {
            System.out.println(ans.toString().trim());
        }
    }
}