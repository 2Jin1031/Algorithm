import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String result = "";
        for(int i = 0; i < 15; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 15; j++) {
                String value = st.nextToken();
                if (value.equals("w")) {
                    result = "chunbae";
                } else if (value.equals("b")) {
                    result = "nabi";
                } else if (value.equals("g")) {
                    result = "yeongcheol";
                }
            }
        }
        System.out.println(result);
    }
}