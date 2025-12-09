import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            dfs(1, "1");

            if (t < T - 1) sb.append("\n");
        }

        System.out.print(sb);
    }

    static void dfs(int num, String expr) {
        if (num == N) {
            if (calc(expr) == 0) {
                sb.append(expr).append("\n");
            }
            return;
        }

        int next = num + 1;
        dfs(next, expr + " " + next);
        dfs(next, expr + "+" + next);
        dfs(next, expr + "-" + next);
    }

    static int calc(String expr) {
        expr = expr.replace(" ", "");

        int sum = 0;
        int num = 0;
        char op = '+';

        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else {
                sum = apply(sum, num, op);
                op = c;
                num = 0;
            }
        }
        sum = apply(sum, num, op);
        return sum;
    }

    static int apply(int sum, int num, char op) {
        if (op == '+') return sum + num;
        if (op == '-') return sum - num;
        return sum;
    }
}