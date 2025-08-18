import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int width = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());

        int n = Integer.parseInt(br.readLine().trim());

        List<Integer> horiz = new ArrayList<>();
        List<Integer> vert  = new ArrayList<>();
        horiz.add(0); horiz.add(height);
        vert.add(0);  vert.add(width);

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int pos = Integer.parseInt(st.nextToken());
            if (dir == 0) horiz.add(pos); 
            else vert.add(pos);           
        }

        Collections.sort(horiz);
        Collections.sort(vert);

        int maxH = 0;
        for (int i = 1; i < horiz.size(); i++) {
            maxH = Math.max(maxH, horiz.get(i) - horiz.get(i - 1));
        }

        int maxW = 0;
        for (int i = 1; i < vert.size(); i++) {
            maxW = Math.max(maxW, vert.get(i) - vert.get(i - 1));
        }

        System.out.println(maxH * maxW);
    }
}