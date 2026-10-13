import java.util.ArrayList;
import java.util.List;

class Solution {
    public String[] solution(String my_string) {
        //String[] answer = {};
        String[] words = my_string.split(" ");
        List<String> wordlist = new ArrayList<>();

        for (String word : words) {
            if (!word.isEmpty())
                wordlist.add(word);
        }
        String[] answer = new String[wordlist.size()];
        answer = wordlist.toArray(answer);
        return answer;
    }
}