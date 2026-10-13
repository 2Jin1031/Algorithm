import java.util.Scanner;

class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        String answer = "";
        answer = my_string.substring(0, s) + overwrite_string + my_string.substring(s + overwrite_string.length());
        return answer;
    }
}

// public class Solution {
//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);
//         String my_string = scanner.next();
//         String overwrite_string = scanner.next();
//         int s = scanner.nextInt();

//         Solution1 solution1 = new Solution1();
//         String str = solution1.solution(my_string, overwrite_string, s);
//         System.out.println(str);
//     }
// }