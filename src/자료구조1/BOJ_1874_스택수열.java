package 자료구조1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 30분
 * 예전에 풀었던 풀이와 다르게 풀었다.
 * 개인적으로 이번 풀이가 더 깔끔하다고 생각한다.
 */
public class BOJ_1874_스택수열 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        int[] target = new int[N];
        for (int i = 0; i < N; i++) {
            target[i] = Integer.parseInt(br.readLine());
        }

        int idx = 0;
        for (int i = 1; i <= N; i++) {
            stack.push(i);
            sb.append("+\n");

            while (!stack.isEmpty() && stack.peek() == target[idx]) {
                stack.pop();
                idx++;
                sb.append("-\n");
            }
        }

        if (!stack.isEmpty()) {
            System.out.println("NO");
            return;
        }
        System.out.println(sb);
    }
}
