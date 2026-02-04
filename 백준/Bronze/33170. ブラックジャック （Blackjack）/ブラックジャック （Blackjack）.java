import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += Integer.parseInt(br.readLine());
        }

        System.out.println(sum <= 21 ? "1" : "0");
    }
}