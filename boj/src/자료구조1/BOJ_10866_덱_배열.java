package 자료구조1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 원형이 아니라 중간부터 시작하는 배열을 사용한 덱 구현
 * 원형배열에서의 인덱스 계산보다 더 간단하다.
 * start 가 가리키는 인덱스는 비어있어야함. 즉, 실제로 start 에 해당하는 원소는 start + 1에 위치함
 * 만약 start = end 가 되는 경우, 아래와 같은 예외가 발생함
 * push_front(3) 을 실행하려는 경우, 아무 원소도 없을 때
 * start-- 후 dq[start] = 3 을 하면 dq[9999] = 3 이 되며, start = 9999, end = 10000 이 된다.
 *
 * 원소가 한개만 있을 경우 해당 원소는 start 이자 end 가 된다. 그러므로 dq[start] 에 먼저 넣고 그 다음 start-- 를 해준다.
 *
 * 이를 통해 둘은 겹치지 않게 되고, 실제 start 원소는 dq[start + 1] 에 위치하게 된다.
 * 30분
 */
public class BOJ_10866_덱_배열 {
    static int[] dq = new int[20001];
    static int start = 10000, end = 10000, size = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            if (cmd.equals("push_back")) {
                pushBack(Integer.parseInt(st.nextToken()));
            } else if (cmd.equals("push_front")) {
                pushFront(Integer.parseInt(st.nextToken()));
            } else if (cmd.equals("pop_front")) {
                sb.append(popFront()).append("\n");
            } else if (cmd.equals("pop_back")) {
                sb.append(popBack()).append("\n");
            } else if (cmd.equals("size")) {
                sb.append(size).append("\n");
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

    private static void pushBack(int x) {
        dq[++end] = x;
        size++;
    }

    private static void pushFront(int x) {
        dq[start--] = x;
        size++;
    }

    private static int popFront() {
        if (size == 0) {
            return -1;
        }
        size--;
        return dq[++start];
    }

    private static int popBack() {
        if (size == 0) {
            return -1;
        }
        size--;
        return dq[end--];
    }

    private static int empty() {
        if (size == 0) {
            return 1;
        }
        return 0;
    }

    private static int front() {
        if (size == 0) {
            return -1;
        }
        return dq[start + 1];
    }

    private static int back() {
        if (size == 0) {
            return -1;
        }
        return dq[end];
    }
}

