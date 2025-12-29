import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long L = sc.nextLong();
        long T = sc.nextLong();
        
        long result = 2 * T - L;
        System.out.println(result);
    }
}