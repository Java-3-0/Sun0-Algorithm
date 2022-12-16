package KakaoBlind2023;

import java.util.Arrays;

public class Solution4 {
    public static void main(String[] args) {
        Solution4 sol = new Solution4();

        long[] numbers = new long[]{(long) 100000000000000F};
        System.out.println(Arrays.toString(sol.solution(numbers)));
    }

    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, 1);

        long[] lengthOfBT = new long[6];
        lengthOfBT[0] = 1;
        lengthOfBT[1] = 3;
        lengthOfBT[2] = 7;
        lengthOfBT[3] = 15;
        lengthOfBT[4] = 31;
        lengthOfBT[5] = 63;


        for (int i = 0; i < numbers.length; i++) {
            int length = 0;

            String inTree = Long.toBinaryString(numbers[i]);
            while (inTree.length() > lengthOfBT[length]) {
                length++;
            }
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < lengthOfBT[length] - inTree.length(); j++) {
                sb.append("0");
            }
            sb.append(inTree);
            System.out.println(sb);
            inTree = sb.toString();
            if (sb.length() == 1 && inTree.equals("0")) {
                answer[i] = 0;
                continue;
            } else {
                for (int j = 0; j < inTree.length(); j++) {
                    if (j % 2 == 1 && inTree.charAt(j) == '0') {
                        answer[i] = 0;
                        break;
                    }
                }
            }
        }

        return answer;
    }

}