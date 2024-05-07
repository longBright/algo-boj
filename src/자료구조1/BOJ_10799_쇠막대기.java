package 자료구조1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 40분
 * 나중에 다시 풀어볼 문제
 */
public class BOJ_10799_쇠막대기 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        Stack<Character> stack = new Stack<>();

        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                stack.push(c);
                continue;
            }
            if (c == ')') {
                stack.pop();
                if (s.charAt(i - 1) == '(') {
                    sum += stack.size();
                } else {
                    sum++;
                }
            }
        }
        System.out.println(sum);
    }
}
