package 자료구조1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 30분 (예전 풀이)
 * 예전 풀이를 다시 봤으므로 다시 풀어볼 문제이다.
 */
public class BOJ_2493_탑 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Tower> stack = new Stack<>();

        // 현재 확인하고 있는 탑의 다음 탑들은 현재 고려 대상이 아님 -> 입력 받음과 동시에 확인한다.
        for (int i = 1; i <= N; i++) {
            Tower now = new Tower(i, Integer.parseInt(st.nextToken()));

            while (!stack.isEmpty()) {
                // 현재 스택의 탑에 있는 탑이 레이저를 수신할 수 있는 경우
                if (now.height <= stack.peek().height) {
                    sb.append(stack.peek().idx).append(" ");
                    break;
                }
                // 현재 스택의 탑에 있는 탑이 레이저를 수신할 수 없는 경우
                stack.pop();
            }

            // 스택이 비어있는 경우 -> 받을 탑이 없는 것
            if (stack.isEmpty()) {
                sb.append("0 ");
            }

            // 다음 탑은 현재 탑을 확인해야하므로 스택에 넣는다.
            stack.push(now);
        }

        System.out.println(sb);
    }

    static class Tower {
        int idx;
        int height;

        public Tower(int idx, int height) {
            this.idx = idx;
            this.height = height;
        }
    }
}
