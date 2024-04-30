import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 해당 문자열이 VPS 인지 확인
 * 여는괄호 '(' 를 만나면 Push
 * 닫는 괄호 ')' 를 만나고 스택이 비어있지 않으면 Pop
 * 스택이 비어있으면 NO
 * 문자열의 문자를 다 확인했는데도 스택이 비어있지 않다면 NO
 * 스택이 비어있다면 YES
 *
 * @author 최영환
 */
public class BOJ_9012_괄호 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            sb.append(process(br));
        }
        System.out.println(sb);
    }

    private static String process(BufferedReader br) throws IOException {
        String s = br.readLine();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return "NO\n";
                }
                stack.pop();
            }
        }

        if (stack.isEmpty()) {
            return "YES\n";
        }
        return "NO\n";
    }
}
