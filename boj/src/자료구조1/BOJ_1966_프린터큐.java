package 자료구조1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 27분
 * 1. 현재 큐의 맨 앞 문서의 중요도를 확인한다.
 * 2. 현대 문서보다 높은 문서가 있다면, 이 문서를 인쇄하지 않고 뒤로 보내고, 그렇지 않다면 인쇄한다.
 *
 * - 큐에서 원소하나를 빼고, 나머지 원소들을 현재 원소와 비교하면서 탐색한다.
 * - 탐색 중 현재 문서보다 중요도가 높은 문서가 있다면 플래그 변수 isFirst 를 false 로 설정한다.
 * - 탐색 후 isFirst 가 true 인 경우 현재 문서를 인쇄한것으로 간주하고 cnt 값을 증가시킨다.
 * - 이때, 문서의 번호가 M 과 같은 값이면 결과 문자열에 추가하고 반복을 종료한다.
 * - 그렇지 않다면 현재 문서를 큐의 맨 뒤로 보내고 반복을 계속한다.
 */
public class BOJ_1966_프린터큐 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            Queue<Document> q = new LinkedList<>();
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                q.offer(new Document(i, Integer.parseInt(st.nextToken())));
            }

            int cnt = 0;
            while (!q.isEmpty()) {
                Document now = q.poll();

                int size = q.size();
                boolean isFirst = true;
                for (int i = 0; i < size; i++) {
                    if (q.peek().priority > now.priority) {
                        isFirst = false;
                    }
                    q.offer(q.poll());
                }

                if (isFirst) {
                    cnt++;
                    if (now.idx == M) {
                        sb.append(cnt).append("\n");
                        break;
                    }
                } else {
                    q.offer(now);
                }
            }
        }
        System.out.println(sb);
    }

    static class Document {
        int idx;
        int priority;

        public Document(int idx, int priority) {
            this.idx = idx;
            this.priority = priority;
        }
    }
}
