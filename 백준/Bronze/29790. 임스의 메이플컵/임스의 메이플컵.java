import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        String result = "";
        if (N >= 1000 && (U >= 8000 || L >= 260)) {
            result = "Very Good";
        } else if (N >= 1000) {
            result = "Good";
        } else {
            result = "Bad";
        }
        System.out.println(result);
    }
}