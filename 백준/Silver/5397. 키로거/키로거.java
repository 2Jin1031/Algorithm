import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            String input = br.readLine();
            LinkedList<Character> list = new LinkedList<>();
            ListIterator<Character> iter = list.listIterator();
            for (char ch : input.toCharArray()) {
                if (ch == '<') {
                    if (iter.hasPrevious()) {
                        iter.previous();
                    }
                } else if (ch == '>') {
                    if (iter.hasNext()) {
                        iter.next();
                    }
                } else if (ch == '-') {
                    if (iter.hasPrevious()) {
                        iter.previous();
                        iter.remove();
                    }
                } else {
                    iter.add(ch);
                }
            }

            for(Character ch : list) {
                bw.write(ch);
            }
            bw.write("\n");
        }
        bw.close();
        br.close();
    }
}