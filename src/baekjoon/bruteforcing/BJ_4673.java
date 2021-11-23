package baekjoon.bruteforcing;

/*
각 자리수의 합이 나오는 값들을 따로 체크해두는 과정이 필요하다.
처음에는 for문안에 while문을 넣어 범위에 해당하는 숫자만
체크하는 방법을 사용하였다.
그런식으로 하다보니 while문 안에서 num이 계속 초기화가 되어 반복문이 돌아가지 않기에
분리하여 함수로 만들어야 했다.
 */

public class BJ_4673 {

    public static void main(String[] args) {

        boolean check[]=new boolean[10001];

        for(int i=1;i<10000;i++) {

            int num=d(i);

            if(num<=10000){
                check[num]=true;
            }
        }

        for(int i=1;i<check.length;i++){
            if(check[i]==false){
                System.out.println(i);
            }
        }
    }

    public static int d(int num){

        int sum=num;

        while (num!=0) {
            sum += num % 10;
            num /= 10;
        }

        return sum;

    }
}
