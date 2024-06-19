package 자료구조2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 30분
 * 입력 받는거 때문에 솔루션 확인함
 * 처음보는 입력형태, IDE 에서는 정상 작동을 하지 않음 ...
 */
public class BOJ_4358_생태학 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input;
        HashMap<String, Integer> map = new HashMap<>();
        int cnt = 0;

        while ((input = br.readLine()) != null) {
            map.put(input, map.getOrDefault(input, 0) + 1);
            cnt++;
        }

        List<String> keys = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            keys.add(entry.getKey());
        }
        Collections.sort(keys);

        for (String key : keys) {
            double ret = (double) (map.get(key) * 100.0 / cnt);

            sb.append(key)
                    .append(" ")
                    .append(String.format("%.4f", ret))
                    .append("\n");
        }

        System.out.println(sb);
    }
}
