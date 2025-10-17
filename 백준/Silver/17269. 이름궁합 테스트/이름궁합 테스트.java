import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {

    private static final int[] W = {
        3,2,1,2,4,3,1,3,1,1,3,1	,3,2,1,2,2,2,1, 2,1,1,1,2,2,1
    };

    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        String name1 = st.nextToken();
        String name2 = st.nextToken();

        int size = Math.min(N, M);

        int[] arr = new int[300];
        for (int i = 0; i < size; i++) {
            arr[i * 2] = W[name1.charAt(i) - 'A'];
            arr[i * 2 + 1] = W[name2.charAt(i) - 'A'];
        }

        String restName = name1.substring(size) + name2.substring(size);
        for (int i = 0; i < restName.length(); i++) {
            arr[size * 2 + i] = W[restName.charAt(i) - 'A'];
        }

        // while 문 돌면서 for 문 돌기
        int arrSize = size * 2 + restName.length();
        while (true) {
            if (arrSize <= 2) {
                break;
            }
            for (int i = 1; i < arrSize; i++) {
                arr[i - 1] = (arr[i - 1] + arr[i]) % 10;
            }
            arrSize--;
        }

        int ans = arr[0] * 10 + arr[1];
        System.out.println(ans + "%");
    }
}