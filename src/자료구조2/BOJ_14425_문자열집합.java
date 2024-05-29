package 자료구조2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * 5분
 */
public class BOJ_14425_문자열집합 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        int cnt = 0;

        for (int i = 0; i < M; i++) {
            String s = br.readLine();

            if (set.contains(s)) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
