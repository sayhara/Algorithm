package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1004 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int answer = 0;

            int N = Integer.parseInt(br.readLine());

            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                int cx = Integer.parseInt(st.nextToken());
                int cy = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());


                boolean check_one = Math.pow(cx - x1, 2) + Math.pow(cy - y1, 2) < Math.pow(r, 2);
                boolean check_two = Math.pow(cx - x2, 2) + Math.pow(cy - y2, 2) < Math.pow(r, 2);

                if (check_one && check_two) {
                    continue;
                }

                // 행성의 밖에 출발점, 안에 도착점 OR 행성의 안에 출발점, 밖에 도착점
                else if (check_one || check_two) {
                    answer++;
                }

            }
            System.out.println(answer);
        }
    }
}
