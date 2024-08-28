import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Queue<int[]> queue = new LinkedList<>();
        int[] previous = new int[N + 1];  // 이전 상태를 저장할 배열
        queue.add(new int[]{N, 0});
        previous[N] = -1; // 시작점 표시

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentValue = current[0];
            int currentCount = current[1];

            if(currentValue == 1) {
                bw.write(currentCount + "\n");
                
                // 경로를 추적해서 스택에 저장
                Stack<Integer> stack = new Stack<>();
                int temp = 1;
                while (temp != -1) {
                    stack.push(temp);
                    temp = previous[temp];
                }
                
                // 스택에서 하나씩 꺼내어 순서대로 출력
                while (!stack.isEmpty()) {
                    bw.write(stack.pop() + " ");
                }
                bw.write("\n");
                break;
            }

            if(currentValue % 3 == 0 && previous[currentValue / 3] == 0) {
                queue.add(new int[]{currentValue / 3, currentCount + 1});
                previous[currentValue / 3] = currentValue;
            }
            if(currentValue % 2 == 0 && previous[currentValue / 2] == 0) {
                queue.add(new int[]{currentValue / 2, currentCount + 1});
                previous[currentValue / 2] = currentValue;
            }
            if (previous[currentValue - 1] == 0) {
                queue.add(new int[]{currentValue - 1, currentCount + 1});
                previous[currentValue - 1] = currentValue;
            }
        }

        bw.close();
        br.close();
    }
}