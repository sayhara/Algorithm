package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ_1946 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int T=Integer.parseInt(br.readLine());
        int result[]=new int[T];

        for(int i=0;i<T;i++) {
            int N = Integer.parseInt(br.readLine());
            int arr[][] = new int[N][2];

            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                arr[j][0] = Integer.parseInt(st.nextToken());
                arr[j][1] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr, new Comparator<int[]>() {

                @Override
                public int compare(int[] o1, int[] o2) {

                    if(o1[0]>o2[0]){
                        return 1;
                    }
                    return -1;
                }
            });

            int first=arr[0][1];
            int count=1;

            for(int j=1;j<N;j++){
                if(arr[j][1]<first){
                    first=arr[j][1];
                    count++;
                }
            }

            result[i]=count;
        }

        for(int i=0;i<T;i++){
            System.out.println(result[i]);
        }
    }
}
