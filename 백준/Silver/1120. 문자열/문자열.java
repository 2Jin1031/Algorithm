import java.io.*;
import java.util.*;
import java.lang.Math;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        String desc = st.nextToken();
        String src = st.nextToken();

        int diffSize = src.length() - desc.length();

        int maxCount = 0;
        for (int srcStartIdx = 0; srcStartIdx < diffSize + 1; srcStartIdx++) {
            int srcIdx = srcStartIdx;

            int count = 0;
            for (int descIdx = 0; descIdx < desc.length(); descIdx++, srcIdx++) {
                if (src.charAt(srcIdx) == desc.charAt(descIdx)) {
                    count++;
                }
            }
            maxCount = Math.max(maxCount, count);
        }

        int ans = src.length() - diffSize - maxCount;
        System.out.println(ans);
    }
}