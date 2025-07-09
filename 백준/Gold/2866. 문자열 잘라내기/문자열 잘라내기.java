import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        String[] inputs = new String[R];
        for (int i = 0; i < R; i++) {
            inputs[i] = br.readLine();
        }

        String[] arr = new String[C];
        for (int i = 0; i < C; i++) {
            String columnText = "";
            for (int j = 1; j < R; j++) {
                columnText = columnText + inputs[j].charAt(i) + "";
            }
            arr[i] = columnText;
        }

        int loop = 0;
        while (arr[0].length() > 0) {
            Set<String> set = new HashSet<>(C);
            for (int i = 0; i < C; i++) {
                set.add(arr[i]);
                arr[i] = arr[i].substring(1);
            }
            if (set.size() != C) {
                break;
            }
            
            loop++;
        }

        System.out.println(loop);
    }
}