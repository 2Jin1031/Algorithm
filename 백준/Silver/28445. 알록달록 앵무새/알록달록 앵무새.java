import static java.util.Collections.sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] info = new String[4];
        String[] split = br.readLine().split(" ");
        info[0] = split[0];
        info[1] = split[1];

        String[] split1 = br.readLine().split(" ");
        info[2] = split1[0];
        info[3] = split1[1];

        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < 4; i++) {
            String firstWord = info[i];
            for (int j = 0; j < 4; j++) {
                String lastWord = info[j];
                String word = firstWord + " " + lastWord;
                set.add(word);
            }
        }

        List<String> list = new ArrayList<>(set);
        sort(list);

        for (String word : list) {
            bw.write(word + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}