import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String src = br.readLine();
        int num = Integer.parseInt(br.readLine());

        int count = 0;
        for (int i = 0; i < num; i++) {
            String desc = br.readLine();
            if (src.substring(0, 5).equals(desc.substring(0, 5))) {
                count++;
            }
        }
        System.out.println(count);
    }
}