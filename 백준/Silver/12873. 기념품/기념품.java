import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            list.add(i);
        }

        int step = 1; // 초기 step
        int index = 0; // 현재 제거할 인덱스

        while (list.size() > 1) {
            // 다음 제거될 인덱스 계산
            long removeGap = (long) step * step * step; // 제거 간격
            index = (int) ((index + removeGap - 1) % list.size()); // 순환 인덱스
            list.remove(index); // 해당 인덱스의 요소 제거
            step++;
        }

        bw.write(list.get(0) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}