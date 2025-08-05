import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String input = br.readLine();
            if (input.equals("end")) {
                break;
            }

            boolean isAccept = validateQuality(input);

            String ans = "";
            if (isAccept) {
                ans = "is acceptable.";
            } else {
                ans = "is not acceptable.";  
            }

            System.out.println(String.format("<%s> %s", input, ans));
        }
    }

    private static boolean validateQuality(String input) {
    boolean[] moems = new boolean[input.length()];
    moems[0] = isMoem(input.charAt(0));

    int streak = 1;
    boolean hasMoem = moems[0];
    for (int i = 1; i < input.length(); i++) {
        moems[i] = isMoem(input.charAt(i));
        if (moems[i]) {
            hasMoem = true;
        }

        if (moems[i - 1] == moems[i]) {
            streak++;
        } else {
            streak = 1;
        }

        if (streak >= 3) {
            return false;
        }

        char ch = input.charAt(i);
        if (input.charAt(i - 1) == ch && ch != 'e' && ch != 'o') {
            return false;
        }
    }

    return hasMoem;
}

    private static boolean isMoem(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}