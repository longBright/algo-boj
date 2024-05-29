package 자료구조2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * 10분
 */
public class BOJ_1620_나는야포켓몬마스터이다솜 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<Integer, String> numberMap = new HashMap<>();
        HashMap<String, Integer> nameMap = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            String s = br.readLine();
            numberMap.put(i, s);
            nameMap.put(s, i);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            String key = br.readLine();

            if (Character.isDigit(key.charAt(0))) {
                sb.append(numberMap.get(Integer.parseInt(key))).append("\n");
            } else {
                sb.append(nameMap.get(key)).append("\n");
            }
        }

        System.out.println(sb);
    }
}
