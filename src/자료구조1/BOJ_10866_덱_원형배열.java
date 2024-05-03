package 자료구조1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 정수덱을 구현하는 문제
 * 원형 배열의 개념을 통해 구현
 * 이 구현에서 중요한 것은 인덱스 계산. 기본적인 원리는 일반 배열을 사용한 풀이와 동일하다.
 * 인덱스 계산은 아래와 같은 공식으로 진행된다.
 *
 * 인덱스가 오른쪽 방향으로 움직이는 경우
 * rear = (rear + 1) % ARRAY_SIZE
 * front = (front + 1) % ARRAY_SIZE
 *
 * 인덱스가 왼쪽 방향으로 움직이는 경우
 * rear = (rear - 1 + ARRAY_SIZE) % ARRAY_SIZE
 * front = (front - 1 + ARRAY_SIZE) % ARRAY_SIZE
 * 여기서 ARRAY_SIZE 를 더해주는 이유는 다음과 같다.
 * 만약 front 나 rear 가 0 인 경우, (-1 % ARRAY_SIZE) 이라는 잘못된 계산이 이루어지고, 인덱스 접근 시 예외가 발생한다.
 * 이같은 잘못된 계산을 방지하기 위해 ARRAY_SIZE 를 더해주어, front 나 rear 가 0 인 경우 (ARRAY_SIZE - 1) 을 가리키도록 한다.
 *
 * 원형배열도 동일하게 실제 front 원소는 front + 1 에 위치한다.
 * 만약 start = end 가 되는 경우, 아래와 같은 예외가 발생함
 * push_front(3) 을 실행하려는 경우, 아무 원소도 없을 때
 * start-- 후 dq[start] = 3 을 하면 dq[9999] = 3 이 되며, start = 9999, end = 10000 이 된다.
 *
 * 원소가 한개만 있을 경우 해당 원소는 front 이자 rear 원소가 된다.
 * 그러므로 dq[front] 에 먼저 넣고 그 다음 front 인덱스 연산을 해준다.
 *
 * 이를 통해 둘은 겹치지 않게 되고, 실제 front 원소는 (front + 1) % ARRAY_SIZE 에 위치한다.
 * 30분
 */
public class BOJ_10866_덱_원형배열 {

    static final int ARRAY_SIZE = 10000;
    static int[] dq = new int[ARRAY_SIZE];
    static int start = 0, end = 0, size = 0;

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
        end = (end + 1) % ARRAY_SIZE;
        dq[end] = x;
        size++;
    }

    private static void pushFront(int x) {
        dq[start] = x;
        start = (start - 1 + ARRAY_SIZE) % ARRAY_SIZE;
        size++;
    }

    private static int popFront() {
        if (size == 0) {
            return -1;
        }

        int ret = dq[(start + 1) % ARRAY_SIZE];
        start = (start + 1) % ARRAY_SIZE;
        size--;
        return ret;
    }

    private static int popBack() {
        if (size == 0) {
            return -1;
        }
        int ret = dq[end];
        end = (end - 1 + ARRAY_SIZE) % ARRAY_SIZE;
        size--;
        return ret;
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
        return dq[(start + 1) % ARRAY_SIZE];
    }

    private static int back() {
        if (size == 0) {
            return -1;
        }
        return dq[end];
    }
}
