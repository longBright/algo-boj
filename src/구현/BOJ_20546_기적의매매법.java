package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 40분
 * 코드 리팩토링 필요
 */
public class BOJ_20546_기적의매매법 {

    static final int SIZE = 14;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int money = Integer.parseInt(br.readLine());
        int[] costs = new int[SIZE];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < SIZE; i++) {
            costs[i] = Integer.parseInt(st.nextToken());
        }

        // 두 방법의 최종 결과 값만 알면됨
        int bnpRet = bnp(costs, money);
        int timingRet = timing(costs, money);
        // System.out.println("BNP: " + bnpRet + ", TIMING: " + timingRet);

        if (bnpRet > timingRet) {
            System.out.println("BNP");
        } else if (bnpRet < timingRet) {
            System.out.println("TIMING");
        } else {
            System.out.println("SAMESAME");
        }
    }

    private static int bnp(int[] costs, int money) {
        int stocks = 0;
        for (int cost : costs) {
            if (cost <= money) {
                stocks += money / cost;
                money -= cost * (money / cost);
            }
        }
        return costs[costs.length - 1] * stocks + money;
    }

    private static int timing(int[] costs, int money) {
        int stocks = 0;
        int upCnt = 0;
        int downCnt = 0;

        for (int i = 0; i < costs.length; i++) {
            // 하락
            if (i != 0 && costs[i] < costs[i - 1]) {
                downCnt++;
            } else {
                downCnt = 0;
            }
            if (i != 0 && costs[i] > costs[i - 1]) {
                upCnt++;
            } else {
                upCnt = 0;
            }

            if (upCnt >= 3) {
                money += costs[i] * stocks;
                stocks = 0;
                // System.out.println("Sell day: " + (i + 1) + ", money: " + money + ", stocks: " + stocks);
            }

            if (costs[i] <= money && downCnt >= 3) {
                stocks += money / costs[i];
                money -= costs[i] * (money / costs[i]);
                // System.out.println("Buy day: " + (i + 1) + ", money: " + money + ", stocks: " + stocks);
            }
        }
        return stocks * costs[costs.length - 1] + money;
    }
}
