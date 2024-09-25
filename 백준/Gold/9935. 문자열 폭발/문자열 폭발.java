import java.io.*;
import java.util.*;

public class Main {

    private static String str;
    private static String pattern;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        initialize(br);
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            sb.append(c);

            if (sb.length() >= pattern.length()) {
                boolean found = true;
                for (int i = 0; i < pattern.length(); i++) {
                    if (sb.charAt(sb.length() - pattern.length() + i) != pattern.charAt(i)) {
                        found = false;
                        break;
                    }
                }

                if (found) {
                    sb.setLength(sb.length() - pattern.length());
                }
            }
        }

        bw.write(sb.length() == 0 ? "FRULA" : sb.toString());
        bw.close();
        br.close();
    }

    private static void initialize(BufferedReader br) throws IOException {
        str = br.readLine();
        pattern = br.readLine();
    }
}