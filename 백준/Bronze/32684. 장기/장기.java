import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] weights = {13, 7, 5, 3, 3, 2};

        StringTokenizer st = new StringTokenizer(br.readLine());
        double cScore = 0.0;
        for (int i = 0; i < 6; i++) {
            cScore += Integer.parseInt(st.nextToken()) * weights[i];
        }

        st = new StringTokenizer(br.readLine());
        double eScore = 1.5;
        for (int i = 0; i < 6; i++) {
            eScore += Integer.parseInt(st.nextToken()) * weights[i];
        }

        System.out.println(cScore > eScore ? "cocjr0208" : "ekwoo");
    }
}