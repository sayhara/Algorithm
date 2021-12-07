package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14888 {

    static int N;
    static int arr[], cal[];
    static int max=Integer.MIN_VALUE;
    static int min=Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        N=Integer.parseInt(br.readLine());
        arr=new int[N];
        cal=new int[4]; // +,-,*,/

        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<4;i++){
            cal[i]=Integer.parseInt(st.nextToken());
        }

        calculation(arr[0],1);

        System.out.println(max);
        System.out.println(min);

    }

    public static void calculation(int num, int index){

        if(index==N){
            max=Math.max(num,max);
            min=Math.min(num,min);
            return;
        }

        for(int i=0;i<4;i++){
            if(cal[i]>0){
                cal[i]--;
                switch (i){
                    case 0:
                        calculation(num+arr[index],index+1);
                        break;
                    case 1:
                        calculation(num-arr[index],index+1);
                        break;
                    case 2:
                        calculation(num*arr[index],index+1);
                        break;
                    case 3:
                        calculation(num/arr[index],index+1);
                        break;
                }
                cal[i]++;
            }
        }
    }
}
