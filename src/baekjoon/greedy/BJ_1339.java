package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
단어의 길이들을 모두 비교한 후, 가장 큰 길이의 단어의 인덱스에 큰 값을 부여하는 식으로
고민을 했었는데 길이가 같은 경우 또 다른 2차의 문제가 생겼다.
밑에 풀이는 답안을 참고하여 작성하였다.
핵심은 각각의 단어들에 자리수까지 변환하여 배열에 저장하는 것으로부터 시작이었다.
예를들어, 단어의 값이 AAA라고 한다면 이를 100A+10A+1A의 형태로 보는 것이다.
이와 같은 아이디어로 알파벳의 길이만큼의 배열에 저장한 뒤, 만약 가장 단어의 길이가 길다면
큰 값에 자리수에 분포하므로 배열을 정렬하는 과정이 필요하다.
이에 따라, 큰 배열의 인덱스에는 큰 값을 부여하고 만약 배열에 값이 존재하지 않다면
해당 자리수에는 값이 없는 것으므로 빠져나온다.
char형 문자를 마치 int형의 문제처럼 인식하여 일반화하는데 유용한 문제라고 생각한다.
 */
public class BJ_1339 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        String s[]=new String[N];
        int alpha[]=new int[26];

        for(int i=0;i<N;i++){
            s[i] = br.readLine();
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<s[i].length();j++){
                alpha[s[i].charAt(j)-65]+=Math.pow(10,s[i].length()-j-1);
            }
        }

        Arrays.sort(alpha); // 오름차순 정렬

        int value=9;
        int sum=0;
        for(int i=alpha.length-1;i>=0;i--){
            if(alpha[i]==0) break;
            sum+=alpha[i]*value;
            value--;
        }

        System.out.println(sum);
    }
}
