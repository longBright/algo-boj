package 자료구조1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 1시간 30분
 * 다시 풀어볼 문제
 */
public class BOJ_2504_괄호의값 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        Stack<Character> stack = new Stack<>();
        int ret = 0;
        int val = 1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                stack.push(c);
                val *= 2;
            } else if (c == '[') {
                stack.push(c);
                val *= 3;
            } else if (c == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    ret = 0;
                    break;
                }

                if (s.charAt(i - 1) == '(') {
                    ret += val;
                }
                stack.pop();
                val /= 2;
            } else if (c == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    ret = 0;
                    break;
                }

                if (s.charAt(i - 1) == '[') {
                    ret += val;
                }
                stack.pop();
                val /= 3;
            }
        }

        if (!stack.isEmpty()) {
            ret = 0;
        }
        System.out.println(ret);
    }
}
