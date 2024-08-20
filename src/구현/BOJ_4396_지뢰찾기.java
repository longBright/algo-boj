package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 30분
 */
public class BOJ_4396_지뢰찾기 {

    static int N;
    static boolean isBoom = false;
    static final int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
    static final int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};
    static char[][] mineBoard, playBoard, resultBoard;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        mineBoard = new char[N][N];
        playBoard = new char[N][N];
        resultBoard = new char[N][N];

        inputBoard(br, mineBoard);
        inputBoard(br, playBoard);
        initResultBoard();

        process();
        boom();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(resultBoard[i]).append("\n");
        }
        System.out.println(sb);
    }

    private static void inputBoard(BufferedReader br, char[][] playBoard) throws IOException {
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                playBoard[i][j] = input.charAt(j);
            }
        }
    }

    private static void initResultBoard() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                resultBoard[i][j] = '0';
            }
        }
    }

    private static void process() {
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (playBoard[r][c] == 'x') {
                    if (mineBoard[r][c] == '*') {
                        isBoom = true;
                        continue;
                    }
                    countMines(r, c);
                }

                if (playBoard[r][c] == '.') {
                    resultBoard[r][c] = playBoard[r][c];
                }
            }
        }
    }

    private static void countMines(int r, int c) {
        for (int d = 0; d < 8; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr < 0 || nc < 0 || nr >= N || nc >= N) {
                continue;
            }

            if (mineBoard[nr][nc] == '*') {
                resultBoard[r][c]++;
            }
        }
    }

    private static void boom() {
        if (isBoom) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (mineBoard[i][j] == '*') {
                        resultBoard[i][j] = '*';
                    }
                }
            }
        }
    }
}
