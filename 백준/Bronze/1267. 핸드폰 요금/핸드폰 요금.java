import java.util.*;
import java.lang.*;
import java.io.*;

class PhoneFare {
    int unit;
    int fare;

    public PhoneFare (int unit, int fare) {
        this.unit = unit;
        this.fare = fare;
    }

    public int calculateTotalPrice(List<Integer> times) {
        int totalCount = 0;
        for (int time : times) {
            int div = time / unit;
            totalCount += div + 1;
        }
        return totalCount * fare;
    }
}

class Person {
    String name;
    PhoneFare phoneFare;

    public Person (String name, int unit, int fare) {
        this.name = name;
        this.phoneFare = new PhoneFare(unit, fare);
    }

    public int calculateTotalPrice(List<Integer> times) {
        return phoneFare.calculateTotalPrice(times);
    }

    public String getName() {
        return name;
    }
}

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Person minsik = new Person("M", 60, 15);
        Person yongsik = new Person("Y", 30, 10);

        int N = Integer.parseInt(br.readLine());
        List<Integer> times = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int time = Integer.parseInt(st.nextToken());
            times.add(time);
        }

        int totalPriceM = minsik.calculateTotalPrice(times);
        int totalPriceY = yongsik.calculateTotalPrice(times);

        if (totalPriceM == totalPriceY) {
            System.out.println("Y M " + totalPriceM);
        } else if (totalPriceM < totalPriceY) {
            System.out.println("M " + totalPriceM);
        } else {
            System.out.println("Y " + totalPriceY);
        }
    }
}