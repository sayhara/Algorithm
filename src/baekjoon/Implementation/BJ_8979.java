package baekjoon.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ_8979 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(st.nextToken());
        int arr[][]=new int[N][5];

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            arr[i][0]=Integer.parseInt(st.nextToken());
            arr[i][1]=Integer.parseInt(st.nextToken());
            arr[i][2]=Integer.parseInt(st.nextToken());
            arr[i][3]=Integer.parseInt(st.nextToken());
            arr[i][4]=1;
        }

        Arrays.sort(arr, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) { // 금,은,동에 대한 내림차순 정렬

                if(o1[1]<o2[1]){
                    return 1;
                } else if(o1[1]==o2[1]){
                    if(o1[2]<o2[2]){
                        return 1;
                    } else if(o1[2]==o2[2]){
                        if(o1[3]<o2[3]){
                            return 1;
                        } else if(o1[3]==o2[3]){
                            if(o1[0]>o2[1]){ // 모두 같은 경우에는 국가를 나타내는 정수를 오름차순으로 정렬
                                return 1;
                            }
                        }
                    }
                }
                return -1;
            }
        });

        for(int i=1;i<N;i++){
            if(arr[i][1]==arr[i-1][1] && arr[i][2]==arr[i-1][2]
            && arr[i][3]==arr[i-1][3]){
                arr[i][4]=arr[i-1][4]; // 같은 경우에는 다음항을 이전항과 같도록 설정
            } else {
                arr[i][4]=i+1;
            }
        }

        for(int i=0;i<N;i++){
            if(arr[i][0]==K){
                System.out.println(arr[i][4]);
                break;
            }
        }
    }
}
