package KakaoBlind2023;

public class Solution2 {
    public static void main(String[] args) {
        Solution2 sol = new Solution2();

        int[] deliveries = new int[]{1, 0, 2, 0, 1, 0, 2};
        int[] pickups = new int[]{0, 2, 0, 1, 0, 2, 0};

        System.out.println(sol.solution(2, 7, deliveries, pickups));
    }

    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int i = n - 1;
        int j = n - 1;
        int maxIndex = Math.max(i, j);
        while (maxIndex > 0) {
            answer += (Math.max(i + 1, j + 1) * 2L);
            int nowDeliver = cap;
            int nowPickup = 0;

            for (i = maxIndex; i >= 0; i--) {
                if (deliveries[i] == 0) continue;
                if (deliveries[i] != 0 && nowDeliver >= deliveries[i]) {
                    nowDeliver -= deliveries[i];
                } else
                    break;
            }


            for (j = maxIndex; j >= 0; j--) {
                if (pickups[j] == 0) continue;
                if (pickups[j] != 0 && pickups[j] + nowPickup <= cap) {
                    nowPickup += pickups[j];
                } else
                    break;
            }

            maxIndex = Math.max(i, j);
        }
        return answer;
    }
}