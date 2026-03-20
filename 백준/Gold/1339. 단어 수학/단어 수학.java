import java.io.*;
import java.util.*;
import java.lang.*;


class WordInfo {
    private char ch;
    private int score;

    public WordInfo(char ch) {
        this.ch = ch;
        this.score = 0;
    }

    public void addScore(int addValue) {
        score += addValue;
    }

    public int getScore() {
        return score;
    }

    public char getCh() {
        return ch;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        WordInfo[] wordInfos = new WordInfo[26];
        for (int i = 0; i < 26; i++) {
            String charStr = "A" + i;
            wordInfos[i] =  new WordInfo((char)('A' + i));
        }

        String[] words = new String[N];
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            words[i] = word;
            for (int j = word.length() - 1, k = 1; j >= 0; j--, k++) {
                char ch = word.charAt(j);
                wordInfos[ch - 'A'].addScore((int)Math.pow(10, k));
            }
        }

        Arrays.sort(wordInfos, (a, b) -> Integer.compare(a.getScore(), b.getScore()));

        for (int i = 25, j = 9; i >= 16; i--, j--) {
            char ch = wordInfos[i].getCh();
            for (int k = 0; k < N; k++) {
                words[k] = words[k].replace(ch + "", j + "");
            }
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            int wordNumber = Integer.parseInt(words[i]);
            ans += wordNumber;
        }

        System.out.println(ans);
    }
}