import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(i);
            if (i % 6 == 0 || i == N) {
                sb.append(" Go!");
            }
            if (i < N) {
                sb.append(" ");
            }
        }
        
        System.out.println(sb.toString());
    }
}