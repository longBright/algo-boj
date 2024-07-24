package 자료구조2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 1시간
 * 다시 풀어야함. 기존 풀이는 두개의 리스트를 사용했는데, 두 개의 우선순위 큐를 사용하는 것이 훨씬 더 효율적임
 * 최대힙, 최소힙 두개를 사용해야함
 */
public class BOJ_2696_중앙값구하기 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            // 최대힙과 최소힙 두개 사용. 최소힙은 내림차순 정렬, 최대힙은 오름차순 정렬 => 중앙값 접근
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
            PriorityQueue<Integer> minHeap = new PriorityQueue<>(Collections.reverseOrder());

            // 출력하는 중앙값의 개수 == (수열의 크기 / 2) + 1
            int M = Integer.parseInt(br.readLine());
            sb.append((M + 1) / 2).append("\n");

            int cnt = 0;
            StringTokenizer st = null;
            for (int i = 0; i < M; i++) {
                // 입력을 위한 조건문
                if (i % 10 == 0) {
                    st = new StringTokenizer(br.readLine());
                }

                // 두 힙의 크기가 같으면 홀수번째 숫자 -> 최대힙에 저장
                // 두 힙의 크기가 다르면 짝수번째 숫자 -> 최소힙에 저장
                int num = Integer.parseInt(st.nextToken());
                if (minHeap.size() == maxHeap.size()) {
                    maxHeap.offer(num);
                } else {
                    minHeap.offer(num);
                }

                // 입력마다 최소 힙의 최댓값과 최소 힙의 최솟값을 비교
                // 최소 힙의 최댓값이 최대 힙의 최솟값보다 큰 경우, 최소 힙의 최댓값은 최대 힙의 최솟값보다 작아야하므로 스왑
                if (!maxHeap.isEmpty() && !minHeap.isEmpty()) {
                    if (minHeap.peek() > maxHeap.peek()) {
                        int temp = maxHeap.poll();
                        maxHeap.offer(minHeap.poll());
                        minHeap.offer(temp);
                    }
                }

                // 홀수번째 수를 읽을 때마다 중앙값 출력
                // 위에서 최대 힙을 기준으로 하여 값을 추가했으므로 최대 힙의 최솟값이 중앙값
                if (i % 2 == 0) {
                    sb.append(maxHeap.peek()).append(" ");

                    // 한 줄에 10개씩 출력하기 위한 조건문
                    cnt++;
                    if (cnt % 10 == 0) {
                        sb.append("\n");
                    }
                }
            }
        }

        System.out.println(sb);
    }
}
