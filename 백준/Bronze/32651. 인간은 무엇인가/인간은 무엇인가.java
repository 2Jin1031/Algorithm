import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        boolean isDigit = false;
        if (N <= 100000 && N % 2024 == 0) isDigit = true;

        System.out.println(isDigit ? "Yes" : "No");
    }
}