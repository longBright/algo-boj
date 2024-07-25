package 자료구조2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.TreeMap;

/**
 * 접근 맞았음
 * 1시간 넘었음
 * 시간 측정 라이브러리 사용법을 몰라서 다른 풀이를 참조했음
 * 이외에 알고리즘은 맞았으나 시간 관련 라이브러리 사용법에 대한 공부가 필요할듯
 */
public class BOJ_21942_부품대여장 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int F = Integer.parseInt(input[2]);

        // 시간 파싱
        String[] date = input[1].split("/");
        String[] time = date[1].split(":");
        int limitDay = Integer.parseInt(date[0]);
        int limitHour = Integer.parseInt(time[0]);
        int limitMinute = Integer.parseInt(time[1]);
        long limitTime = limitDay * 24L * 60L + limitHour * 60L + limitMinute;  // 분으로 환산된 대여기간

        // Key 가 회원, 부품이고 value 가 일자 및 시간인 HashMap
        // Key 가 회원이고 value 가 벌금인 TreeMap
        HashMap<String, String> rentalMap = new HashMap<>();
        TreeMap<String, Long> fineMap = new TreeMap<>();
        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");

            String value = input[0] + " " + input[1];
            String key = input[2] + input[3];

            if (rentalMap.containsKey(key)) {
                // 이미 있는 경우의 처리
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                LocalDateTime startTime = LocalDateTime.parse(rentalMap.get(key), formatter);
                LocalDateTime endTime = LocalDateTime.parse(value, formatter);

                Duration duration = Duration.between(startTime, endTime);

                long delayTime = duration.getSeconds() / 60 - limitTime;
                if (delayTime > 0) {
                    fineMap.put(input[3], fineMap.getOrDefault(input[3], 0L) + delayTime * F);
                }

                fineMap.remove(key);    // 같은 물건은 중복해서 대여할 수 없으므로 맵에서 제거
            } else {
                rentalMap.put(key, value);  // 중복이 없으므로 맵에 바로 등록
            }
        }

        // 벌금 낼 사람이 없으므로 -1 출력
        if (fineMap.isEmpty()) {
            System.out.println(-1);
            return;
        }

        // 벌금을 내야하는 사람과 요금 출력
        StringBuilder sb = new StringBuilder();
        for (String key : fineMap.keySet()) {
            sb.append(key).append(" ").append(fineMap.get(key)).append("\n");
        }
        System.out.println(sb);
    }

}
