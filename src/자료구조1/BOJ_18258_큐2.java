package 자료구조1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 정수형 배열로 스택 구현
 * 10분
 * 문제에서 주어진 조건에 맞게 각 명령들을 메소드화하여 구현
 */
public class BOJ_18258_큐2 {

    static int[] queue = new int[2000001];
    static int start = 0, end = -1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

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
            } else if (cmd.equals("front")) {
                sb.append(front()).append("\n");
            } else if (cmd.equals("back")) {
                sb.append(back()).append("\n");
            }
        }

        System.out.println(sb);
    }

    private static void push(int x) {
        queue[++end] = x;
    }

    private static int pop() {
        if (size() == 0) {
            return -1;
        }
        return queue[start++];
    }

    private static int size() {
        return end - start + 1;
    }

    private static int empty() {
        if (size() == 0) {
            return 1;
        }
        return 0;
    }

    private static int front() {
        if (size() == 0) {
            return -1;
        }
        return queue[start];
    }

    private static int back() {
        if (size() == 0) {
            return -1;
        }
        return queue[end];
    }
}
