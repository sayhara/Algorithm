package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
동전 개수의 최솟값을 위해서는 가장 큰 금액의 동전으로부터 나눠야 한다.
오름차순으로 정렬되어있으므로, 반복문의 역순으로부터 값을 비교하였고,
K보다 작거나 같으면 나눌 수 있으므로
몫 만큼 count를 증가시키고, K를 나머지로 초기화한다.
 */

public class BJ_11047 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int arr[] = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;

        for (int i = N - 1; i >= 0; i--) {
            if (K >= arr[i]) {
                count += K / arr[i];
                K = K % arr[i];
            }
            if (K == 0) break;
        }

        System.out.println(count);

    }
}
