//303296kb	1428ms
package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon_16235 {
    public static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    public static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    private static PriorityQueue<Integer[]> tree;
    private static Queue<Integer[]> deadTree, breedingTree;
    private static int[][] ground, defaultFeed;
    private static int n;
    private static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        ground = new int[n][n];
        defaultFeed = new int[n][n];
        tree = new PriorityQueue<>((o1, o2) -> (o1[2] - o2[2]));
        deadTree = new LinkedList<>();
        breedingTree = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                ground[i][j] = 5;
                defaultFeed[i][j] = num;
            }
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int age = Integer.parseInt(st.nextToken());

            tree.offer(new Integer[]{x - 1, y - 1, age});
        }

        for (int i = 0; i < k; i++) {
            spring();
            summer();
            fall();
            winter();
        }
        System.out.println(tree.size());

    }

    private static void winter() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ground[i][j] += defaultFeed[i][j];
            }
        }
    }

    private static void fall() {
        while (!breedingTree.isEmpty()) {
            Integer[] nowBreedingTree = breedingTree.poll();

            tree.offer(nowBreedingTree);

            int x = nowBreedingTree[0];
            int y = nowBreedingTree[1];

            for (int i = 0; i < 8; i++) {
                int now_x = x + dx[i];
                int now_y = y + dy[i];
                if (now_x >= 0 && now_x < n && now_y >= 0 && now_y < n) {
                    tree.offer(new Integer[]{now_x, now_y, 1});
                }
            }
        }
    }

    private static void summer() {
        while (!deadTree.isEmpty()) {
            Integer[] nowDeadTree = deadTree.poll();
            ground[nowDeadTree[0]][nowDeadTree[1]] += nowDeadTree[2] / 2;
        }
    }

    private static void spring() {
        PriorityQueue<Integer[]> newTree = new PriorityQueue<>((o1, o2) -> (o1[2] - o2[2]));

        while (!tree.isEmpty()) {
            Integer[] nowTree = tree.poll();
            int x = nowTree[0];
            int y = nowTree[1];
            int age = nowTree[2];
            if (ground[x][y] >= age) {
                if ((age + 1) % 5 == 0)
                    breedingTree.offer(new Integer[]{x, y, age + 1});
                else
                    newTree.offer(new Integer[]{x, y, age + 1});
                ground[x][y] -= age;
            } else {
                deadTree.offer(nowTree);
            }
        }
        tree = newTree;
        return;
    }
}
