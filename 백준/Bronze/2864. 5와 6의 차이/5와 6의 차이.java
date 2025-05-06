import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String A = scanner.next();
        String B = scanner.next();

        int minSum = Integer.parseInt(A.replace('6', '5')) + Integer.parseInt(B.replace('6', '5'));
        int maxSum = Integer.parseInt(A.replace('5', '6')) + Integer.parseInt(B.replace('5', '6'));

        System.out.println(minSum + " " + maxSum);
    }
}