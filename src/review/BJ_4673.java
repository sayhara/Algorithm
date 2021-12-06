package review;

public class BJ_4673 {

    public static void main(String[] args) {

        boolean visited[]=new boolean[10001];

        for(int num=1;num<10000;num++){
            int value=check(num);
            if(value<=10000)
                visited[value]=true;
        }

        for(int i=1;i<=10000;i++){
            if(!visited[i]){
                System.out.println(i);
            }
        }
    }

    public static int check(int num){

        int sum=num; // 기존의 값

        while (num!=0){
            sum+=num%10;
            num/=10;
        }
        return sum;
    }
}
