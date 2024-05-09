package 자료구조1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 1시간 이상. 다시 풀어봐야할 문제. 다른 사람 풀이 보고 해결했음
 * 애초에 많이 푼 사람이 없는지 자료가 별로 없다...
 * 최초 접근이 틀렸음
 * 최초 접근은 문제에서 주어진 수식을 사용하는 풀이였는데, 98%에서 틀렸고, 뭘 놓쳤는지 아예 모르겠음
 */
public class BOJ_22942_데이터체커 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Point> points = new ArrayList<>();
        Stack<Point> stack = new Stack<>();

        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            // 왼쪽 끝점, 오른쪽 끝점을 구분한다.
            // x 좌표, 중심 좌표, 왼쪽 여부에 대한 정보를 담는 객체 리스트를 생성한다.
            points.add(new Point(x - r, x, true));
            points.add(new Point(x + r, x, false));
        }

        // 점의 x 좌표를 기준으로 정렬한다.
        points.sort(Comparator.comparingInt(o -> o.x));

        for (Point point : points) {
            // 원의 왼쪽 점이면 스택에 넣는다.
            if (point.isLeft) {
                stack.push(point);
                continue;
            }

            // 오른쪽 점인 경우 스택의 탑과 중심이 같다면 같은 원에 대한 좌표이므로 스택에서 뺀다.
            if (stack.peek().c == point.c) {
                stack.pop();
            } else {
                // 그렇지 않으면 둘이 다른원이다 => 겹치는 원이 존재한다.
                System.out.println("NO");
                return;
            }
        }

        // 리스트 순회가 끝났다면 겹치는 부분은 없었던 것이다.
        System.out.println("YES");
    }

    static class Point {

        int x;
        int c;
        boolean isLeft;

        public Point(int x, int c, boolean isLeft) {
            this.x = x;
            this.c = c;
            this.isLeft = isLeft;
        }
    }
}
