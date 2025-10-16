import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        Integer[] burgers = new Integer[B];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < B; i++) {
            burgers[i] = Integer.parseInt(st.nextToken());
        }

        Integer[] sideMenus = new Integer[C];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            sideMenus[i] = Integer.parseInt(st.nextToken());
        }

        Integer[] drinks = new Integer[D];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < D; i++) {
            drinks[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(burgers, Comparator.reverseOrder());
        Arrays.sort(sideMenus, Comparator.reverseOrder());
        Arrays.sort(drinks, Comparator.reverseOrder());

        int size = Math.max(B, Math.max(C, D));

        int totalPrice = 0;
        int discountTotalPrice = 0;
        for (int i = 0; i < size; i++) {
            int sumPrice = 0;
            if (B > i && C > i && D > i) {
                sumPrice = burgers[i] + sideMenus[i] + drinks[i];
                totalPrice += sumPrice;
                discountTotalPrice += sumPrice * 0.9;
            } else {
                if (B > i) sumPrice += burgers[i];
                if (C > i) sumPrice += sideMenus[i];
                if (D > i) sumPrice += drinks[i];
                    
                totalPrice += sumPrice;
                discountTotalPrice += sumPrice;
            }
        }

        System.out.println(totalPrice);
        System.out.println(discountTotalPrice);
    }
}