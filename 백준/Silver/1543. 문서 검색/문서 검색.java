import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String src = br.readLine();
        String dest = br.readLine();

        int maxAns = 0;
        int idx = 0;
        int destSize = dest.length();
        for (int i = 0; i < destSize; i++) {
            int count = 0;
            while (i + destSize <= src.length()) {
                String tmp = src.substring(i, i + destSize);
                if (dest.equals(tmp)) {
                    count++;
                    i += destSize;
                } else {
                    i++;
                }
            }
            maxAns = Math.max(maxAns, count);
        }
        System.out.println(maxAns);
    }
}
