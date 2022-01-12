package programmers;

public class 비밀지도 {

    public static void main(String[] args) {
        Solution solution=new Solution();
        int n=5;
        int[] arr1={9,20,28,18,11};
        int[] arr2={30,1,21,17,28};
        System.out.println(solution.solution(n,arr1,arr2));

    }

    static class Solution {
        public String[] solution(int n, int[] arr1, int[] arr2) {
            String[] answer = new String[n];
            int first[][]=new int[n][n];
            int second[][]=new int[n][n];

            for(int i=0;i<answer.length;i++){
                answer[i]="";
            }

            for(int i=0;i<n;i++){
                String s=Integer.toBinaryString(arr1[i]); // 1 -> 00001
                while (s.length()!=n){
                    s="0"+s;
                }
                for(int j=0;j<s.length();j++){
                    first[i][j]=s.charAt(j)-'0';
                }
            }

            for(int i=0;i<n;i++){
                String s=Integer.toBinaryString(arr2[i]); // 11110
                while (s.length()!=n){
                    s="0"+s;
                }
                for(int j=0;j<s.length();j++){
                    second[i][j]=s.charAt(j)-'0';
                }
            }

            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(first[i][j]==1 || second[i][j]==1){
                        answer[i]+="#";
                    } else {
                        answer[i]+=" ";
                    }
                }
            }

            return answer;
        }
    }
}
