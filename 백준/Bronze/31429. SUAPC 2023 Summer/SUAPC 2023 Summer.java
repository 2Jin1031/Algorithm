import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim()) - 1;

        int[] solved = {12, 11, 11, 10, 9, 9, 9, 8, 7, 6, 6};
        int[] penalty = {1600, 894, 1327, 1311, 1004, 1178, 1357, 837, 1055, 556, 773};

        System.out.print(solved[n] + " " + penalty[n]);
    }
}