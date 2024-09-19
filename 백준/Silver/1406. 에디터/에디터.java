import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        LinkedList<Character> list = new LinkedList<>();
        String initialStr = br.readLine();
        for (char ch : initialStr.toCharArray()) {
            list.add(ch);
        }

        ListIterator<Character> iter = list.listIterator(list.size());

        int instructionCount = Integer.parseInt(br.readLine());
        for (int i = 0; i < instructionCount; i++) {
            String[] instruction = br.readLine().split(" ");
            if (instruction[0].equals("L")) {
                if (iter.hasPrevious()) {
                    iter.previous();
                }
            } else if (instruction[0].equals("D")) {
                if (iter.hasNext()) {
                    iter.next();
                }
            } else if (instruction[0].equals("B")) {
                if (iter.hasPrevious()) {
                    iter.previous();
                    iter.remove();
                }
            } else if (instruction[0].equals("P")) {
                iter.add(instruction[1].charAt(0));
            }
        }

        for (Character ch : list) {
            bw.write(ch);
        }
        bw.write("\n");

        bw.flush();
        bw.close();
        br.close();
    }
}