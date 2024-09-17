import java.io.*;

public class Main {
    private static int T;
    private static String func;
    private static int arr[];
    private static int start, end;
    private static boolean isReversed;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            initialize(br);
            boolean isError = false;
            start = 0;
            end = arr.length - 1;
            isReversed = false;

            for (int i = 0; i < func.length(); i++) {
                if (func.charAt(i) == 'R') {
                    isReversed = !isReversed;
                } else {
                    if (start > end) {
                        sb.append("error\n");
                        isError = true;
                        break;
                    }
                    if (isReversed) {
                        end--;
                    } else {
                        start++;
                    }
                }
            }

            if (!isError) {
                sb.append("[");
                if (start <= end) {
                    if (isReversed) {
                        for (int i = end; i >= start; i--) {
                            sb.append(arr[i]);
                            if (i != start) sb.append(",");
                        }
                    } else {
                        for (int i = start; i <= end; i++) {
                            sb.append(arr[i]);
                            if (i != end) sb.append(",");
                        }
                    }
                }
                sb.append("]\n");
            }
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    private static void initialize(BufferedReader br) throws IOException {
        func = br.readLine();
        int size = Integer.parseInt(br.readLine());
        String input = br.readLine();

        input = input.replaceAll("[\\[\\]]", "");
        String[] elements = input.split(",");

        arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(elements[i]);
        }
    }
}