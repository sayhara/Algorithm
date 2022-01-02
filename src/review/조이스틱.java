package review;

public class 조이스틱 {

    public static void main(String[] args) {
        Solution solution=new Solution();
        String name="JAN";
        System.out.println(solution.solution(name));
    }

    static class Solution {
        public int solution(String name) {
            int answer = 0;
            int LR=name.length()-1;

            for(int i=0;i<name.length();i++){
                int UD=Math.min(name.charAt(i)-'A','Z'-name.charAt(i)+1); // 위아래
                answer+=UD;

                int next=i+1;
                while (next<name.length() && name.charAt(next)=='A'){
                    next++;
                }

                LR=Math.min(LR,i*2+name.length()-next);

            }
            return answer+LR;
        }
    }
}
