import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 단순히 큐의 크기가 1이 될 때 까지 맨 앞의 원소를 버리고, 맨 앞의 원소를 뒤로 보내주는 작업을 반복하면됨
 * LinkedList 사용시 보다 ArrayDeque 사용시가 메모리가 더 적었음
 * 둘이 시간은 차이가 없었음
 * 10분
 */
public class BOJ_2146_카드2 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> dq = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            dq.addLast(i);
        }

        while (dq.size() > 1) {
            dq.pollFirst();
            dq.addLast(dq.pollFirst());
        }

        System.out.println(dq.poll());
    }
}
