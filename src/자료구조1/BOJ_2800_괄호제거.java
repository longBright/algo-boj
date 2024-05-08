package 자료구조1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 1시간 30분
 * 다시 풀 문제
 */
public class BOJ_2800_괄호제거 {

    static String input;
    static Set<String> set = new TreeSet<>();   // TreeSet 을 사용하여 자동으로 정렬되도록 한다.
    static List<Pos> posList = new ArrayList<>();
    static boolean[] used;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        input = br.readLine();
        Stack<Integer> stack = new Stack<>();

        // 괄호 쌍의 위치 정보를 담는 리스트를 생성한다.
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                int start = stack.pop();
                posList.add(new Pos(start, i));
            }
        }

        // 괄호 쌍들의 조합을 부분집합으로 구하고, 해당 괄호 쌍들이 제거된 수식을 새로 만든다.
        int n = posList.size();
        used = new boolean[n];
        subset(0, n);

        for (String item : set) {
            answer.append(item).append("\n");
        }

        System.out.println(answer);
    }

    private static void subset(int depth, int n) {
        if (depth == n) {
            StringBuilder sb = new StringBuilder();
            boolean[] check = new boolean[input.length()];

            // 제거할 괄호 쌍을 따로 표시한다.
            for (int i = 0; i < n; i++) {
                if (used[i]) {
                    Pos pos = posList.get(i);
                    check[pos.x] = true;
                    check[pos.y] = true;
                }
            }

            // 표시된 괄호 쌍 위치를 제외한 모든 문자를 추가한다.
            for (int i = 0; i < input.length(); i++) {
                if (check[i]) {
                    continue;
                }
                sb.append(input.charAt(i));
            }

            // 입력 문자열과 길이가 같으면, 같은 문자열로 간주하고, 그렇지 않으면 set 에 담는다.
            if (sb.length() != input.length()) {
                set.add(sb.toString());
            }
            return;
        }

        // 현재 괄호 쌍을 제거하는 경우와 그렇지 않는 경우
        used[depth] = true;
        subset(depth + 1, n);
        used[depth] = false;
        subset(depth + 1, n);
    }

    static class Pos {
        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
