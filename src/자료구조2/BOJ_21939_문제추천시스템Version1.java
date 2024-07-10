package 자료구조2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * 다시 풀어야한다.
 * TreeSet 과 HashMap 을 사용하는 문제. TreeSet 사용이 익숙치 않아 다른 사람의 풀이를 보고 해결
 * 단순 구현 문제이므로 로직은 문제에서 제공된 로직을 따름
 * 다시 풀어볼 때 리팩토링도 수행해볼 예정
 */
public class BOJ_21939_문제추천시스템Version1 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        TreeSet<Problem> set = new TreeSet<>(); // 값 정렬을 위한 TreeSet
        HashMap<Integer, Integer> map = new HashMap<>();    // 문제 번호 - 난이도 쌍 관리용 HashMap

        // 초기 추천 리스트 입력
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());

            int no = Integer.parseInt(st.nextToken());
            int level = Integer.parseInt(st.nextToken());

            set.add(new Problem(no, level));
            map.put(no, level);
        }

        int M = Integer.parseInt(br.readLine());

        // 명령어 입력
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int no;
            int level;

            switch (st.nextToken()) {
                case "add":
                    no = Integer.parseInt(st.nextToken());
                    level = Integer.parseInt(st.nextToken());

                    set.add(new Problem(no, level));
                    map.put(no, level);
                    break;
                case "recommend":
                    int x = Integer.parseInt(st.nextToken());

                    if (x == 1) {
                        sb.append(set.last().no).append("\n");
                    } else {
                        sb.append(set.first().no).append("\n");
                    }
                    break;
                case "solved":
                    no = Integer.parseInt(st.nextToken());
                    level = map.get(no);

                    set.remove(new Problem(no, level));
                    map.remove(no);
                    break;
                default:
                    break;
            }
        }

        System.out.println(sb);
    }

    static class Problem implements Comparable<Problem> {
        int no;
        int level;

        public Problem(int no, int level) {
            this.no = no;
            this.level = level;
        }


        @Override
        public int compareTo(Problem p) {
            if (this.level == p.level) {
                return this.no - p.no;
            }
            return this.level - p.level;
        }
    }
}
