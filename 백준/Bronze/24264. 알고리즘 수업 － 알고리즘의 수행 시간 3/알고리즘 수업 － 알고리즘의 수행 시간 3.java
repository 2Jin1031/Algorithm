import java.io.*;
import java.util.*;

public class Main {
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine());
        System.out.println(N * N);
        System.out.println("2");
    }
}