package kr.co.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class programmers_77485 {
    public static void main(String[] args) {
        programmers_77485 sol = new programmers_77485();
        sol.solution(6, 6, new int[][]{{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}});
    }


    public int[] solution(int rows, int columns, int[][] queries) {
        ArrayList<Integer> answer = new ArrayList<>();
        int[][] arr = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                arr[i][j] = i * columns + j + 1;
            }
        }

        for (int[] now : queries) {
            Deque<Integer> que = new LinkedList<>();
            int start_x = now[0] - 1;
            int start_y = now[1] - 1;
            int end_x = now[2] - 1;
            int end_y = now[3] - 1;

            for (int i = start_y; i < end_y; i++) {
                que.offer(arr[start_x][i]);
            }
            for (int i = start_x; i < end_x; i++) {
                que.offer(arr[i][end_y]);
            }
            for (int i = end_y; i > start_y; i--) {
                que.offer(arr[end_x][i]);
            }
            for (int i = end_x; i > start_x; i--) {
                que.offer(arr[i][start_y]);
            }
            System.out.println(que);
            que.offerFirst(que.pollLast());

            int minnum = que.peek();
            for (int i = start_y; i < end_y; i++) {
                arr[start_x][i] = que.poll();
                minnum = Math.min(minnum, arr[start_x][i]);
            }
            for (int i = start_x; i < end_x; i++) {
                arr[i][end_y] = que.poll();
                minnum = Math.min(minnum, arr[i][end_y]);
            }
            for (int i = end_y; i > start_y; i--) {
                arr[end_x][i] = que.poll();
                minnum = Math.min(minnum, arr[end_x][i]);
            }
            for (int i = end_x; i > start_x; i--) {
                arr[i][start_y] = que.poll();
                minnum = Math.min(minnum, arr[i][start_y]);
            }
            answer.add(minnum);
        }

        int[] answerarray = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            answerarray[i] = answer.get(i);
        }
        System.out.println(Arrays.toString(answerarray));
        return answerarray;
    }

}
