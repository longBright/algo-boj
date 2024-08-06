package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_21918_전구 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] bulbs = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            bulbs[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());

            if (a == 1) {
                bulbs[b] = c;
            } else if (a == 2) {
                for (int j = b; j < c; j++) {
                    bulbs[j] = Math.abs(bulbs[j] - 1);
                }
            } else if (a == 3) {
                for (int j = b; j < c; j++) {
                    bulbs[j] = 0;
                }
            } else if (a == 4) {
                for (int j = b; j < c; j++) {
                    bulbs[j] = 1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(bulbs[i]).append(" ");
        }

        System.out.println(sb);
    }
}
