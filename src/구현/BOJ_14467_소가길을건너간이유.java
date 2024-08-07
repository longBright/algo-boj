package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * 10분
 */
public class BOJ_14467_소가길을건너간이유 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int cow = Integer.parseInt(st.nextToken());
            int pos = Integer.parseInt(st.nextToken());

            if (map.containsKey(cow) && map.get(cow) != pos) {
                cnt++;
            }
            map.put(cow, pos);
        }
        System.out.println(cnt);
    }
}
