package 자료구조1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 스택 사용
 * 1시간 소요
 * 1. 피연산자(알파벳)은 바로 출력
 * 2. 여는 괄호는 그냥 스택에 추가
 * 3. 닫는 괄호를 만나면 여는 괄호를 만날때까지 스택의 모든 원소를 출력
 * 4. 연산자도 스택에 추가하는데 이때 스택의 탑이 현재 연산자보다 높은 우선순위를 가지는 경우 스택의 모든 원소를 출력
 * 5. 문자열 탐색이 끝나고 스택에 남아있는 모든 원소를 출력
 */
public class BOJ_1918_후위표기식 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty()) {
                    if (stack.peek() == '(') {
                        stack.pop();
                        break;
                    }
                    sb.append(stack.pop());
                }
            } else if (c == '*' || c == '/' || c == '+' || c == '-') {
                while (!stack.isEmpty()) {
                    if (getPriority(stack.peek()) > getPriority(c)) {
                        break;
                    }
                    sb.append(stack.pop());
                }
                stack.push(c);
            } else {
                sb.append(c);
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb);
    }

    private static int getPriority(char op) {
        if (op == '(' || op == ')') {
            return 3;
        } else if (op == '*' || op == '/') {
            return 1;
        } else if (op == '+' || op == '-') {
            return 2;
        }
        return -1;
    }
}
