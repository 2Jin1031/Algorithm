import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] inputs = br.readLine().split(" ");
            System.out.printf("Case #%d: ", i + 1);
            for (int j = inputs.length - 1; j >= 0; j--) {
                System.out.printf(inputs[j] + " ");
            }
            System.out.println();
        }

    }
}