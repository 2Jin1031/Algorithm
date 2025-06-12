import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int number = Integer.parseInt(br.readLine());

        String ans = "";
        if (number >= 620) {
            ans = "Red";
        } else if (number >= 590) {
            ans = "Orange";
        } else if (number >= 570) {
            ans = "Yellow";
        } else if (number >= 495) {
            ans = "Green";
        } else if (number >= 450) {
            ans = "Blue";
        } else if (number >= 425) {
            ans = "Indigo";
        } else {
            ans = "Violet";
        }

        System.out.println(ans);
    }
}