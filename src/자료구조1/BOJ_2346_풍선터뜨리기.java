package 자료구조1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * 다시 풀어볼 문제
 * 접근은 맞았는데 코드 작성 과정에서 로직이 꼬여버림 -> 50분 정도 걸렸음
 * 갈길이 멀다
 */
public class BOJ_2346_풍선터뜨리기 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Deque<Balloon> dq = new ArrayDeque<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            dq.add(new Balloon(i + 1, Integer.parseInt(st.nextToken())));
        }

        // 첫 풍선 터트리고 시작
        Balloon first = dq.pollFirst();
        int num = first.num;
        sb.append(first.idx).append(" ");

        while (!dq.isEmpty()) {
            Balloon now = null;

            if (num < 0) {
                // 음수인 경우 왼쪽으로 이동하는 것을 구현 -> 덱의 뒤에서 빼서 앞으로 옮긴다.
                for (int i = 0; i < -num; i++) {
                    dq.offerFirst(dq.pollLast());
                }

                // 왼쪽으로 이동할 경우, 터져야 할 풍선은 현재 맨 뒤에 위치함
                now = dq.pollFirst();
                num = now.num;
            } else {
                // 양수인 경우 오른쪽으로 이동하는 것을 구현 -> 덱의 앞에서 빼서 뒤로 옮긴다.
                for (int i = 0; i < num; i++) {
                    dq.offerLast(dq.pollFirst());
                }

                // 오른쪽으로 이동할 경우, 터져야 할 풍선은 현재 맨 앞에 위치함
                now = dq.pollLast();
                num = now.num;
            }

            sb.append(now.idx).append(" ");
        }

        System.out.println(sb);
    }

    static class Balloon {
        int idx;
        int num;

        public Balloon(int idx, int num) {
            this.idx = idx;
            this.num = num;
        }
    }
}
