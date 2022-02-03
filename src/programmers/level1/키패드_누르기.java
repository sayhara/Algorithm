package programmers.level1;

import java.util.Arrays;

public class 키패드_누르기 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int numbers[] = {2, 5, 8, 0};
        String hand = "right";
        System.out.println(solution.solution(numbers, hand));
    }

    static class Solution {
        public String solution(int[] numbers, String hand) {
            String answer = "";
            int[][] keypad = {{1, 4, 7, 10}, {2, 5, 8, 0}, {3, 6, 9, 11}};
            int left = keypad[0][3], right = keypad[2][3]; // 손의 초기위치
            int LA = 0, LB = 0, RA = 0, RB = 0, MA = 0, MB = 0;

            for (int i = 0; i < numbers.length; i++) {
                if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
                    answer += "L";
                    left = numbers[i];
                } else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
                    answer += "R";
                    right = numbers[i];
                } else { // 2,5,8,0 (초기값 설정)
                    for (int a = 0; a < keypad.length; a++) {
                        for (int b = 0; b < keypad[a].length; b++) { // 키패드의 인덱스 번호
                            if (keypad[a][b] == left) {
                                LA = a;
                                LB = b;
                            }
                            if (keypad[a][b] == right) {
                                RA = a;
                                RB = b;
                            }
                            if (keypad[a][b] == numbers[i]) {
                                MA = a;
                                MB = b;
                            }
                        }
                    }

                    int a = Math.abs(LA - MA) + Math.abs(LB - MB);
                    int b = Math.abs(RA - MA) + Math.abs(RB - MB);

                    if (a > b) { // 오른쪽이 더 가까운 경우
                        answer += "R";
                        right = numbers[i];
                    } else if (a < b) { // 왼쪽이 더 가까운 경우
                        answer += "L";
                        left = numbers[i];
                    } else { // 거리가 같을 때
                        if (hand.equals("left")) {
                            answer += "L";
                            left = numbers[i];
                        } else {
                            answer += "R";
                            right = numbers[i];
                        }
                    }
                }
            }
            return answer;
        }
    }
}

