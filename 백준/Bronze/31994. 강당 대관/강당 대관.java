import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    private static final int N = 7;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        TreeMap<String, Integer> tree = new TreeMap<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String seminarName = st.nextToken();
            int attendanceNumber = Integer.parseInt(st.nextToken());

            tree.put(seminarName, attendanceNumber);
        }

        List<String> keySet = new ArrayList<>(tree.keySet());

        keySet.sort(new Comparator<String>() {
            @Override
                public int compare(String o1, String o2) {
                return tree.get(o2).compareTo(tree.get(o1));
            }
        });

        String ans = keySet.get(0);
        System.out.println(ans);
    }
}