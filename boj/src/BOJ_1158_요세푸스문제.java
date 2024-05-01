import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * ArrayDeque 가 LinkedList 보다 빠름
 * 10분
 * 큐에서 하나씩 빼면서 진행하고, 현재 숫자가 K번째 숫자라면 결과 문자열에 추가
 * 현재 문자가 K번쩨 숫자가 아니라면 다시 큐에 넣는다.
 */
public class BOJ_1158_요세푸스문제 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder("<");

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        int cnt = 0;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            cnt++;

            if (cnt == K) {
                sb.append(now).append(", ");
                cnt = 0;
            } else {
                queue.add(now);
            }
        }

        sb.delete(sb.length() - 2, sb.length())
                .append(">");
        System.out.println(sb);
    }
}
