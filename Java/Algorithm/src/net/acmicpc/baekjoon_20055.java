// 2296036kb,1320ms
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class baekjoon_20055 {
    private static int n, robot_cnt;
    private static Deque<Integer> conveyor, robot;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        robot_cnt = 0;
        conveyor = new LinkedList<>();
        robot = new LinkedList<>();
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < 2 * n; i++) {
            conveyor.offer(Integer.parseInt(st.nextToken()));
        }
        for (int i = 0; i < n; i++) {
            robot.offer(0);
        }

        int cnt = 0;
        while (durability() < k) {
            //System.out.println(conveyor);
            rotateConveyor();
            //System.out.println(conveyor);
            moveRobot();
            //System.out.println(conveyor);
            putRobot();

            cnt++;
            //System.out.println(cnt);
        }
        System.out.println(cnt);
    }

    private static void putRobot() {
        if (conveyor.peek() != 0) {
            robot.pollFirst();
            robot.offerFirst(1);
            conveyor.offerFirst(conveyor.pollFirst() - 1);
        }
    }

    private static void moveRobot() {
        int[] robotTemp = new int[n];
        int[] conveyorTemp = new int[2 * n];
        int i = 0;

        // 배열에 로봇 담기
        while (!robot.isEmpty()) {
            robotTemp[i++] = robot.pollFirst();
        }

        i = 0;
        while (!conveyor.isEmpty()) {
            conveyorTemp[i++] = conveyor.pollFirst();
        }

        // 마지막 자리는 걍 버려도 되니까 버려버림
        robotTemp[n - 1] = 0;
        for (int j = n - 2; j >= 0; j--) {
            // 컨베이어 내구도가 0이 아니고, 로봇 다음자리가 공석이 아니면
            if (conveyorTemp[j + 1] != 0 && robotTemp[j + 1] == 0 && robotTemp[j] != 0) {
                conveyorTemp[j + 1] -= 1;
                robotTemp[j + 1] = robotTemp[j];
                robotTemp[j] = 0;
            }
        }

        for (int j = 0; j < n; j++) {
            robot.offer(robotTemp[j]);
        }

        for (int j = 0; j < 2 * n; j++) {
            conveyor.offer(conveyorTemp[j]);
        }
    }

    private static void rotateConveyor() {
        // 컨베이어 한 번 돌리기
        conveyor.offerFirst(conveyor.pollLast());

        // 로봇 돌리기
        robot.pollLast();
        robot.offerFirst(0);
    }

    private static int durability() {
        int cnt = 0;
        Iterator<Integer> it = conveyor.iterator();
        while (it.hasNext()) {
            if (it.next() == 0)
                cnt++;
        }
        return cnt;
    }
}

