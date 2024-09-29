import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new java.io.OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        LinkedHashSet<String> set = new LinkedHashSet<>();
        for (int i = 0; i < M; i++) {
            String studentN = br.readLine();
            if (set.contains(studentN)) {
                set.remove(studentN);
            }
            set.add(studentN);
        }

        Iterator<String> iterator = set.iterator();
        for (int i = 0; i < N && iterator.hasNext(); i++) {
            bw.write(iterator.next() + "\n");
        }

        br.close();
        bw.close();
    }
}