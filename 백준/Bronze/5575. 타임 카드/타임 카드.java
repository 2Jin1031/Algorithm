import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Map;
import java.lang.Math;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int[][][] times = new int[3][2][3];
        int[] parseTimes = new int[2];
        for (int t = 0; t < 3; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            times[t][0][0] = Integer.parseInt(st.nextToken());
            times[t][0][1] = Integer.parseInt(st.nextToken());
            times[t][0][2] = Integer.parseInt(st.nextToken());
            times[t][1][0] = Integer.parseInt(st.nextToken());
            times[t][1][1] = Integer.parseInt(st.nextToken());
            times[t][1][2] = Integer.parseInt(st.nextToken());
            for (int i = 0; i < 2; i++) {
                parseTimes[i] = convertToSec(times[t][i][0], times[t][i][1], times[t][i][2]);    
            }
            int diftSecond = parseTimes[1] - parseTimes[0];
            int[] result = convertToTime(diftSecond);
            System.out.println(result[0] + " " + result[1] + " " + result[2]);
        }
    }
    
    public static int convertToSec(int hour, int minute, int second) {
        return hour * 3600 + minute * 60 + second;
    }
    
    public static int[] convertToTime(int totalSecond) {
        int[] time = new int[3];
        for (int i = 2; i >= 0; i--) {
            time[i] = totalSecond % 60;
            totalSecond /= 60;
        }
        return time;
    }
}