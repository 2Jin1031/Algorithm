import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        
        int countZero = 0;
        int countOne = 0;
        
        if (A == 0) countZero++;
        else countOne++;
        
        if (B == 0) countZero++;
        else countOne++;
        
        if (C == 0) countZero++;
        else countOne++;
        if (countZero == 1) {
            if (A == 0) System.out.println('A');
            else if (B == 0) System.out.println('B');
            else System.out.println('C');
        } else if (countOne == 1) {
            if (A == 1) System.out.println('A');
            else if (B == 1) System.out.println('B');
            else System.out.println('C');
        } else {
            System.out.println('*');
        }
    }
}