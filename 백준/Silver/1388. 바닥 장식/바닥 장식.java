import java.io.*;
import java.util.*;

public class Main {

    private static int N, M;
    private static char[][] board;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        int answer = 0;

        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == '-') {
        
                    if (j == 0 || board[i][j - 1] != '-') {
                        answer++;
                    }
                }
            }
        }

        
        for (int j = 0; j < M; j++) {
            for (int i = 0; i < N; i++) {
                if (board[i][j] == '|') {
        
                    if (i == 0 || board[i - 1][j] != '|') {
                        answer++;
                    }
                }
            }
        }

        System.out.println(answer);
    }
}