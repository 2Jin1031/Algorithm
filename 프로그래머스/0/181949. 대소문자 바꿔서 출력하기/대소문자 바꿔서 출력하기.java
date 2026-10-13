import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        char[] chars = a.toCharArray();
        for (int i = 0; i < a.length(); i++) {
            if(Character.isUpperCase(chars[i])) {
                chars[i] = Character.toLowerCase(chars[i]);
            }
            else if (Character.isLowerCase(chars[i])) {
                chars[i] = Character.toUpperCase(chars[i]);
            }
        }
        a = new String(chars);
        System.out.println(a);
    }
}