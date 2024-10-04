import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new java.io.OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int Asize = Integer.parseInt(st.nextToken());
        int Bsize = Integer.parseInt(st.nextToken());

        HashSet<Integer> set = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < Asize; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < Bsize; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (set.contains(num)) {
                set.remove(num);
            }
        }

        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);

        bw.write(list.size() + "\n");
        for (int i = 0; i < list.size(); i++) {
            bw.write(list.get(i) + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}