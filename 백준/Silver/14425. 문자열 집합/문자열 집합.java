import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[] src = new String[N];
        String[] dest = new String[M];

        for (int i = 0; i < N; i++) {
            src[i] = br.readLine();
        }
        for (int i = 0; i < M; i++) {
            dest[i] = br.readLine();
        }

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (src[i].equals(dest[j])) {
                    cnt++;
                }
            }
        }

        bw.write(cnt + "\n");

        bw.close();
        br.close();
    }

}