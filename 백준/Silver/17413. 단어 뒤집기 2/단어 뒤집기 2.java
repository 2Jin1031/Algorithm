import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();

        StringBuilder sb = new StringBuilder();
        boolean isTag = false;
        String tmp = "";
        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);
            if (isTag) {
                sb.append(ch);
                if (ch == '>') isTag = false;
                continue;
            }
            if (ch == '<') {
                for (int j = tmp.length() - 1; j >= 0; j--) {
                    sb.append(tmp.charAt(j));
                }
                tmp = "";
                sb.append(ch);
                isTag = true;
                continue;
            }

            if (ch == ' ') {
                for (int j = tmp.length() - 1; j >= 0; j--) {
                    sb.append(tmp.charAt(j));
                }
                tmp = "";
                sb.append(ch);
                continue;
            }

            tmp += ch + "";
        }

        for (int j = tmp.length() - 1; j >= 0; j--) {
            sb.append(tmp.charAt(j));
        }

        System.out.print(sb);
    }
}