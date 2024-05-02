package 자료구조1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 후위 표기식을 계산하는 방법을 이해하고, 배열에 알파벳에 해당하는 숫자를 저장하고 사용하는 것까지 접근하면됨
 * 넉넉하게 20~30분 정도 소요(까먹고 측정 안했음...)
 * 연산자를 만나면 스택에서 숫자 두개를 빼서 연산 후 다시 스택에 넣는다.
 * 피연산자를 만나면 그 알파벳에 해당하는 원소를 스택에 넣는다.
 * 소숫점 두자리까지 나오도록 마지막 남은 스택의 원소를 꺼내어 출력하면 된다.
 * */
public class BOJ_1935_후위표기식2 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();
        Stack<Double> stack = new Stack<>();

        double[] arr = new double[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Double.parseDouble(br.readLine());
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if ('A' <= c && c <= 'Z') {
                stack.push(arr[c - 'A']);
            } else {
                double b = stack.pop();
                double a = stack.pop();

                if (c == '*') {
                    stack.push(a * b);
                } else if (c == '/') {
                    stack.push(a / b);
                } else if (c == '+') {
                    stack.push(a + b);
                } else if (c == '-') {
                    stack.push(a - b);
                }
            }
        }

        System.out.printf("%.2f", stack.pop());
    }
}
