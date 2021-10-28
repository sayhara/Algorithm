package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
양수와 음수의 조합을 이용해 합과 곱 중 최댓값을 sum에 누적하여 더해주었고,
만약 여기에서 계산되지 않는 수는 visited[]를 이용해 최종적으로 sum에 더해주어 계산하였다.
문제풀이에서 아래와 같은 사실을 활용했다면 더 효율적이었을 것이다.
1보다 큰 두 수를 곱하면 항상 최대가 된다.
1보다 작은 두 수를 곱하면 항상 최소가 된다.
따라서, 합과 곱의 비교가 무의미하다.
 */
public class BJ_1744 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        int arr[]=new int[N];
        boolean visited[]=new boolean[N];
        long sum=0;

        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        for(int i=0;i<N-1;i=i+2){ // 음수일때는 낮은것부터 검사
            if(arr[i]<1 && arr[i+1]<1){
//                sum+=Math.max(arr[i]+arr[i+1],arr[i]*arr[i+1]);
                sum+=arr[i]*arr[i+1];
                visited[i]=true;
                visited[i+1]=true;
            } else{
                break;
            }
        }

        for(int i=N-1;i>0;i=i-2){ // 양수일때는 높은것부터 검사
            if(arr[i]>1 && arr[i-1]>1){
//                sum+=Math.max(arr[i]+arr[i-1],arr[i]*arr[i-1]);
                sum+=arr[i]*arr[i-1];
                visited[i]=true;
                visited[i-1]=true;
            } else{
                break;
            }
        }

        for(int i=0;i<N;i++){
            if(!visited[i]){
                sum+=arr[i];
            }
        }

        System.out.println(sum);

    }
}
