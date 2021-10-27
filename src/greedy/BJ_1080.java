package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
문자열을 입력받아 이를 int의 값에 대입하기 위해 charAt()으로 문자열을 잘라
문자로 만든 후 -'0'의 과정을 거쳐 저장하였다.
이후, 범위값 내에서 3x3을 여러번 반복하여 사용하므로 따로 함수로 만들었고,
change 함수가 반복되는 수만큼 count를 증가시켜 값을 구하였고,
변화가 되지 않으면 즉, a를 b로 바꿀 수 없다면 -1 출력 후
return 하여 문제를 해결하였다.
 */

public class BJ_1080 {

    static int a[][];
    static int b[][];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        a = new int[N][M];
        b = new int[N][M];
        int count = 0;

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                a[i][j] = s.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                b[i][j] = s.charAt(j) - '0';
            }
        }


        for (int i = 0; i <= N - 3; i++) {
            for (int j = 0; j <= M - 3; j++) {
                if (a[i][j] != b[i][j]) {
                    change(i, j);
                    count++;
                }
            }
        }

        for(int i=0;i<N;i++){
            for (int j=0;j<M;j++){
                if(a[i][j]!=b[i][j]){
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(count);
    }

    public static void change(int x, int y) {

        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                if (a[i][j] == 1) {
                    a[i][j] = 0;
                } else {
                    a[i][j] = 1;
                }
            }
        }
    }
}
