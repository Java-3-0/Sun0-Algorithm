package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon_1194 {

    private static final int[] dx = {0, 1, 0, -1};
    private static final int[] dy = {1, 0, -1, 0};
    private static int n, m, startX, startY;
    private static char[][] board;
    private static boolean[][][] visited;
    private static Queue<int[]> que;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new char[n][];


        for (int i = 0; i < n; i++) {
            board[i] = bf.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                if (board[i][j] == '0') {
                    startX = i;
                    startY = j;
                }
            }
        }

        visited = new boolean[64][50][50];

        que = new LinkedList<>();
        visited[0][startX][startY] = true;
        que.offer(new int[]{startX, startY, 0, 0});
        board[startX][startY] = '.';
        boolean isFin = false;

        all:
        while (!que.isEmpty()) {
            int[] now = que.poll();
            int x = now[0];
            int y = now[1];
            int distance = now[2];
            int hasKey = now[3];

            for (int k = 0; k < 4; k++) {
                int nowX = x + dx[k];
                int nowY = y + dy[k];
                if (nowX >= 0 && nowX < n && nowY >= 0 && nowY < m && board[nowX][nowY] != '#') {

                    if (!visited[hasKey][nowX][nowY]) { // 현재 가진 키에서 방문하지 않았을 때
                        if (board[nowX][nowY] == '1') { // 탈출구를 만났다면

                            isFin = true;
                            System.out.println(distance + 1);
                            break all;

                        } else if (board[nowX][nowY] == '.') { // 빈 칸을 만나면
                            visited[hasKey][nowX][nowY] = true;
                            que.offer(new int[]{nowX, nowY, distance + 1, hasKey});
                        } else if (board[nowX][nowY] >= 'a' && board[nowX][nowY] <= 'f') { // 키를 만났다면
                            // 가진 키 업데이트 // error
                            int newHasKey = hasKey | (1 << (board[nowX][nowY] - 'a'));

                            // 방문 처리하기 // 키 추가전 방문도 해줘야함?
                            visited[newHasKey][nowX][nowY] = true;

                            // 큐에 넣기
                            que.offer(new int[]{nowX, nowY, distance + 1, newHasKey});

                        } else if (board[nowX][nowY] >= 'A' && board[nowX][nowY] <= 'F') { // 문을 만났다면
                            if ((hasKey & (1 << (board[nowX][nowY] - 'A'))) > 0) { // 키가 있다면
                                // 방문 처리
                                visited[hasKey][nowX][nowY] = true;

                                // 큐에 추가
                                que.offer(new int[]{nowX, nowY, distance + 1, hasKey});
                            }
                        }
                    }

                }
            }
        }

        if (!isFin)
            System.out.println("-1");
    }

}
