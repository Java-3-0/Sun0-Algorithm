package com.codeforce.EducationalCodeforcedRound128;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class probC {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(bf.readLine());
        for (int i = 0; i < n; i++) {
            char[] arr = bf.readLine().toCharArray();

            int l = 0;
            int r = arr.length - 1;

            int zeroCnt = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == '0')
                    zeroCnt++;
            }

            int cnt = 0;
            int outNum1 = 0;
            if (zeroCnt == 0 || zeroCnt == arr.length) {
                sb.append("0\n");
            } else {
                // 우선 양 옆 날리고 시작
                while (arr[l] == '0') {
                    l++;
                    zeroCnt--;
                }
                while (arr[r] == '0') {
                    r--;
                    zeroCnt--;
                }
                
                while (l < r) {
                    // 0 날리는 부분
                    while (arr[l] == '0') {
                        l++;
                        zeroCnt--;
                    }
                    while (arr[r] == '0') {
                        r--;
                        zeroCnt--;
                    }

                    if (arr[l] == '1') {
                        outNum1++;
                        cnt = Math.max(outNum1, zeroCnt);
                        l++;
                        while (arr[l] == '0') {
                            l++;
                            zeroCnt--;
                        }
                    }
                    if (arr[r] == '1') {
                        outNum1++;
                        cnt = Math.max(outNum1, zeroCnt);
                        r--;
                        while (arr[r] == '0') {
                            r--;
                            zeroCnt--;
                        }
                    }
                }
                System.out.println(cnt);
            }
        }
    }
}
