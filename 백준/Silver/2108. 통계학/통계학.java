import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.IntStream;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Integer> arr = new ArrayList<>();

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(br.readLine());
            arr.add(value);
            map.put(value, map.getOrDefault(value, 0) + 1);
        }

        int sum = IntStream.range(0, N).map(arr::get).sum();
        int avg = (int) ((sum + 0.0) / N < 0 ? (sum + 0.0) / N - 0.5 : (sum + 0.0) / N + 0.5);
        System.out.println(avg);
        Collections.sort(arr);
        System.out.println(arr.get(N / 2));
        List<Integer> modes = new ArrayList<>();
        int modeCount = 0;
        for (int key : map.keySet()) {
            int keyCount = map.get(key);
            if (modeCount <= keyCount) {
                if (modeCount < keyCount) { // 새로운 최빈값
                    modes.clear();
                    modeCount = keyCount;
                }
                modes.add(key);
            }
        }

        Collections.sort(modes);
        if (modes.size() > 1) {
            System.out.println(modes.get(1));
        } else {
            System.out.println(modes.get(0));
        }

        int minValue = arr.get(0);
        int maxValue = arr.get(N - 1);

        System.out.println(maxValue - minValue);
    }
}
