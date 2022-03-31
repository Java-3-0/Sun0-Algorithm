package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_2011 {

    private static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();

        dp = new int[str.length() + 1];
        dp[0] = 1;
        if (str.charAt(0) != '0') {
            dp[1] = 1;
            for (int i = 2; i < str.length() + 1; i++) {
                int nowNum = str.charAt(i - 1) - '0';
                int prevNum = str.charAt(i - 2) - '0';
                int num = prevNum * 10 + nowNum;
                if (prevNum == 0 && nowNum == 0)// 00꼴
                    break;
                if (prevNum != 0 && nowNum == 0 && prevNum <= 2)  // x0꼴
                    dp[i] = dp[i - 2] % 1000000;
                if (prevNum == 0 && nowNum != 0) // 0x꼴
                    dp[i] = dp[i - 1] % 1000000;
                if (prevNum != 0 && nowNum != 0) // xx꼴
                {
                    if (num >= 1 && num <= 26)
                        dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000;
                    else
                        dp[i] = dp[i - 1] % 1000000;
                }
            }
        }
        //System.out.println(Arrays.toString(dp));
        System.out.println(dp[str.length()] % 1000000);
    }


}
