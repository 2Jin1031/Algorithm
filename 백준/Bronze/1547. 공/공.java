import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int m = sc.nextInt();
        int cup = 1;
        
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            
            if (cup == x) {
                cup = y;
            }

            else if (cup == y) {
                cup = x;
            }
        }
        
        System.out.println(cup);
    }
}