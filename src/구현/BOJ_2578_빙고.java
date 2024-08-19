package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 30분
 */
public class BOJ_2578_빙고 {

    static final int SIZE = 5;
    static int result = 0;
    static int lineCnt = 0;
    static int[][] board = new int[SIZE][SIZE];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < SIZE; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < SIZE; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < SIZE; j++) {
                result++;
                // 사회자가 부르는 숫자
                int num = Integer.parseInt(st.nextToken());

                // 숫자 사용처리
                for (int r = 0; r < SIZE; r++) {
                    for (int c = 0; c < SIZE; c++) {
                        if (board[r][c] == num) {
                            board[r][c] = -1;
                        }
                    }
                }
                // 빙고 확인
                checkRow();
                checkCol();
                checkLeftDiagonal();
                checkRightDiagonal();

                if (lineCnt >= 3) {
                    System.out.println(result);
                    return;
                }
                lineCnt = 0;    //  중복을 막기 위해 초기화
            }
        }
    }

    private static void checkRow() {
        for (int i = 0; i < SIZE; i++) {
            int count = 0;
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == -1) {
                    count++;
                }
            }
            if (count == SIZE) {
                lineCnt++;
            }
        }
    }

    private static void checkCol() {
        for (int i = 0; i < SIZE; i++) {
            int count = 0;
            for (int j = 0; j < SIZE; j++) {
                if (board[j][i] == -1) {
                    count++;
                }
            }
            if (count == SIZE) {
                lineCnt++;
            }
        }
    }

    private static void checkLeftDiagonal() {
        int count = 0;
        for (int i = 0; i < SIZE; i++) {
            if (board[i][i] == -1) {
                count++;
            }
            if (count == SIZE) {
                lineCnt++;
            }
        }
    }

    private static void checkRightDiagonal() {
        int count = 0;
        for (int i = 0; i < SIZE; i++) {
            if (board[i][SIZE - i - 1] == -1) {
                count++;
            }
            if (count == SIZE) {
                lineCnt++;
            }
        }
    }
}
