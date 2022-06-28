/***
 * 15360kb
 * 128ms
 */
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.StringTokenizer;

public class baekjoon_21608 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int n = Integer.parseInt(bf.readLine());
        int[][] arr = new int[n * n][5];
        int[][] seat = new int[n][n];
        HashMap<Integer, int[]> assignedSeat = new HashMap<>();
        HashSet<Integer>[] bff = new HashSet[n * n];
        for (int i = 0; i < n * n; i++) {
            st = new StringTokenizer(bf.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            bff[i] = new HashSet<>();
            for (int j = 1; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                bff[i].add(arr[i][j]);
            }
        }


        // 1번째는 무조건 1,1에 놓아짐
        assignedSeat.put(arr[0][0], new int[]{1, 1});
        seat[1][1] = arr[0][0];

        for (int i = 1; i < n * n; i++) {
            int now = arr[i][0];
            HashMap<Integer, Integer> candidate = new HashMap<>();
            for (int j = 1; j < 5; j++) {
                // 좋아하는 애가 앉았는지 체크
                if (assignedSeat.containsKey(arr[i][j])) {
                    // 앉았으면 앉은애 4방이 내가 갈 수 있는 자리
                    int[] loc = assignedSeat.get(arr[i][j]);
                    for (int k = 0; k < 4; k++) {
                        int x = loc[0] + dx[k];
                        int y = loc[1] + dy[k];
                        if (x >= 0 && x < n && y >= 0 && y < n && seat[x][y] == 0) {
                            int num = x * n + y;
                            candidate.put(num, candidate.getOrDefault(num, 0) + 1);
                        }
                    }
                }
            }
            // 좋아하는 학생이 아직 안앉았음
            if (candidate.size() == 0) {
                int maxCnt = -1;
                int indexX = -1;
                int indexY = -1;
                for (int l = 0; l < n; l++) {
                    for (int j = 0; j < n; j++) {
                        if (seat[l][j] != 0) continue;
                        int cnt = 0;

                        for (int k = 0; k < 4; k++) {
                            int x = l + dx[k];
                            int y = j + dy[k];
                            if (x >= 0 && x < n && y >= 0 && y < n && seat[x][y] == 0)
                                cnt++;
                        }
                        if (cnt > maxCnt) {
                            maxCnt = cnt;
                            indexX = l;
                            indexY = j;
                        }
                    }
                }

                assignedSeat.put(now, new int[]{indexX, indexY});
                seat[indexX][indexY] = now;
            } else {
                int maxCnt = -1;
                int indexLoc = 0;

                for (Map.Entry<Integer, Integer> elem : candidate.entrySet()) {
                    int cnt = elem.getValue();
                    int loc = elem.getKey();
                    if (cnt > maxCnt) {
                        indexLoc = loc;
                        maxCnt = cnt;
                    } else if (cnt == maxCnt) {
                        int emptycnt1 = 0;
                        int emptycnt2 = 0;
                        for (int k = 0; k < 4; k++) {
                            int x = (indexLoc / n) + dx[k];
                            int y = (indexLoc % n) + dy[k];
                            if (x >= 0 && x < n && y >= 0 && y < n && seat[x][y] == 0)
                                emptycnt1++;
                        }
                        for (int k = 0; k < 4; k++) {
                            int x = (loc / n) + dx[k];
                            int y = (loc % n) + dy[k];
                            if (x >= 0 && x < n && y >= 0 && y < n && seat[x][y] == 0)
                                emptycnt2++;
                        }
                        if (emptycnt1 < emptycnt2) {
                            indexLoc = loc;
                        } else if (emptycnt1 == emptycnt2 && indexLoc > loc) {
                            indexLoc = loc;
                        }
                    }
                }
                assignedSeat.put(arr[i][0], new int[]{indexLoc / n, indexLoc % n});
                seat[indexLoc / n][indexLoc % n] = arr[i][0];
            }
        }
        for (int x = 0; x < n; x++) {
            for (int j = 0; j < n; j++) {
                System.out.print(seat[x][j] + " ");
            }
            System.out.println();
        }

        long answer = 0;
        for (int i = 0; i < n * n; i++) {
            int[] loc = assignedSeat.get(arr[i][0]);
            int cnt = 0;
            for (int k = 0; k < 4; k++) {
                int x = loc[0] + dx[k];
                int y = loc[1] + dy[k];
                if (x >= 0 && x < n && y >= 0 && y < n && bff[i].contains(seat[x][y]))
                    cnt++;
            }
            switch (cnt) {
                case 1:
                    answer += 1;
                    break;
                case 2:
                    answer += 10;
                    break;
                case 3:
                    answer += 100;
                    break;
                case 4:
                    answer += 1000;
                    break;
            }
        }
        System.out.println(answer);
    }
}