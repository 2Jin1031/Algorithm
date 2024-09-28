import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new java.io.OutputStreamWriter(System.out));

        HashSet<String> set = new HashSet<>();

        String input = br.readLine();
        int partSize = 1;
        while (partSize <= input.length()) {
            for (int i = 0; i <= input.length() - partSize; i++) {
                if (!set.contains(input.substring(i, i + partSize))) {
                    set.add(input.substring(i, i + partSize));
                }
            }
            partSize++;
        }
        
        bw.write(set.size() + "\n");
        br.close();
        bw.close();
    }
}