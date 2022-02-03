package programmers.level3;

import java.util.LinkedList;
import java.util.Queue;

public class 단어_변환 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        System.out.println(solution.solution(begin, target, words));

    }

    static class Solution {

        int answer = 0;

        public int solution(String begin, String target, String[] words) {

            Queue<Word> queue = new LinkedList<>();
            boolean visited[] = new boolean[words.length];
            queue.add(new Word(begin, 0));

            while (!queue.isEmpty()) {

                Word now = queue.poll();

                if (now.word.equals(target)) {
                    answer = now.cnt;
                    break;
                }

                for (int i = 0; i < words.length; i++) {

                    if(!visited[i] && change(now.word,words[i])){
                        visited[i]=true;
                        queue.add(new Word(words[i], now.cnt + 1));
                    }
                }
            }
            return answer;
        }

        public boolean change(String word, String change) {

            int count=0;
            for(int i=0;i<word.length();i++){
                if(word.charAt(i)!=change.charAt(i)){
                    count++;
                }
                if(count>1){
                    return false;
                }
            }
            return true;
        }

        static class Word {
            String word;
            int cnt;

            Word(String word, int cnt) {
                this.word = word;
                this.cnt = cnt;
            }
        }

    }

}
