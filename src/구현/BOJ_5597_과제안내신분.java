package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 5분
 */
public class BOJ_5597_과제안내신분 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] students = new int[30];

        for (int i = 0; i < 28; i++) {
            int n = Integer.parseInt(br.readLine());
            students[n - 1] = 1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 30; i++) {
            if (students[i] == 0) {
                sb.append(i + 1).append("\n");
            }
        }

        System.out.println(sb);
    }
}
