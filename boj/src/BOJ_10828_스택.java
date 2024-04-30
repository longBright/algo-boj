import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 문제에서 주어진 조건대로
 * push, pop, empty, size, top 연산을 메소드화하여 구현
 * 명령어는 StringTokenizer 를 사용해서 파싱
 *
 * @author 최영환
 */
public class BOJ_10828_스택 {

    static int N, idx;
    static int[] stack = new int[10001];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        idx = -1;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String cmd = st.nextToken();
            if (cmd.equals("push")) {
                push(Integer.parseInt(st.nextToken()));
            } else if (cmd.equals("pop")) {
                sb.append(pop()).append("\n");
            } else if (cmd.equals("size")) {
                sb.append(size()).append("\n");
            } else if (cmd.equals("empty")) {
                sb.append(empty()).append("\n");
            } else if (cmd.equals("top")) {
                sb.append(top()).append("\n");
            }
        }

        System.out.println(sb);
    }

    private static void push(int x) {
        stack[++idx] = x;
    }

    private static int pop() {
        if (idx < 0) {
            return -1;
        }
        return stack[idx--];
    }

    private static int size() {
        return idx + 1;
    }

    private static int empty() {
        if (size() == 0) {
            return 1;
        }
        return 0;
    }

    private static int top() {
        if (size() == 0) {
            return -1;
        }
        return stack[idx];
    }
}
