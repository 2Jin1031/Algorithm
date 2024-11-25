import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] startMeeting = new int[2];
        int[] endMeeting = new int[2];
        int[] endStreaming = new int[2];

        StringTokenizer st = new StringTokenizer(br.readLine());
        parseTime(st.nextToken(), startMeeting);
        parseTime(st.nextToken(), endMeeting);
        parseTime(st.nextToken(), endStreaming);

        int[] time = new int[2];
        HashSet<String> set = new HashSet<>();
        int max = 0;
        while (true) {
            String input = br.readLine();
            if (input == null || input.isEmpty()) {
                break;
            }
            st = new StringTokenizer(input);
            parseTime(st.nextToken(), time);
            String name = st.nextToken();

            if (isBetweenTime(new int[]{0, 0}, startMeeting, time)) {
                set.add(name);
                max = Math.max(max, set.size());
            } else if (isBetweenTime(endMeeting, endStreaming, time)) {
                set.remove(name);
            }
        }



        bw.write(max - set.size() + "\n");
        bw.flush();
        bw.close();
    }

    private static boolean isBetweenTime(int[] startTime, int[] endTime, int[] time) {
        if (time[0] >= startTime[0] && time[0] <= endTime[0]) {
            if (time[0] == startTime[0] && time[1] < startTime[1]) {
                return false;
            }
            if (time[0] == endTime[0] && time[1] > endTime[1]) {
                return false;
            }
            return true;
        }
        return false;
    }

    private static void parseTime(String s, int[] time) {
        String[] split = s.split(":");
        time[0] = Integer.parseInt(split[0]);
        time[1] = Integer.parseInt(split[1]);
    }
}