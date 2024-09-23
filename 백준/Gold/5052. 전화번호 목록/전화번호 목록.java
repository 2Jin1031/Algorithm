import java.io.*;

class TrieNode {
    TrieNode[] children = new TrieNode[10];  // 0~9의 숫자로만 이루어진 전화번호를 저장
    boolean isEndOfWord;
}

class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public boolean insert(String word) {
        TrieNode node = root;

        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - '0';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            } else if (node.children[index].isEndOfWord) {
                return true;  // 이전에 입력된 문자열이 현재 문자열의 접두사일 경우
            }
            node = node.children[index];
            if (i == word.length() - 1) {
                node.isEndOfWord = true;
                for (int j = 0; j < 10; j++) {
                    if (node.children[j] != null) {
                        return true;  // 현재 문자열이 이전 문자열의 접두사일 경우
                    }
                }
            }
        }
        return false;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            Trie trie = new Trie();
            boolean consistency = true;

            for (int i = 0; i < N; i++) {
                String str = br.readLine();
                if (trie.insert(str)) {
                    consistency = false;
                }
            }
            bw.write(consistency ? "YES\n" : "NO\n");
        }

        bw.close();
        br.close();
    }
}