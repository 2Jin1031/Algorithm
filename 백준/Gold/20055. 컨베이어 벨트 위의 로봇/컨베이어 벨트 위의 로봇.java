import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {

    private static int N, K;

    private static int[][] arr;
    private static int upLocationIdx;
    private static int downLocationIdx;
    
    private static int robotMaxNumber = 1;
    private static int count = 0; // 내구도가 0인 벨트의 갯수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // #1. 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        arr = new int[N * 2][2];
        for (int i = 0; i < N * 2; i++) {
            arr[i][0] = Integer.parseInt(st.nextToken());
        }

        upLocationIdx = 0;
        downLocationIdx = N - 1;

        int loopCount = 1;
        while (true) {
            boolean isContinue = funcLoop();
            if (!isContinue) {
                break;
            }
            loopCount++;
        }

        System.out.println(loopCount);
    }

    private static boolean funcLoop() {
        // 1. 벨트 회전
        upLocationIdx = turn(upLocationIdx);
        downLocationIdx = turn(downLocationIdx);

        downRobotIfValid();
        
        
        // 2. 로봇 이동
        // arr idx 1을 기준으로 오름차순 정렬
        // 로봇이 있는 위치를 저장
        List<Integer> robotIdxList = new ArrayList<>();
        for (int i = 0; i < 2 * N; i++) {
            if (arr[i][1] != 0) {
                robotIdxList.add(i);
            }
        }

        // 로봇 번호 기준 오름차순 정렬
        robotIdxList.sort(Comparator.comparingInt(i -> arr[i][1]));

        // 정렬된 순서대로 로봇 이동
        for (int idx : robotIdxList) {
            moveRobot(idx);
            downRobotIfValid();
        }
        
        // 3. 로봇 올리기
        if (arr[upLocationIdx][0] != 0) {
            arr[upLocationIdx][0]--;
            arr[upLocationIdx][1] = robotMaxNumber;
            robotMaxNumber++;

            if (arr[upLocationIdx][0] == 0) {
                count++;
            }
        }

        if (count >= K) {
            return false;
        }
        return true;
    }

    private static int turn(int idx) {
        return (idx - 1 + 2 * N) % (2 * N);
    }

    private static void moveRobot(int idx) {
        int nextIdx = (idx + 1) % (2 * N);

        if (arr[nextIdx][1] == 0 && arr[nextIdx][0] >= 1) { // 로봇 이동 가능 조건
            arr[nextIdx][1] = arr[idx][1];
            arr[nextIdx][0]--;
            arr[idx][1] = 0;
            
            if (arr[nextIdx][0] == 0) {
                count++;
            }
        }
    }

    private static void downRobotIfValid() {
        if (arr[downLocationIdx][1] > 0) {
            arr[downLocationIdx][1] = 0;
        }
    }
}