import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int E = scanner.nextInt();
        int S = scanner.nextInt();
        int M = scanner.nextInt();

        int year = 1;
        int e = 1, s = 1, m = 1;

        while (true) {
            if (e == E && s == S && m == M) {
                break;
            }

            e++;
            s++;
            m++;
            year++;

            if (e > 15) e = 1;
            if (s > 28) s = 1;
            if (m > 19) m = 1;
        }

        System.out.println(year);
    }
}