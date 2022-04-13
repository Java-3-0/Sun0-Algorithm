/*** optimization
 * 26200kb
 * 324ms
 */

/*** naive
 * 28456kb
 * 2768ms
 */
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

public class baekjoon_17143 {

    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};
    private static final int[] toggle = {1, 0, 3, 2};
    private static int R, C, M;
    private static int[][] fishBoard;
    private static HashMap<Integer, Shark> sharkInfo;
    private static int[][] tempBoard;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        sharkInfo = new HashMap<Integer, Shark>();
        fishBoard = new int[R][C];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken()) - 1;
            int z = Integer.parseInt(st.nextToken());

            fishBoard[r][c] = i + 1;
            sharkInfo.put(i + 1, new Shark(i + 1, r, c, s, d, z));
        }

        int kingPosition = 0;
        int weight = 0;
        while (kingPosition < C && !sharkInfo.isEmpty()) {
            weight += Fishing(kingPosition);
            MoveShark();

            System.out.println();
            kingPosition++;
        }
        System.out.println(weight);
    }

    private static void MoveShark() {
        tempBoard = new int[R][C];
        Stack<Integer> removeShark = new Stack<>();
        for (Shark s : sharkInfo.values()) {
            //setRCDNaive(s);
            setRCDOptimization(s);
            //System.out.println(s.i + " " + s.r + " " + s.c + " " + s.d + "\n");
            int index = putSharkOnBoard(s);
            if (index != -1)
                removeShark.push(index);
        }
        while (!removeShark.empty()) {
            sharkInfo.remove(removeShark.pop());
        }
        fishBoard = tempBoard;
    }

    private static int putSharkOnBoard(Shark s) {
        if (tempBoard[s.r][s.c] == 0) { // 자리에 상어 없으면 그냥 놓기
            tempBoard[s.r][s.c] = s.i;
            return -1;
        } else { // 상어 있으면 비교 하기
            Shark beforeShark = sharkInfo.get(tempBoard[s.r][s.c]);
            if (beforeShark.z >= s.z) { // 그 자리에 있던 상어가 더 크면
                return s.i;
            } else {
                tempBoard[s.r][s.c] = s.i; // 나로 갈아끼우기
                return beforeShark.i;
            }
        }
    }

    private static void setRCDOptimization(Shark s) {
        int distance = s.s;
        // 각 방향의 끝으로 보내두기
        switch (s.d) {
            case 0:
                if (distance >= s.r) {
                    distance -= s.r;
                    s.r = 0;
                    s.d = 1;
                } else {
                    s.r -= distance;
                    return;
                }
                break;
            case 1:
                if (distance >= (R - 1 - s.r)) {
                    distance -= (R - 1 - s.r);
                    s.r = R - 1;
                    s.d = 0;
                } else {
                    s.r += distance;
                    return;
                }
                break;
            case 2:
                if (distance >= (C - 1 - s.c)) {
                    distance -= (C - 1 - s.c);
                    s.c = C - 1;
                    s.d = 3;
                } else {
                    s.c += distance;
                    return;
                }
                break;
            case 3:
                if (distance >= s.c) {
                    distance -= s.c;
                    s.c = 0;
                    s.d = 2;
                } else {
                    s.c -= distance;
                    return;
                }
                break;
        }

        // s.z / (r-1 or c-1) // 몫이 홀수면 방향 바꾸기
        int switchingDirection;
        if (s.d == 0 || s.d == 1)
            switchingDirection = distance / (R - 1);
        else
            switchingDirection = distance / (C - 1);

        if (switchingDirection % 2 != 0) // 방향바꾸기
            s.d = toggle[s.d];

        // s.z % (r-1 or c-1)
        int newDistance;
        if (s.d == 0 || s.d == 1)
            newDistance = distance % (R - 1);
        else
            newDistance = distance % (C - 1);


        switch (s.d) {
            case 0:
                s.r = R - 1 - newDistance;
                break;
            case 1:
                s.r = newDistance;
                break;
            case 2:
                s.c = newDistance;
                break;
            case 3:
                s.c = C - 1 - newDistance;
                break;
        }

    }

    private static void setRCDNaive(Shark s) {
        int distance = s.s;
        while (distance > 0) {
            int nextR = s.r + dx[s.d];
            int nextC = s.c + dy[s.d];
            if (nextR >= 0 && nextR < R && nextC >= 0 && nextC < C) {
                s.r = nextR;
                s.c = nextC;
                distance--;
            } else {
                s.d = toggle[s.d];
            }
        }
    }

    private static int Fishing(int kingPosition) {
        for (int i = 0; i < R; i++) {
            int nowSharkIndex = fishBoard[i][kingPosition];
            if (nowSharkIndex != 0) {
                int weight = sharkInfo.get(nowSharkIndex).z;
                sharkInfo.remove(nowSharkIndex);
                fishBoard[i][kingPosition] = 0;
                return weight;
            }
        }
        return 0;
    }

    static class Shark {
        int i;
        int r;
        int c;
        int s;
        int d;
        int z;

        public Shark(int i, int r, int c, int s, int d, int z) {
            this.i = i;
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }
    }
}
