import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    private static int N, K;
    private static String[] cards;  // 카드 숫자 저장
    private static boolean[] visited; // 방문 여부 체크
    private static HashSet<String> resultSet; // 중복 제거를 위한 HashSet

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); // 카드 개수
        K = Integer.parseInt(br.readLine()); // 선택할 카드 개수

        cards = new String[N];
        visited = new boolean[N];
        resultSet = new HashSet<>();

        for (int i = 0; i < N; i++) {
            cards[i] = br.readLine();
        }

        pickCards("", 0); // 백트래킹 시작

        System.out.println(resultSet.size()); // 중복 제거된 결과의 개수 출력
    }

    // 백트래킹을 사용해 K개의 카드를 선택
    private static void pickCards(String current, int count) {
        if (count == K) { // K개를 모두 선택했을 때
            resultSet.add(current); // 결과를 HashSet에 저장
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) { // 방문하지 않은 카드라면
                visited[i] = true; // 방문 처리
                pickCards(current + cards[i], count + 1); // 선택한 카드 이어붙임
                visited[i] = false; // 백트래킹 (원상복구)
            }
        }
    }
}