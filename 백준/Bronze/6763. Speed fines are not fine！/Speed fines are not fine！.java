import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int limit = Integer.parseInt(br.readLine());
        int speed = Integer.parseInt(br.readLine());

        int over = speed - limit;

        if (over <= 0) {
            System.out.println("Congratulations, you are within the speed limit!");
        } else if (over <= 20) {
            System.out.println("You are speeding and your fine is $100.");
        } else if (over <= 30) {
            System.out.println("You are speeding and your fine is $270.");
        } else {
            System.out.println("You are speeding and your fine is $500.");
        }
    }
}