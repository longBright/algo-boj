package 자료구조1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 최초 40분
 * 다시 풀었을때 20분
 */
public class BOJ_10799_쇠막대기 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        Stack<Character> stack = new Stack<>();
        int sum = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // 여는 괄호인 경우 스택에 넣고 다음 문자 확인
            if (c == '(') {
                stack.push(c);
                continue;
            }

            // 여는 괄호가 아닌 경우는 닫는 괄호 밖에 없음 -> 스택에서 꺼냄
            stack.pop();
            // 바로 직전문자가 여는 괄호 -> 레이저 -> 스택 크기 만큼 증가
            // 바로 직전 문자가 여는 괄호가 아니면 막대의 끝 -> 1 증가
            if (s.charAt(i - 1) == '(') {
                sum += stack.size();
            } else {
                sum++;
            }
        }

        System.out.println(sum);
    }
}
