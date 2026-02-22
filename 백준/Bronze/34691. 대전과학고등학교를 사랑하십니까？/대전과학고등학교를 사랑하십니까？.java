import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String s = br.readLine();
            if (s == null || s.equals("end")) break;

            switch (s) {
                case "animal" -> sb.append("Panthera tigris");
                case "tree" -> sb.append("Pinus densiflora");
                case "flower" -> sb.append("Forsythia koreana");
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }
}