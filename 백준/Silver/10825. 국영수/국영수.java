import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {

    static class Student {
        String name;
        int koreanScore;
        int englishScore;
        int mathScore;

        public Student(String name, int koreanScore, int englishScore, int mathScore) {
            this.name = name;
            this.koreanScore = koreanScore;
            this.englishScore = englishScore;
            this.mathScore = mathScore;
        }
    }

    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Student[] students = new Student[N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int koreanScore = Integer.parseInt(st.nextToken());
            int englishScore = Integer.parseInt(st.nextToken());
            int mathScore = Integer.parseInt(st.nextToken());

            students[i] = new Student(name, koreanScore, englishScore, mathScore);
        }

        Arrays.sort(students, (a, b) -> {
            if (a.koreanScore != b.koreanScore) return b.koreanScore - a.koreanScore;
            if (a.englishScore != b.englishScore) return a.englishScore - b.englishScore;
            if (a.mathScore != b.mathScore) return b.mathScore - a.mathScore;
            return a.name.compareTo(b.name);
        });

        StringBuilder sb = new StringBuilder();
        for (Student s : students) {
            sb.append(s.name).append('\n');
        }
        System.out.print(sb);
    }
}