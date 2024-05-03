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
        Deque<Balloon> deque = new ArrayDeque<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            deque.offerLast(new Balloon(i + 1, Integer.parseInt(st.nextToken())));
        }

        Balloon first = deque.pollFirst();
        int num = first.num;
        sb.append(first.idx).append(" ");
        while (!deque.isEmpty()) {
            // 음수인 경우, 양수인 경우에 따라 처리가 다름
            Balloon next = null;
            if (num < 0) {
                for (int i = 0; i < -num; i++) {
                    deque.offerFirst(deque.pollLast());
                }
                next = deque.pollFirst();
                num = next.num;

            } else {
                for (int i = 0; i < num; i++) {
                    deque.offerLast(deque.pollFirst());
                }
                next = deque.pollLast();
                num = next.num;
            }
            sb.append(next.idx).append(" ");
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
