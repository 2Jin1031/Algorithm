import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().trim();

        if (s.equals("fdsajkl;") || s.equals("jkl;fdsa")) {
            System.out.print("in-out");
            return;
        }
        if (s.equals("asdf;lkj") || s.equals(";lkjasdf")) {
            System.out.print("out-in");
            return;
        }
        if (s.equals("asdfjkl;")) {
            System.out.print("stairs");
            return;
        }
        if (s.equals(";lkjfdsa")) {
            System.out.print("reverse");
            return;
        }

        System.out.print("molu");
    }
}