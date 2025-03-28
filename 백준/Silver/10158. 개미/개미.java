import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int time = Integer.parseInt(br.readLine());

        int tempX = (x + time) % (2 * N);
        int resultX = tempX <= N ? tempX : 2 * N - tempX;

        int tempY = (y + time) % (2 * M);
        int resultY = tempY <= M ? tempY : 2 * M - tempY;

        System.out.println(resultX + " " + resultY);
    }
}