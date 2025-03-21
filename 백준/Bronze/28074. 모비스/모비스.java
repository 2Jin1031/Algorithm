import java.util.*;
import java.io.*;
import java.lang.Math;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String input = br.readLine();
        String srcText = "MOBIS";
        
        String result = canFind(srcText, input) ? "YES" : "NO";
        System.out.println(result);
    }
    
    public static boolean canFind(String srcText, String descText) {
        for (int i = 0; i < srcText.length(); i++) {
            if (!descText.contains(srcText.charAt(i) + "")) {
                return false;
            }
        }
        return true;
    }
}