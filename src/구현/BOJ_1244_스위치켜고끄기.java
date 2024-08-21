package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 30분
 */
public class BOJ_1244_스위치켜고끄기 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] status = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            status[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            status[num] = Math.abs(status[num] - 1);    // 받은 번호의 위치는 항상 바뀐다.

            // 남학생일 경우
            if (gender == 1) {
                for (int j = 1; j <= N; j++) {
                    if (j % num == 0 && j != num) {
                        status[j] = Math.abs(status[j] - 1);
                    }
                }
            } else if (gender == 2) {
                // 여학생일 경우
                for (int j = 1; j <= N / 2; j++) {
                    int left = num - j;
                    int right = num + j;
                    if (left <= 0 || right >= N + 1) {
                        break;
                    }
                    if (status[left] != status[right]) {
                        break;
                    }
                    status[left] = Math.abs(status[left] - 1);
                    status[right] = Math.abs(status[right] - 1);
                }
            }
        }

        // 20번째마다 행 바꾸며 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < status.length; i++) {
            sb.append(status[i]).append(" ");
            if (i % 20 == 0) {
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}
