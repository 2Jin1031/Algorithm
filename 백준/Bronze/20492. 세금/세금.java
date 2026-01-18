import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        System.out.printf("%d %d", (int)(N * 0.78), (int) (N * (1 - 0.2 * 0.22)));
    }
}