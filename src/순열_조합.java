
public class 순열_조합 {

    public static void main(String[] args) {

        int arr[]={1,20,5,4,7,8,9};

        boolean visited[]=new boolean[arr.length];
        int output[]=new int[arr.length];

        System.out.println("--------------순열----------------");
        
        for(int i=1;i<=arr.length;i++){
            System.out.println("뽑는 개수="+i+"개");
            permutation(arr,visited,output,arr.length,0,i);
        }

        System.out.println("--------------조합----------------");

        for(int i=1;i<=arr.length;i++){
            System.out.println("뽑는 개수="+i+"개");
            combination(arr,visited,arr.length,0,i);
        }

    }
    // arr : 원본 배열
    // visited : 방문 여부 체크
    // output : 결과 배열을 저장하는 곳
    // n : 배열의 길이
    // depth : 현재 인덱스의 위치
    // r : 뽑는 개수

    public static void permutation(int arr[], boolean visited[], int output[], int n, int depth, int r){

        if(depth==r){
            for(int i=0;i<r;i++){
                System.out.print(output[i]+" ");
            }
            System.out.println();
            return;
        }

        for(int i=0;i<n;i++){
            if(visited[i]==false){
                visited[i]=true;
                output[depth]=arr[i];
                permutation(arr,visited,output,n,depth+1,r);
                visited[i]=false;
            }
        }
    }

    // arr : 원본 배열
    // visited : 방문 여부 체크
    // n : 배열의 길이
    // depth : 현재 인덱스의 위치
    // r : 뽑는 개수

    public static void combination(int arr[], boolean visited[], int n, int depth, int r){

        if(r==0){
            for(int i=0;i<n;i++){
                if(visited[i]){
                    System.out.print(arr[i]+" ");
                }
            }
            System.out.println();
            return;
        }

        for(int i=depth;i<n;i++){
            if(visited[i]==false){
                visited[i]=true;
                combination(arr,visited,n,i+1,r-1);
                visited[i]=false;
            }
        }
    }
}
