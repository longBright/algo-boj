package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 10분
 */
public class BOJ_1212_8진수2진수 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            int octal = input.charAt(i) - '0';
            String binary = Integer.toBinaryString(octal);

            if (binary.length() == 3) {
                result.append(binary);
            } else if (binary.length() == 2 && i != 0) {
                result.append("0" + binary);
            } else if (binary.length() == 1 && i != 0) {
                result.append("00" + binary);
            } else {
                result.append(binary);
            }
        }

        System.out.println(result);
    }
}
