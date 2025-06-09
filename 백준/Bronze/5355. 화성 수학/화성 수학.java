import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String[] inputs = br.readLine().split(" ");
            double number = Double.parseDouble(inputs[0]);

            for (int j = 1; j < inputs.length; j++) {
                switch (inputs[j]) {
                    case "@":
                        number *= 3;
                        break;
                    case "%":
                        number += 5;
                        break;
                    case "#":
                        number -= 7;
                        break;
                }
            }
            System.out.printf("%.2f\n", number);
        }
    }
}